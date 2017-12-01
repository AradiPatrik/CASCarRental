package de.cas.vaadin.carrental.presenter;

import java.util.List;

import com.vaadin.data.util.BeanContainer;

import de.cas.vaadin.carrental.model.Rental;
import de.cas.vaadin.carrental.service.Services;
import de.cas.vaadin.carrental.service.rental.RentalService;
import de.cas.vaadin.carrental.utils.ContainerUtils;
import de.cas.vaadin.carrental.view.rentals.RentalsView;
import de.cas.vaadin.carrental.view.rentals.RentalsView.RentalsViewListener;

public class RentalsPresenter implements RentalsViewListener {
	
	private final RentalService rentalService = Services.getRentalService();
	private final RentalsView rentalsView;
	
	public RentalsPresenter(RentalsView rentalsView) {
		this.rentalsView = rentalsView;
		this.rentalsView.addListener(this);
		this.rentalsView.attachRentalData(ContainerUtils.convertRentalListToRentalBeanContainer(this.rentalService.getAllRentals()));
		setHumanReadeableHeader();
		hideUnnecessaryColumnsInTable();
	}
	
	private void setHumanReadeableHeader() {
		this.rentalsView.setColumnHeader("customer.name", "Customer Name");
		this.rentalsView.setColumnHeader("vehicle.manufacturer", "Vehicle Manufacturer");
		this.rentalsView.setColumnHeader("vehicle.type", "Vehicle Type");
		this.rentalsView.setColumnHeader("vehicle.numberPlate", "Numberplate");
	}
	
	
	private void hideUnnecessaryColumnsInTable() {
		this.rentalsView.setVisibleColumns("customer.name", "vehicle.manufacturer", "vehicle.type", "vehicle.numberPlate");
	}

	@Override
	public void onViewEnter() {
		this.rentalsView.attachRentalData(ContainerUtils.convertRentalListToRentalBeanContainer(this.rentalService.getAllRentals()));
		setHumanReadeableHeader();
		hideUnnecessaryColumnsInTable();
	}
}
