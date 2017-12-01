package de.cas.vaadin.carrental.service.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	@Override
	public List<Customer> getAllCustomers() {
		return this.customers;
	}

	public void ensureData() {
		customers.add(new Customer(new Credentals("aradipatrik", "1234"), "Patrik Aradi",
				new ContactInfo("45234875", "Hodmezovasarhely Bathory utca 24")));
		customers.add(new Customer(new Credentals("johnsmith", "3452"), "John Smith",
				new ContactInfo("0854657", "Szentes Jozsef Attila sugarut 12")));
		customers.add(new Customer(new Credentals("feketeemil", "1434"), "Fekete Emil",
				new ContactInfo("45234875", "Szeged Ady ter 4")));
		customers.add(new Customer(new Credentals("hajdulevente", "3432"), "Hajdu Levente",
				new ContactInfo("45234875", "Budapest Karolyi utca 24")));
		customers.add(new Customer(new Credentals("zsakosfrodo", "1234"), "Zsakos Frodo",
				new ContactInfo("45234875", "A Megye Hobbit utca 32")));
		customers.add(new Customer(new Credentals("regexpjano", "3452"), "Regexp Jano",
				new ContactInfo("0854657", "Sebestyen Lehel utca 42" )));
		customers.add(new Customer(new Credentals("palannabella", "asdfke"), "Pal Annabella",
				new ContactInfo("45234875", "Szentes Szabadkai utca 4")));
		customers.add(new Customer(new Credentals("viragjatszint", "3432"), "Virag Jatszint",
				new ContactInfo("45234875", "Budapest Karolyi utca 23")));
	}

	boolean isUserNameMatches(Customer customer, String name) {
		return customer.getCredentials().getUsername().equals(name);
	}

}
