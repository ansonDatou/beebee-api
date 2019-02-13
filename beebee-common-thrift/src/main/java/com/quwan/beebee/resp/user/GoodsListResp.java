package com.quwan.beebee.resp.user;

/**
 * Created by anson on 2017/12/5.
 * 商品列表返回参数
 */
public class GoodsListResp {

    private Integer id;
    private String price;
    private String name;
    private String number;
    private String listPic;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getListPic() {
        return listPic;
    }

    public void setListPic(String listPic) {
        this.listPic = listPic;
    }
}
