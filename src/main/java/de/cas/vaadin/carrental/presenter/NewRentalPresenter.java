package de.cas.vaadin.carrental.presenter;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.Button.ClickEvent;

import de.cas.vaadin.carrental.model.Customer;
import de.cas.vaadin.carrental.model.Rental;
import de.cas.vaadin.carrental.model.Vehicle;
import de.cas.vaadin.carrental.service.Services;
import de.cas.vaadin.carrental.service.customer.CustomerService;
import de.cas.vaadin.carrental.service.rental.RentalService;
import de.cas.vaadin.carrental.service.vehicle.VehicleService;
import de.cas.vaadin.carrental.utils.ContainerUtils;
import de.cas.vaadin.carrental.view.newrental.NewRentalView;
import de.cas.vaadin.carrental.view.newrental.NewRentalView.NewRentalViewListener;

public class NewRentalPresenter implements NewRentalViewListener {
	private final NewRentalView newRentalView;
	private final VehicleService vehicleService = Services.getVehicleService();
	private final CustomerService customerService = Services.getCustomerService();
	private final RentalService rentalService = Services.getRentalService();
	private LocalDate startDate;
	private LocalDate endDate;
	private List<Vehicle> selectedVehicles;
	private Customer selectedCustomer;

	public NewRentalPresenter(NewRentalView newRentalView) {
		this.newRentalView = newRentalView;
		this.newRentalView.addListener(this);
		this.setVehiclesData();
		this.setCostumerData();
		this.setHumanReadableHeaderForVehicleTable();
		this.hideUnnecesarryColumnsInVehiclesTable();
		this.setHumanReadeableHeaderInCustomerTable();
		this.hideUnnecessaryColumnsInCustomerTable();
	}

	private void setVehiclesData() {
		this.newRentalView.attachVehiclesData(
				ContainerUtils.convertVehicleListToVehicleBeanContainer(this.vehicleService.getReadyToGoVehicles()));
	}

	private void setCostumerData() {
		this.newRentalView.attachCustomerData(
				ContainerUtils.convertCostumerListToCostumerBeanContainer(this.customerService.getAllCustomers()));
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

	private void setHumanReadeableHeaderInCustomerTable() {
		this.newRentalView.setCustomerTableHeader("name", "Name");
		this.newRentalView.setCustomerTableHeader("contactInfo.telephoneNumber", "Phone Number");
		this.newRentalView.setCustomerTableHeader("contactInfo.address", "Address");
	}

	private void hideUnnecessaryColumnsInCustomerTable() {
		this.newRentalView.setCustomerTableVisibleColumns("name", "contactInfo.telephoneNumber", "contactInfo.address");
	}

	@Override
	public void onRentButtonClick(ClickEvent event) {
		if (isVehicleSelected() && isCustomerSelected() && isDateSelected()) {
			for (Vehicle vehicle : this.selectedVehicles) {
				this.rentalService.addRental(new Rental(this.rentalService.getAllRentals().size() + 1,
						this.selectedCustomer, vehicle, this.startDate, this.endDate));
				this.newRentalView.showRentSuccessfull("Rent was successfull! :)");
				this.vehicleService.setVehicleStatusToBorrowed(vehicle);
				setVehiclesData();
				setHumanReadableHeaderForVehicleTable();
				hideUnnecesarryColumnsInVehiclesTable();
				clearAll();
			}
		} else {
			this.newRentalView.showRentUnsuccessfull("Select some cars, select a customer, and select both end and start date please");
		}
	}
	
	private void clearAll() {
		this.newRentalView.clearEndDate();
		this.newRentalView.clearStartDate();
		this.newRentalView.clearCustomerSelection();
		this.newRentalView.clearVehicleSelection();
	}

	private boolean isVehicleSelected() {
		return this.selectedVehicles != null && !this.selectedVehicles.isEmpty();
	}

	private boolean isCustomerSelected() {
		return this.selectedCustomer != null;
	}

	private boolean isDateSelected() {
		return this.startDate != null && this.endDate != null;
	}

	@Override
	public void onStartDateValueChange(ValueChangeEvent event) {
		if (event.getProperty().getValue() == null) {
			return;
		}
		LocalDate selectedDate = ((Date) event.getProperty().getValue()).toInstant().atZone(ZoneId.systemDefault())
				.toLocalDate();
		if (this.endDate == null) {
			this.startDate = selectedDate;
		} else if (selectedDate.isBefore(this.endDate)) {
			this.startDate = selectedDate;
		} else {
			this.newRentalView.clearStartDate();
			this.startDate = null;
			this.newRentalView.showWrongStartDate("Start date must be before the end date");
		}
		if (this.selectedVehicles != null) {
			updateCalculatedValues();
		}
	}

	@Override
	public void onEndDateValueChange(ValueChangeEvent event) {
		if (event.getProperty().getValue() == null) {
			return;
		}
		LocalDate selectedDate = ((Date) event.getProperty().getValue()).toInstant().atZone(ZoneId.systemDefault())
				.toLocalDate();
		if (this.startDate == null) {
			this.endDate = selectedDate;
		} else if (selectedDate.isAfter(this.startDate)) {
			this.endDate = selectedDate;
		} else {
			this.newRentalView.clearEndDate();
			this.endDate = null;
			this.newRentalView.showWrongEndDate("End date must be after the start date");
		}
		if (this.selectedVehicles != null) {
			updateCalculatedValues();
		}
	}

	@Override
	public void onVehicleTableValueChange(ValueChangeEvent event) {
		List<Vehicle> tmp = new ArrayList<>();
		if(event.getProperty().getValue() == null) {
			return;
		}
		((Set<String>) event.getProperty().getValue()).forEach(e -> {
			tmp.add(this.vehicleService.getVehicle(e).get());
		});
		this.selectedVehicles = tmp;
		this.newRentalView.setNumberOfVehicles(this.selectedVehicles.size());
		updateCalculatedValues();
	}

	void updateCalculatedValues() {
		if (this.startDate != null && this.endDate != null) {
			double dailyPrice = this.selectedVehicles.stream().map(e -> e.getDailyPrice().getValue()).reduce(0.0,
					(a, b) -> a + b);
			this.newRentalView.setDailyPrice(dailyPrice);
			long days = startDate.until(endDate).getDays();
			this.newRentalView.setTotal(days * dailyPrice);
		}
	}

	@Override
	public void onCustomerTableValueChange(ValueChangeEvent event) {
		if (event.getProperty().getValue() == null) {
			return;
		}
		this.selectedCustomer = this.customerService.getCustomer((String) event.getProperty().getValue()).get();
	}

	@Override
	public void onViewEnter() {
		setVehiclesData();
		setHumanReadableHeaderForVehicleTable();
		hideUnnecesarryColumnsInVehiclesTable();
	}
	
	
}
