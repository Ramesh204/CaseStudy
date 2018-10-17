package com.training.entity;

public class Car {
	
	private String carNumber;
	private String carModel;
	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public Car(String carNumber, String carModel) {
		super();
		this.carNumber = carNumber;
		this.carModel = carModel;
	}

	public Car(String carNumber) {
		super();
		this.carNumber = carNumber;
	}

	public Car() {
		super();
		
	}

	
	
	
}
