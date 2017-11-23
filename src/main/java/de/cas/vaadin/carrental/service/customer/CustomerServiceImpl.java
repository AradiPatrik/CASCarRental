package de.cas.vaadin.carrental.service.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import de.cas.vaadin.carrental.model.Address;
import de.cas.vaadin.carrental.model.ContactInfo;
import de.cas.vaadin.carrental.model.Credentals;
import de.cas.vaadin.carrental.model.Customer;

public class CustomerServiceImpl implements CustomerService {

	List<Customer> customers = new ArrayList<>();

	public CustomerServiceImpl() {
		ensureData();
	}
	
	@Override
	public Optional<Customer> getCustomer(String username) {
		Optional<Customer> optionalCustomer = customers.stream()
				.filter(customer -> isUserNameMatches(customer, username)).findFirst();
		return optionalCustomer;
	}

	public void ensureData() {
		customers.add(new Customer(new Credentals("aradipatrik", "1234"), "Patrik Aradi",
				new ContactInfo("45234875", new Address("Hodmezovasarhely", "Bathory utca", "24"))));
		customers.add(new Customer(new Credentals("john", "3452"), "John Smith",
				new ContactInfo("0854657", new Address("Szentes", "Jozsef Attila sugarut", "12"))));
		customers.add(new Customer(new Credentals("emil", "1434"), "Fekete Emil",
				new ContactInfo("45234875", new Address("Szeged", "Ady ter", "4"))));
		customers.add(new Customer(new Credentals("impMaster", "3432"), "Hajdu Levente",
				new ContactInfo("45234875", new Address("Budapest", "Karolyi utca", "24"))));
		customers.add(new Customer(new Credentals("bilbothebest", "1234"), "Zsakos Frodo",
				new ContactInfo("45234875", new Address("A Megye", "Hobbit utca", "32"))));
		customers.add(new Customer(new Credentals("adsf", "3452"), "Regexp Jano",
				new ContactInfo("0854657", new Address("Sebestyen", "Lehel utca", "42"))));
		customers.add(new Customer(new Credentals("TheBest", "asdfke"), "Pal Annabella",
				new ContactInfo("45234875", new Address("Szentes", "Szabadkai utca", "4"))));
		customers.add(new Customer(new Credentals("truePlant", "3432"), "Virag Jatszint",
				new ContactInfo("45234875", new Address("Budapest", "Karolyi utca", "23"))));
	}

	boolean isUserNameMatches(Customer customer, String name) {
		return customer.getCredentials().getUsername().equals(name);
	}

}
