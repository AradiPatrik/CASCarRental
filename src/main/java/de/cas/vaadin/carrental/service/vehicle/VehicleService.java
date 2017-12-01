package de.cas.vaadin.carrental.service.vehicle;

import java.util.List;
import java.util.Optional;

import de.cas.vaadin.carrental.model.Vehicle;

public interface VehicleService {
	List<Vehicle> getVehicles();
	List<Vehicle> getUndeletedVehicles();
	Optional<Vehicle> getVehicle(String numberPlate);
	List<Vehicle> delete(Vehicle vehicle);
	List<Vehicle> delete(String numberPlate);
	List<Vehicle> getReadyToGoVehicles();
	List<Vehicle> addVehicle(Vehicle vehicle);
	List<Vehicle> setVehicleStatusToBorrowed(Vehicle vehicle);
}
