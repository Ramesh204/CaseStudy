package com.training.entity;

public class Policy {
	
	private String carNumber;
	private long policyId;
	private String policyName;
	private long policyAmount;
	
	
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public long getPolicyId() {
		return policyId;
	}
	public void setPolicyId(long policyId) {
		this.policyId = policyId;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public long getPolicyAmount() {
		return policyAmount;
	}
	public void setPolicyAmount(long policyAmount) {
		this.policyAmount = policyAmount;
	}
	public Policy(String carNumber, long policyId, String policyName, long policyAmount) {
		super();
		this.carNumber = carNumber;
		this.policyId = policyId;
		this.policyName = policyName;
		this.policyAmount = policyAmount;
	}
	public Policy() {
		super();

	}
	@Override
	public String toString() {
		return "Insurance [carNumber=" + carNumber + ", policyId=" + policyId + ", policyName=" + policyName
				+ ", policyAmount=" + policyAmount + "]";
	}
	
	
}
