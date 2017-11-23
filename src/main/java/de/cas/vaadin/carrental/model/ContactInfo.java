package de.cas.vaadin.carrental.model;

public class ContactInfo {
	String telephoneNumber;
	Address address;
	
	public ContactInfo(String telephoneNumber, Address address) {
		super();
		this.telephoneNumber = telephoneNumber;
		this.address = address;
	}
	
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
}
