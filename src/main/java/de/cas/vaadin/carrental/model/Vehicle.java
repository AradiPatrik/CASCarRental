package de.cas.vaadin.carrental.model;

public class Vehicle {
	private String manufacturer;
	private String type;
	private Euro dailyPrice;
	private VehicleState vehicleState;
	private String numberPlate;
	
	public Vehicle(String manufacturer, String type, Euro dailyPrice, VehicleState vehicleState, String numberPlate) {
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
	public Euro getDailyPrice() {
		return dailyPrice;
	}
	public void setDailyPrice(Euro dailyPrice) {
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
	
	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		} else {
			return this.numberPlate.equals(((Vehicle)other).numberPlate);
		}
	}

	@Override
	public String toString() {
		return "Vehicle [manufacturer=" + manufacturer + ", type=" + type + ", dailyPrice=" + dailyPrice
				+ ", vehicleState=" + vehicleState + ", numberPlate=" + numberPlate + "]";
	}
	
}
