package com.quwan.beebee.resp.user;

/**
 * 用户登陆返回的信息
 * 
 * @author chan
 *
 */
public class UserInfoResp {

	private String id;

	private String nicker;

	private String head;

	private Integer integral;

	private String signature;

	public String getNicker() {
		return nicker;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public void setNicker(String nicker) {
		this.nicker = nicker;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	@Override
	public String toString() {
		return "UserInfoResp [id=" + id + ", nicker=" + nicker + ", head="
				+ head + ", integral=" + integral + ", signature=" + signature
				+ "]";
	}

}
