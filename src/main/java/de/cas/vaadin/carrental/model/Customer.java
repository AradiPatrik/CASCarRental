package de.cas.vaadin.carrental.model;

public class Customer {
	private String name;
	private Credentals credentals;
	private ContactInfo contactInfo;
	
	public Customer(Credentals credentals, String name, ContactInfo contactInfo) {
		super();
		this.credentals = credentals;
		this.name = name;
		this.contactInfo = contactInfo;
	}
	
	public Credentals getCredentals() {
		return credentals;
	}
	public void setCredentals(Credentals credentals) {
		this.credentals = credentals;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ContactInfo getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}
	
}
