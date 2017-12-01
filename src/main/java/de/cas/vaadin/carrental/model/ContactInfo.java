package de.cas.vaadin.carrental.model;

public class ContactInfo {
	String telephoneNumber;
	String address;
	
	public ContactInfo(String telephoneNumber, String address) {
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
