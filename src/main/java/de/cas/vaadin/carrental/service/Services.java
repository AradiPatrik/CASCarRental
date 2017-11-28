package de.cas.vaadin.carrental.service;

import de.cas.vaadin.carrental.service.customer.CustomerService;
import de.cas.vaadin.carrental.service.customer.CustomerServiceImpl;
import de.cas.vaadin.carrental.service.login.LoginService;
import de.cas.vaadin.carrental.service.login.LoginServiceImpl;
import de.cas.vaadin.carrental.service.vehicle.VehicleService;
import de.cas.vaadin.carrental.service.vehicle.VehicleServiceImpl;

public class Services {
	private static CustomerService customerServiceInstance;
	private static LoginService loginServiceInstance;
	private static VehicleService vehicleServiceInstance;
	
	public static CustomerService getCustomerService() {
		if (customerServiceInstance == null) {
			customerServiceInstance = new CustomerServiceImpl();
			return customerServiceInstance;
		} else {
			return customerServiceInstance;
		}
	}
	
	public static LoginService getLoginService() {
		if (loginServiceInstance == null) {
			loginServiceInstance = new LoginServiceImpl();
			return loginServiceInstance;
		} else {
			return loginServiceInstance;
		}
	}

	public static VehicleService getVehicleService() {
		if (vehicleServiceInstance == null) {
			vehicleServiceInstance = new VehicleServiceImpl();
			return vehicleServiceInstance;
		} else {
			return vehicleServiceInstance;
		}
	}
	
}
