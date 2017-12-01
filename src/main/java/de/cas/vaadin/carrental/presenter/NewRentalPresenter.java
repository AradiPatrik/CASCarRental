package de.cas.vaadin.carrental.presenter;

import de.cas.vaadin.carrental.service.Services;
import de.cas.vaadin.carrental.service.customer.CustomerService;
import de.cas.vaadin.carrental.service.vehicle.VehicleService;
import de.cas.vaadin.carrental.utils.ContainerUtils;
import de.cas.vaadin.carrental.view.newrental.NewRentalView;
import de.cas.vaadin.carrental.view.newrental.NewRentalView.NewRentalViewListener;

public class NewRentalPresenter implements NewRentalViewListener {
	private final NewRentalView newRentalView;
	private final VehicleService vehicleService = Services.getVehicleService();
	private final CustomerService customerService = Services.getCustomerService();
	
	public NewRentalPresenter(NewRentalView newRentalView) {
		this.newRentalView = newRentalView;
		this.newRentalView.addListener(this);
		this.setVehiclesData();
		this.setCostumerData();
		this.setHumanReadableHeaderForVehicleTable();
		this.hideUnnecesarryColumnsInVehiclesTable();
		this.setHumanReadeableHeader();
		this.hideUnnecessaryColumnsInTable();
	}
	
	private void setVehiclesData() {
		this.newRentalView.attachVehiclesData(ContainerUtils.convertVehicleListToVehicleBeanContainer(this.vehicleService.getReadyToGoVehicles()));
	}
	
	private void setCostumerData() {
		this.newRentalView.attachCustomerData(ContainerUtils.convertCostumerListToCostumerBeanContainer(this.customerService.getAllCustomers()));
	}
	
	private void setHumanReadableHeaderForVehicleTable() {
		this.newRentalView.setVehiclesTableHeader("manufacturer", "Manufacturer");
		this.newRentalView.setVehiclesTableHeader("dailyPrice.value", "Daily Price");
		this.newRentalView.setVehiclesTableHeader("type", "Type");
		this.newRentalView.setVehiclesTableHeader("numberPlate", "Numberplate");
	}
	
	private void hideUnnecesarryColumnsInVehiclesTable() {
		this.newRentalView.setVehiclesTableVisibleColumns("manufacturer", "type", "numberPlate", "dailyPrice.value");
	}
	
	private void setHumanReadeableHeader() {
		this.newRentalView.setCustomerTableHeader("name", "Name");
		this.newRentalView.setCustomerTableHeader("contactInfo.telephoneNumber", "Phone Number");
		this.newRentalView.setCustomerTableHeader("contactInfo.address", "Address");
	}
	

	private void hideUnnecessaryColumnsInTable() {
		this.newRentalView.setCustomerTableVisibleColumns("name", "contactInfo.telephoneNumber", "contactInfo.address");
	}
	
}
