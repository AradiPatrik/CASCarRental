package de.cas.vaadin.carrental.model;

public enum VehicleState {
	READY_TO_GO("Ready To Go"),
	BORROWED("Borrowed"),
	DELETED("Deleted");
	
	private final String value;
	
	private VehicleState(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
