package de.cas.vaadin.carrental.service.vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import de.cas.vaadin.carrental.model.Euro;
import de.cas.vaadin.carrental.model.Vehicle;
import de.cas.vaadin.carrental.model.VehicleState;

public class VehicleServiceImpl implements VehicleService {

	private List<Vehicle> vehicles = new ArrayList<>();

	public VehicleServiceImpl() {
		ensureData();
	}

	@Override
	public List<Vehicle> getVehicles() {
		return this.vehicles;
	}

	@Override
	public List<Vehicle> getUndeletedVehicles() {
		return this.vehicles.stream()
							 .filter(this::isVehicleNotDeleted)
							 .collect(Collectors.toList());
	}
	
	private boolean isVehicleNotDeleted(Vehicle vehicle) {
		return vehicle.getVehicleState() != VehicleState.DELETED;
	}
	
	@Override
	public List<Vehicle> delete(Vehicle vehicle) {
		for (Vehicle element : this.vehicles) {
			if (element.equals(vehicle)) {
				vehicle.setVehicleState(VehicleState.DELETED);
			}
		}
		return this.vehicles;
	}
	
	@Override
	public List<Vehicle> delete(String numberPlate) {
		for (Vehicle element : this.vehicles) {
			if (element.getNumberPlate().equals(numberPlate)) {
				element.setVehicleState(VehicleState.DELETED);
			}
		}
		return this.vehicles;
	}
	
	@Override
	public List<Vehicle> getReadyToGoVehicles() {
		return this.vehicles.stream().filter(e -> e.getVehicleState() == VehicleState.READY_TO_GO).collect(Collectors.toList());
	}

	@Override
	public Optional<Vehicle> getVehicle(String numberPlate) {
		return this.vehicles.stream().filter(e -> e.getNumberPlate().equals(numberPlate)).findFirst();
	}
	
	@Override
	public List<Vehicle> addVehicle(Vehicle vehicle) {
		this.vehicles.add(vehicle);
		return this.vehicles;
	}

	@Override
	public List<Vehicle> setVehicleStatusToBorrowed(Vehicle vehicle) {
		Optional<Vehicle> optionalVehicle = this.vehicles.stream().filter(e -> e.getNumberPlate().equals(vehicle.getNumberPlate())).findFirst();
		if (optionalVehicle.isPresent()) {
			optionalVehicle.get().setVehicleState(VehicleState.BORROWED);
		}
		return null;
	}

	private void ensureData() {
		vehicles.add(new Vehicle("Mercedez", "Fast", new Euro(100), VehicleState.READY_TO_GO, "GKA 569"));
		vehicles.add(new Vehicle("VolksWagen", "Golf", new Euro(200), VehicleState.READY_TO_GO, "GFA 269"));
		vehicles.add(new Vehicle("Renault", "Clio", new Euro(89), VehicleState.READY_TO_GO, "FFE 789"));
		vehicles.add(new Vehicle("Mercedez", "Lux", new Euro(50), VehicleState.READY_TO_GO, "HFE 834"));
		vehicles.add(new Vehicle("Mercedez", "Fast", new Euro(453), VehicleState.READY_TO_GO, "GKA 569"));
		vehicles.add(new Vehicle("BMW", "M5", new Euro(42), VehicleState.DELETED, "RJS 469"));
		vehicles.add(new Vehicle("Ford", "Focus", new Euro(500), VehicleState.READY_TO_GO, "HEJ 342"));
		vehicles.add(new Vehicle("Mercedez", "Slow", new Euro(34), VehicleState.READY_TO_GO, "GKK 342"));
		vehicles.add(new Vehicle("Tesla", "Model 3", new Euro(400), VehicleState.DELETED, "HJK 453"));
		vehicles.add(new Vehicle("Toyota", "Corolla", new Euro(25), VehicleState.READY_TO_GO, "KJI 342"));
		vehicles.add(new Vehicle("Peugeot", "306", new Euro(34), VehicleState.READY_TO_GO, "KLE 892"));
		vehicles.add(new Vehicle("Citroen", "Picasso", new Euro(100), VehicleState.READY_TO_GO, "HHH 342"));
		vehicles.add(new Vehicle("Ford", "Mustang", new Euro(600), VehicleState.READY_TO_GO, "JJJ 381"));
	}


}
