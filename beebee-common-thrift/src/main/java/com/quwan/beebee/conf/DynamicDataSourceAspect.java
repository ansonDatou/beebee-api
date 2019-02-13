package com.quwan.beebee.conf;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * 动态数据源切换的切面，切 DAO 层，通过 DAO 层方法名判断使用哪个数据源，实现数据源切换 关于切面的 Order 可以可以不设，
 * 因为 @Transactional 是最低的，取决于其他切面的设置，并且在 org.springframework.core.annotation.AnnotationAwareOrderComparator 会重新排序
 */
@Aspect
@Component
public class DynamicDataSourceAspect {
    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    private final String[] QUERY_PREFIX = {"get", "query", "find", "select", "is"};

    @Pointcut("execution(* com.quwan.beebee.service.impl.*.*(..))")
    public void daoAspect() {
    }

    @Before("daoAspect()")
    public void switchDataSource(JoinPoint point) {
        logger.info("--------------------------------------------------");
        logger.info("    Class Name ----> "+ point.getTarget().getClass().getName());
        logger.info("    Method Name ----> "+ point.getSignature().getName());
        logger.info("--------------------------------------------------");

        Boolean isQueryMethod = isQueryMethod(point.getSignature().getName());
        logger.info("--------------------------------------------------");
        logger.info("    Var ----> true 从数据源, false 主数据源 ----> "+ isQueryMethod);
        logger.info("--------------------------------------------------");

        if (isQueryMethod) {
            DynamicDataSourceContextHolder.useSlaveDataSource();
            logger.debug("Switch DataSource to [{}] in Method [{}]", DynamicDataSourceContextHolder.getDataSourceKey(), point.getSignature());
        }

        if (!isQueryMethod) {
            logger.info("分割线====================================================================================================分割线");
        }
    }

    @After("daoAspect())")
    public void restoreDataSource(JoinPoint point) {
        DynamicDataSourceContextHolder.clearDataSourceKey();
        logger.debug("Restore DataSource to [{}] in Method [{}]", DynamicDataSourceContextHolder.getDataSourceKey(), point.getSignature());
    }

    private Boolean isQueryMethod(String methodName) {
        for (String prefix : QUERY_PREFIX) {
            if (methodName.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }
}
