package de.cas.vaadin.carrental.service.customer;

import java.util.Optional;

import de.cas.vaadin.carrental.model.Customer;

public interface CustomerService {
	Optional<Customer> getCustomer(String username);
}
