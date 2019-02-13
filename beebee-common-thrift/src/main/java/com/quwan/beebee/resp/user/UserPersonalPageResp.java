package com.quwan.beebee.resp.user;

import java.util.List;

import com.quwan.beebee.entity.user.UserIdentity;

public class UserPersonalPageResp {

	private int userId;

	private String head;

	private int sex;

	private int age;
	
	private String nicker;
	
	private String signature;
	
	private int partTopics;
	
	private int startTopics;
	
	private int archComments;
	
	private List<UserIdentity> identityList;

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNicker() {
		return nicker;
	}

	public void setNicker(String nicker) {
		this.nicker = nicker;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public List<UserIdentity> getIdentityList() {
		return identityList;
	}

	public void setIdentityList(List<UserIdentity> identityList) {
		this.identityList = identityList;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPartTopics() {
		return partTopics;
	}

	public void setPartTopics(int partTopics) {
		this.partTopics = partTopics;
	}

	public int getStartTopics() {
		return startTopics;
	}

	public void setStartTopics(int startTopics) {
		this.startTopics = startTopics;
	}

	public int getArchComments() {
		return archComments;
	}

	public void setArchComments(int archComments) {
		this.archComments = archComments;
	}

	@Override
	public String toString() {
		return "UserPersonalPageResp [userId=" + userId + ", head=" + head + ", sex=" + sex + ", age=" + age
				+ ", nicker=" + nicker + ", signature=" + signature +  ", partTopics="
				+ partTopics + ", startTopics=" + startTopics + ", archComments=" + archComments + ", identityList="
				+ identityList + "]";
	}


}
