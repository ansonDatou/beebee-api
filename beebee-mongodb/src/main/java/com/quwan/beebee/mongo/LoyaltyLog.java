package com.quwan.beebee.mongo;

import java.util.List;

import org.jongo.marshall.jackson.oid.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "T_LoyaltyLog")
public class LoyaltyLog {

	@Id
	private int code;

	private String name;

	private String reward;

	private Integer finished;

	private List<LoyaltyDetail> detail;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReward() {
		return reward;
	}

	public void setReward(String reward) {
		this.reward = reward;
	}

	public Integer getFinished() {
		return finished;
	}

	public void setFinished(Integer finished) {
		this.finished = finished;
	}

	public List<LoyaltyDetail> getDetail() {
		return detail;
	}

	public void setDetail(List<LoyaltyDetail> detail) {
		this.detail = detail;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "LoyaltyLog [code=" + code + ", name=" + name + ", reward=" + reward + ", finished=" + finished
				+ ", detail=" + detail + "]";
	}
	
}
