package de.cas.vaadin.carrental.service.rental;

import java.util.List;

import de.cas.vaadin.carrental.model.Rental;

public interface RentalService {
	List<Rental> getAllRentals();
	List<Rental> addRental(Rental rental);
	void ensureData();
}
