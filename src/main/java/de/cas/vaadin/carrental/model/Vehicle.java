package de.cas.vaadin.carrental.model;

public class Vehicle {
	private String manufacturer;
	private String type;
	private double dailyPrice;
	private VehicleState vehicleState;
	private String numberPlate;
	
	public Vehicle(String manufacturer, String type, double dailyPrice, VehicleState vehicleState, String numberPlate) {
		super();
		this.manufacturer = manufacturer;
		this.type = type;
		this.dailyPrice = dailyPrice;
		this.vehicleState = vehicleState;
		this.numberPlate = numberPlate;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getDailyPrice() {
		return dailyPrice;
	}
	public void setDailyPrice(double dailyPrice) {
		this.dailyPrice = dailyPrice;
	}
	public VehicleState getVehicleState() {
		return vehicleState;
	}
	public void setVehicleState(VehicleState vehicleState) {
		this.vehicleState = vehicleState;
	}
	public String getNumberPlate() {
		return numberPlate;
	}
	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}
	
}
