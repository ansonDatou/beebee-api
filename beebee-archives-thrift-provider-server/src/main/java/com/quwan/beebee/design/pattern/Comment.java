package com.quwan.beebee.design.pattern;


import com.quwan.beebee.dao.ArchivesDao;
import com.quwan.beebee.param.archives.ArchivesCommentParam;

public interface Comment {

    public String doComment(ArchivesCommentParam param, ArchivesDao archivesDao);
}
