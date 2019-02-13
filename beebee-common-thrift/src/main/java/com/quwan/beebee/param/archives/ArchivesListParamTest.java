package com.quwan.beebee.param.archives;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * getList接口参数
 * Created by anson on 2017/10/23.
 */

public class ArchivesListParamTest implements Serializable{

    private static final long serialVersionUID = 1L;

    /* 用户id */
    @NotEmpty(message = "userid not be empty")
    @Min(value = 1, message = "Invalid expiry date")
    private Integer userid;

    /* 请求源类别 1为图文 2为视频 */
    @NotEmpty(message = "sourcetype not be empty")
    private Integer sourcetype;

    /* 页码 */
    @NotEmpty(message = "pagenumber not be empty")
    @Min(value = 1, message = "Invalid expiry date")
    private Integer pagenumber;

    /* 每页数据量 */
    @NotEmpty(message = "pagenumber not be empty")
    @Min(value = 1, message = "Invalid expiry date")
    private Integer pagesize;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getSourcetype() {
        return sourcetype;
    }

    public void setSourcetype(Integer sourcetype) {
        this.sourcetype = sourcetype;
    }

    public Integer getPagenumber() {
        return pagenumber;
    }

    public void setPagenumber(Integer pagenumber) {
        this.pagenumber = pagenumber;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    @Override
    public String toString() {
        return "ArchivesListParamTest{" +
                "userid=" + userid +
                ", sourcetype=" + sourcetype +
                ", pagenumber=" + pagenumber +
                ", pagesize=" + pagesize +
                '}';
    }
}
