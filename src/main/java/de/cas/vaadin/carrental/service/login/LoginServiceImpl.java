package de.cas.vaadin.carrental.service.login;

import java.util.Optional;

import de.cas.vaadin.carrental.model.Customer;
import de.cas.vaadin.carrental.service.Services;
import de.cas.vaadin.carrental.service.customer.CustomerService;
import de.cas.vaadin.carrental.service.customer.CustomerServiceImpl;
import de.cas.vaadin.carrental.service.exception.UserNotFoundException;
import de.cas.vaadin.carrental.service.exception.WrongPasswordException;

public class LoginServiceImpl implements LoginService {

	private CustomerService customerService;

	public LoginServiceImpl() {
		this.customerService = Services.getCustomerService();
	}

	@Override
	public Customer authenticateAndGetUser(String username, String password) throws UserNotFoundException, WrongPasswordException{
		Optional<Customer> optionalCustomer = this.customerService.getCustomer(username);
		if (optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get();
			if (customer.getCredentals().getPassword().equals(password)) {
				return customer;
			} else {
				throw new WrongPasswordException();
			}
		} else {
			throw new UserNotFoundException();
		}
	}

}
