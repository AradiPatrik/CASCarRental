package de.cas.vaadin.carrental.presenter;

import java.util.List;

import com.vaadin.data.util.BeanContainer;

import de.cas.vaadin.carrental.model.Rental;
import de.cas.vaadin.carrental.service.Services;
import de.cas.vaadin.carrental.service.rental.RentalService;
import de.cas.vaadin.carrental.view.rentals.RentalsView;
import de.cas.vaadin.carrental.view.rentals.RentalsView.RentalsViewListener;

public class RentalsPresenter implements RentalsViewListener {
	
	private final RentalService rentalService = Services.getRentalService();
	private final RentalsView rentalsView;
	
	public RentalsPresenter(RentalsView rentalsView) {
		this.rentalsView = rentalsView;
		this.rentalsView.addListener(this);
		this.rentalsView.attachRentalData(convertListToBeanContainer(this.rentalService.getAllRentals()));
		this.rentalsView.setColumnHeader("customer.name", "Customer Name");
		this.rentalsView.setColumnHeader("vehicle.manufacturer", "Vehicle Manufacturer");
		this.rentalsView.setColumnHeader("vehicle.type", "Vehicle Type");
		this.rentalsView.setColumnHeader("vehicle.numberPlate", "Numberplate");
		hideUnnecessaryColumnsInTable();
	}
	
	private BeanContainer<Integer, Rental> convertListToBeanContainer(List<Rental> rentals) {
		BeanContainer<Integer, Rental> rentalBeanContainer = new BeanContainer<Integer, Rental>(Rental.class);
		rentalBeanContainer.setBeanIdProperty("id");
		rentalBeanContainer.addNestedContainerProperty("customer.name");
		rentalBeanContainer.addNestedContainerProperty("vehicle.manufacturer");
		rentalBeanContainer.addNestedContainerProperty("vehicle.type");
		rentalBeanContainer.addNestedContainerProperty("vehicle.numberPlate");
		rentals.forEach(e -> {
			rentalBeanContainer.addBean(e);
		});
		return rentalBeanContainer;
	}
	
	private void hideUnnecessaryColumnsInTable() {
		this.rentalsView.setVisibleColumns("customer.name", "vehicle.manufacturer", "vehicle.type", "vehicle.numberPlate");
	}
}
