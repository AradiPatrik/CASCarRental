package de.cas.vaadin.carrental.model;

public class Address {

	private String city;
	private String street;
	private String houseNumber;
	
	public Address(String country, String street, String houseNumber) {
		super();
		this.city = country;
		this.street = street;
		this.houseNumber = houseNumber;
	}
	
	public String getCountry() {
		return city;
	}
	public void setCountry(String country) {
		this.city = country;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	
	
}
