package de.cas.vaadin.carrental.service.rental;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.cas.vaadin.carrental.model.Rental;
import de.cas.vaadin.carrental.service.Services;
import de.cas.vaadin.carrental.service.customer.CustomerService;
import de.cas.vaadin.carrental.service.vehicle.VehicleService;

public class RentalServiceImpl implements RentalService {

	private List<Rental> rentals = new ArrayList<>();
	private CustomerService customerService = Services.getCustomerService();
	private VehicleService vehicleService = Services.getVehicleService();
	
	public RentalServiceImpl() {
		ensureData();
	}
	
	@Override
	public List<Rental> getAllRentals() {
		return this.rentals;
	}

	@Override
	public void ensureData() {
		this.rentals.add(new Rental(1, customerService.getCustomer("aradipatrik").get(), vehicleService.getVehicle("GKA 569").get(), LocalDate.now(), LocalDate.now().plusMonths(1)));
		this.rentals.add(new Rental(2, customerService.getCustomer("johnsmith").get(), vehicleService.getVehicle("GFA 269").get(), LocalDate.now(), LocalDate.now().plusMonths(2)));
		this.rentals.add(new Rental(3, customerService.getCustomer("feketeemil").get(), vehicleService.getVehicle("FFE 789").get(), LocalDate.now(), LocalDate.now().plusMonths(1)));
		this.rentals.add(new Rental(4, customerService.getCustomer("hajdulevente").get(), vehicleService.getVehicle("HFE 834").get(), LocalDate.now(), LocalDate.now().plusMonths(3)));
		this.rentals.add(new Rental(5, customerService.getCustomer("zsakosfrodo").get(), vehicleService.getVehicle("RJS 469").get(), LocalDate.now(), LocalDate.now().plusMonths(1)));
		this.rentals.add(new Rental(6, customerService.getCustomer("regexpjano").get(), vehicleService.getVehicle("HEJ 342").get(), LocalDate.now(), LocalDate.now().plusMonths(5)));
		this.rentals.add(new Rental(7, customerService.getCustomer("palannabella").get(), vehicleService.getVehicle("JJJ 381").get(), LocalDate.now(), LocalDate.now().plusMonths(1)));
	}
}
