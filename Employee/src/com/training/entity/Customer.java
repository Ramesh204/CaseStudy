package com.training.entity;

public class Customer {
	
	private long customerId;
	private String customerName;
	private String mobileNumber;
	private Car car;
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Customer(long customerId, String customerName, String mobileNumber, Car car) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.car = car;
	}
	
	public Customer(long customerId, String customerName, String mobileNumber) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
	}
	
	
	public Customer() {
		super();
	
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", mobileNumber="
				+ mobileNumber + ", car=" + car + "]";
	}
	
	
	
}
