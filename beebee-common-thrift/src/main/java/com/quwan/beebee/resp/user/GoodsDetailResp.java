package com.quwan.beebee.resp.user;

/**
 * Created by anson on 2017/12/5.
 * 商品详情返回参数
 */
public class GoodsDetailResp {

    private Integer id;
    private Integer orgPrice;
    private String detail;
    private String price;
    private String name;
    private String buyroles;
    private Integer number;
    private String listPic;
    private String pic1;
    private String pic2;
    private String pic3;
    private String pic4;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrgPrice() {
        return orgPrice;
    }

    public void setOrgPrice(Integer orgPrice) {
        this.orgPrice = orgPrice;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuyroles() {
        return buyroles;
    }

    public void setBuyroles(String buyroles) {
        this.buyroles = buyroles;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getListPic() {
        return listPic;
    }

    public void setListPic(String listPic) {
        this.listPic = listPic;
    }

    public String getPic1() {
        return pic1;
    }

    public void setPic1(String pic1) {
        this.pic1 = pic1;
    }

    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2;
    }

    public String getPic3() {
        return pic3;
    }

    public void setPic3(String pic3) {
        this.pic3 = pic3;
    }

    public String getPic4() {
        return pic4;
    }

    public void setPic4(String pic4) {
        this.pic4 = pic4;
    }

    @Override
    public String toString() {
        return "GoodsDetailResp{" +
                "id=" + id +
                ", orgPrice=" + orgPrice +
                ", detail='" + detail + '\'' +
                ", price='" + price + '\'' +
                ", name='" + name + '\'' +
                ", buyroles='" + buyroles + '\'' +
                ", number=" + number +
                ", listPic='" + listPic + '\'' +
                ", pic1='" + pic1 + '\'' +
                ", pic2='" + pic2 + '\'' +
                ", pic3='" + pic3 + '\'' +
                ", pic4='" + pic4 + '\'' +
                '}';
    }
}
