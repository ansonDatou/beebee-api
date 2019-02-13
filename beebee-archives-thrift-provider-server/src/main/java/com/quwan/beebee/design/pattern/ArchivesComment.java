package com.quwan.beebee.design.pattern;

import com.alibaba.fastjson.JSON;
import com.quwan.beebee.dao.ArchivesDao;
import com.quwan.beebee.entity.archives.Archives;
import com.quwan.beebee.exception.ErrorCode;
import com.quwan.beebee.param.archives.ArchivesCommentParam;
import com.quwan.beebee.utils.Result;

public class ArchivesComment implements Comment {
    @Override
    public String doComment(ArchivesCommentParam param, ArchivesDao archivesDao) {

        // 添加评论
        archivesDao.addComment(param);

        // 修改评论数量
        archivesDao.syncCommentCount(Integer.valueOf(param.getArchId()));

        // 查询文章是否为空
        Archives resp = archivesDao.getArchiveById(Integer.valueOf(param.getArchId()));
        if (resp == null) {
            return JSON.toJSONString(Result.response(ErrorCode.FailedObtainDetails));
        }

        return JSON.toJSONString(Result.success());
    }
}
