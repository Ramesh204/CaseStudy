package com.training.entity;

public class Service {
	
	private long serviceId;
	private String serviceType;
	private long serviceAmount;
	private Car car;
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public long getServiceId() {
		return serviceId;
	}
	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public long getServiceAmount() {
		return serviceAmount;
	}
	public void setServiceAmount(long serviceAmount) {
		this.serviceAmount = serviceAmount;
	}
	public Service(long serviceId, String serviceType, long serviceAmount) {
		super();
		this.serviceId = serviceId;
		this.serviceType = serviceType;
		this.serviceAmount = serviceAmount;
	}
	public Service(long serviceId, String serviceType, long serviceAmount, Car car) {
		super();
		this.serviceId = serviceId;
		this.serviceType = serviceType;
		this.serviceAmount = serviceAmount;
		this.car = car;
	}
	public Service() {
		super();
		
	}
	
}
