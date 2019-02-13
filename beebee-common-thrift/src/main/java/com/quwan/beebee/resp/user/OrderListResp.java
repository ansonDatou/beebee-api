package com.quwan.beebee.resp.user;

import java.util.List;

/**
 * Created by anson on 2017/12/5.
 * 订单列表返回参数
 */
public class OrderListResp {

    private Integer id;
    private Integer amount;
    private String sn;
    private String phone;
    private String addTime;
    private Integer status;
    private String address;
    private String consignee;
    private List<GoodsOrderResp> goodsList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public List<GoodsOrderResp> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsOrderResp> goodsList) {
        this.goodsList = goodsList;
    }

    @Override
    public String toString() {
        return "OrderListResp{" +
                "id=" + id +
                ", amount=" + amount +
                ", sn='" + sn + '\'' +
                ", phone='" + phone + '\'' +
                ", addTime='" + addTime + '\'' +
                ", status=" + status +
                ", address='" + address + '\'' +
                ", consignee='" + consignee + '\'' +
                ", goodsList=" + goodsList +
                '}';
    }
}
