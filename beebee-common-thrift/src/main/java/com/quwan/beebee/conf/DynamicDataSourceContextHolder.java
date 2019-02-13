package com.quwan.beebee.conf;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 该类为数据源上下文配置，用于切换数据源
 */
public class DynamicDataSourceContextHolder {

    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceContextHolder.class);

    // 用于在切换数据源时保证不会被其他线程修改
    private static Lock lock = new ReentrantLock();

    // 用于轮循的计数器
    private static int counter = 0;

    // 为每个线程维护变量，以避免影响其他线程
    private static final ThreadLocal<String> CONTEXT_HOLDER = ThreadLocal.withInitial(DataSourceKey.first::name);

    // 所有数据源key
    public static List<Object> dataSourceKeys = new ArrayList<>();

    // 从数据源key
    public static List<Object> slaveDataSourceKeys = new ArrayList<>();

    public static void setDataSourceKey(String key) {
        CONTEXT_HOLDER.set(key);
    }

    public static void useMasterDataSource() {
        CONTEXT_HOLDER.set(DataSourceKey.first.name());
    }

    public static String getDataSourceKey() {
        return CONTEXT_HOLDER.get();
    }

    public static void clearDataSourceKey() {
        CONTEXT_HOLDER.remove();
    }

    public static boolean containDataSourceKey(String key) {
        return dataSourceKeys.contains(key);
    }

    /**
     * 当使用只读数据源时通过轮循方式选择要使用的数据源
     */
    public static void useSlaveDataSource() {
        lock.lock();
        try {
            int datasourceKeyIndex = counter % slaveDataSourceKeys.size();
            CONTEXT_HOLDER.set(String.valueOf(slaveDataSourceKeys.get(datasourceKeyIndex)));
            counter++;
        } catch (Exception e) {
            logger.error("Switch slave datasource failed, error message is {}", e.getMessage());
            useMasterDataSource();
            e.printStackTrace();
        } finally {
            logger.info("--------------------------------------------------");
            logger.info("    Var ----> CONTEXT_HOLDER.get() ----> "+ CONTEXT_HOLDER.get());
            logger.info("--------------------------------------------------");
            logger.info("分割线====================================================================================================分割线");

            lock.unlock();
        }
    }
}
