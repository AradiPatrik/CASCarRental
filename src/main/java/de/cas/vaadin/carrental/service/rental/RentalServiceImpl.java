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
	
	@Override
	public List<Rental> getAllRentals() {
		return this.rentals;
	}

	@Override
	public void ensureData() {
		this.rentals.add(new Rental(customerService.getCustomer("Patrik Aradi").get(), vehicleService.getVehicle("GKA 569").get(), LocalDate.now(), LocalDate.now().plusMonths(1)));
		this.rentals.add(new Rental(customerService.getCustomer("John Smith").get(), vehicleService.getVehicle("GFA 269").get(), LocalDate.now(), LocalDate.now().plusMonths(2)));
		this.rentals.add(new Rental(customerService.getCustomer("Fekete Emil").get(), vehicleService.getVehicle("FFE 789").get(), LocalDate.now(), LocalDate.now().plusMonths(1)));
		this.rentals.add(new Rental(customerService.getCustomer("Hajdu Levente").get(), vehicleService.getVehicle("HFE 834").get(), LocalDate.now(), LocalDate.now().plusMonths(3)));
		this.rentals.add(new Rental(customerService.getCustomer("Zsakos Frodo").get(), vehicleService.getVehicle("RJS 469").get(), LocalDate.now(), LocalDate.now().plusMonths(1)));
		this.rentals.add(new Rental(customerService.getCustomer("Regexp Jano").get(), vehicleService.getVehicle("HEJ 342").get(), LocalDate.now(), LocalDate.now().plusMonths(5)));
		this.rentals.add(new Rental(customerService.getCustomer("Pal Annabella").get(), vehicleService.getVehicle("JJJ 381").get(), LocalDate.now(), LocalDate.now().plusMonths(1)));
	}
}
