package de.cas.vaadin.carrental.presenter;

import java.util.List;

import com.vaadin.data.util.BeanContainer;

import de.cas.vaadin.carrental.model.Customer;
import de.cas.vaadin.carrental.model.Vehicle;
import de.cas.vaadin.carrental.service.Services;
import de.cas.vaadin.carrental.service.customer.CustomerService;
import de.cas.vaadin.carrental.utils.ContainerUtils;
import de.cas.vaadin.carrental.view.customers.CustomersView;
import de.cas.vaadin.carrental.view.customers.CustomersView.CustomersViewListener;

public class CustomersPresenter implements CustomersViewListener{
	private CustomersView customersView;
	CustomerService customerService = Services.getCustomerService();
	
	public CustomersPresenter(CustomersView customersView) {
		this.customersView = customersView;
		this.customersView.addListener(this);
		this.customersView.attachCustomerData(ContainerUtils.convertCostumerListToCostumerBeanContainer(customerService.getAllCustomers()));
		hideUnnecessaryColumnsInTable();
		setHumanReadeableHeader();
	}
	
	private void setHumanReadeableHeader() {
		this.customersView.setColumnHeader("name", "Name");
		this.customersView.setColumnHeader("contactInfo.telephoneNumber", "Phone Number");
		this.customersView.setColumnHeader("contactInfo.address", "Address");
	}
	

	private void hideUnnecessaryColumnsInTable() {
		this.customersView.setVisibleColumns("name", "contactInfo.telephoneNumber", "contactInfo.address");
	}
	
}
