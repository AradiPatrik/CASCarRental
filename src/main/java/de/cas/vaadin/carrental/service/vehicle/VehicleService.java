package de.cas.vaadin.carrental.service.vehicle;

import java.util.List;

import de.cas.vaadin.carrental.model.Vehicle;

public interface VehicleService {
	List<Vehicle> getVehicles();
	List<Vehicle> getUndeletedVehicles();
	List<Vehicle> delete(Vehicle vehicle);
	List<Vehicle> delete(String numberPlate);
}
