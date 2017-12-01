package de.cas.vaadin.carrental.presenter;

import java.util.List;
import java.util.Set;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.ui.Button.ClickEvent;

import de.cas.vaadin.carrental.model.Vehicle;
import de.cas.vaadin.carrental.service.Services;
import de.cas.vaadin.carrental.service.vehicle.VehicleService;
import de.cas.vaadin.carrental.view.vehicles.VehiclesView;

public class VehiclesPresenter implements VehiclesView.VehiclesViewListener {

	private VehicleService vehicleService = Services.getVehicleService();
	private VehiclesView vehiclesView;
	private boolean isHideDeletedCheckBoxTicked = false;
	
	public VehiclesPresenter(VehiclesView vehiclesView) {
		this.vehiclesView = vehiclesView;
		this.vehiclesView.addListener(this);
		vehiclesView.attachVehiclesData(convertListToBeanContainer(this.vehicleService.getVehicles()));
		vehiclesView.setColumnHeader("dailyPrice.value", "Daily Price");
		vehiclesView.setColumnHeader("manufacturer", "Manufacturer");
		vehiclesView.setColumnHeader("type", "Type");
		vehiclesView.setColumnHeader("vehicleState", "State");
		vehiclesView.setColumnHeader("numberPlate", "Numberplate");
		hideUnnecessaryColumnsInTable();
	}

	private void hideUnnecessaryColumnsInTable() {
		vehiclesView.setVisibleColumns("manufacturer", "type", "dailyPrice.value", "vehicleState", "numberPlate");
	}
	
	@Override
	public void onCheckBoxValueChanged(ValueChangeEvent event) {
		isHideDeletedCheckBoxTicked = !isHideDeletedCheckBoxTicked;
		displayVehiclesAccordingToCheckBoxState();
	}

	@Override
	public void onDeleteClick(ClickEvent event) {
		Set<String> selection = (Set<String>)vehiclesView.getSelectedRows();
		if (selection != null && !selection.isEmpty()) {			
			selection.forEach(this.vehicleService::delete);
		}
		displayVehiclesAccordingToCheckBoxState();
	}
	
	void displayVehiclesAccordingToCheckBoxState() {
		if (isHideDeletedCheckBoxTicked) {
			vehiclesView.attachVehiclesData(convertListToBeanContainer(this.vehicleService.getUndeletedVehicles()));
			hideUnnecessaryColumnsInTable();
		} else {
			vehiclesView.attachVehiclesData(convertListToBeanContainer(this.vehicleService.getVehicles()));
			hideUnnecessaryColumnsInTable();
		}
	}

	@Override
	public void onNewVehicleButtonClick(ClickEvent event) {
		this.vehiclesView.displayModalDialog();
	}
	
	private BeanContainer<String, Vehicle> convertListToBeanContainer(List<Vehicle> vehicles) {
		BeanContainer<String, Vehicle> vehicleBeanContainer = new BeanContainer<String, Vehicle>(Vehicle.class);
		vehicleBeanContainer.setBeanIdProperty("numberPlate");
		vehicleBeanContainer.addNestedContainerProperty("dailyPrice.value");
		vehicles.forEach(e -> {
			vehicleBeanContainer.addBean(e);
		});
		return vehicleBeanContainer;
	}

	@Override
	public void onVehicleAddClick(ClickEvent event) {
		// TODO: implement this
	}

	@Override
	public void onModalCancleClick(ClickEvent event) {
		this.vehiclesView.closeModalDialog();
	}
}
