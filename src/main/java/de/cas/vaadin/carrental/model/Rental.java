package de.cas.vaadin.carrental.model;

import java.time.LocalDate;

public class Rental {
	private Integer id;
	private Customer customer;
	private Vehicle vehicle;
	private LocalDate startDate;
	private LocalDate endDate;
	
	public Rental(Integer id, Customer customer, Vehicle vehicle, LocalDate startDate, LocalDate endDate) {
		super();
		this.id = id;
		this.customer = customer;
		this.vehicle = vehicle;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	
}
