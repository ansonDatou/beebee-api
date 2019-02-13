package com.quwan.beebee.resp.user;

import java.math.BigDecimal;

public class ExchangeResp {

	private String name;
	private int orgprice;
	private BigDecimal purchaseprice;
	private String pic1;
	private String orderId;
	private int goodsId;
	private String goodsName;
	private int goodsPrice;
	private int goodsNumber;
	private int goodsPurchase;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrgprice() {
		return orgprice;
	}

	public void setOrgprice(int orgprice) {
		this.orgprice = orgprice;
	}

	public BigDecimal getPurchaseprice() {
		return purchaseprice;
	}

	public void setPurchaseprice(BigDecimal purchaseprice) {
		this.purchaseprice = purchaseprice;
	}

	public String getPic1() {
		return pic1;
	}

	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public int getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(int goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public int getGoodsPurchase() {
		return goodsPurchase;
	}

	public void setGoodsPurchase(int goodsPurchase) {
		this.goodsPurchase = goodsPurchase;
	}

	@Override
	public String toString() {
		return "ExchangeResp [name=" + name + ", orgprice=" + orgprice
				+ ", purchaseprice=" + purchaseprice + ", pic1=" + pic1
				+ ", orderId=" + orderId + ", goodsId=" + goodsId
				+ ", goodsName=" + goodsName + ", goodsPrice=" + goodsPrice
				+ ", goodsNumber=" + goodsNumber + ", goodsPurchase="
				+ goodsPurchase + "]";
	}

}
