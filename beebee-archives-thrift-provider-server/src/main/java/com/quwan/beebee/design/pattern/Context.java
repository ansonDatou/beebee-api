package com.quwan.beebee.design.pattern;


import com.quwan.beebee.dao.ArchivesDao;
import com.quwan.beebee.param.archives.ArchivesCommentParam;

public class Context {

    private Comment comment;
    public Context(Comment comment) {
        this.comment = comment;
    }

    public String execute(ArchivesCommentParam param, ArchivesDao archivesDao) {
        return comment.doComment(param, archivesDao);
    }
}
