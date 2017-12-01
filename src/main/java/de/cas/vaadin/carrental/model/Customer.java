package de.cas.vaadin.carrental.model;

public class Customer {
	private String name;
	private Credentals credentials;
	private ContactInfo contactInfo;
	
	public Customer(Credentals credentials, String name, ContactInfo contactInfo) {
		super();
		this.credentials = credentials;
		this.name = name;
		this.contactInfo = contactInfo;
	}
	
	public Credentals getCredentials() {
		return credentials;
	}
	public void setCredentials(Credentals credentials) {
		this.credentials = credentials;
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
