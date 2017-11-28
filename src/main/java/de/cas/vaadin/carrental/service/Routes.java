package de.cas.vaadin.carrental.service;

public enum Routes {
	LOGIN(""),
	VEHICLES("vehicles"),
	CUSTOMERS("customers"),
	RENTALS("rentals"),
	NEW_RENTAL("rentals/new");
	
	private final String path;
	
	private Routes(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return this.path;
	}
}
