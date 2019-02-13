package com.quwan.beebee.design.pattern;

import com.alibaba.fastjson.JSON;
import com.quwan.beebee.dao.ArchivesDao;
import com.quwan.beebee.entity.archives.Archives;
import com.quwan.beebee.exception.ErrorCode;
import com.quwan.beebee.param.archives.ArchivesCommentParam;
import com.quwan.beebee.utils.Result;

public class ReplyTwoComment implements Comment{
    @Override
    public String doComment(ArchivesCommentParam param, ArchivesDao archivesDao) {

        // 回复评论的回复
        Integer archId = archivesDao.getArchiveIdByAnswerId(Integer.valueOf(param.getArchId()));
        if (archId == null) {
            return JSON.toJSONString(Result.response(ErrorCode.UserParamIsError));
        }

        param.setArchId(String.valueOf(archId));

        // 查询文章是否为空
        Archives resp = archivesDao.getArchiveById(archId);
        if (resp == null) {
            return JSON.toJSONString(Result.response(ErrorCode.FailedObtainDetails));
        }

        return JSON.toJSONString(Result.success());
    }
}
