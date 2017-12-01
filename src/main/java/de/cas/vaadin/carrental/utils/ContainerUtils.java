package de.cas.vaadin.carrental.utils;

import java.util.List;

import com.vaadin.data.util.BeanContainer;

import de.cas.vaadin.carrental.model.Customer;
import de.cas.vaadin.carrental.model.Rental;
import de.cas.vaadin.carrental.model.Vehicle;

public class ContainerUtils {
	
	public static BeanContainer<String, Vehicle> convertVehicleListToVehicleBeanContainer(List<Vehicle> vehicles) {
		BeanContainer<String, Vehicle> vehicleBeanContainer = new BeanContainer<String, Vehicle>(Vehicle.class);
		vehicleBeanContainer.setBeanIdProperty("numberPlate");
		vehicleBeanContainer.addNestedContainerProperty("dailyPrice.value");
		vehicles.forEach(e -> {
			vehicleBeanContainer.addBean(e);
		});
		return vehicleBeanContainer;
	}
	
	public static BeanContainer<String, Customer> convertCostumerListToCostumerBeanContainer(List<Customer> customers) {
		BeanContainer<String, Customer> customerBeanContainer = new BeanContainer<String, Customer>(Customer.class);
		customerBeanContainer.setBeanIdProperty("name");
		customerBeanContainer.addNestedContainerProperty("contactInfo.telephoneNumber");
		customerBeanContainer.addNestedContainerProperty("contactInfo.address");
		customers.forEach(e -> {
			customerBeanContainer.addBean(e);
		});
		return customerBeanContainer;
	}
	
	public static BeanContainer<Integer, Rental> convertRentalListToRentalBeanContainer(List<Rental> rentals) {
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
	
	
}
