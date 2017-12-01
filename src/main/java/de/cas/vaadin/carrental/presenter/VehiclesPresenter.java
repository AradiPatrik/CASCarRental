package de.cas.vaadin.carrental.presenter;

import java.util.List;
import java.util.Set;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.Button.ClickEvent;

import de.cas.vaadin.carrental.model.Euro;
import de.cas.vaadin.carrental.model.Vehicle;
import de.cas.vaadin.carrental.service.Services;
import de.cas.vaadin.carrental.service.vehicle.VehicleService;
import de.cas.vaadin.carrental.utils.ContainerUtils;
import de.cas.vaadin.carrental.view.vehicles.VehiclesView;

public class VehiclesPresenter implements VehiclesView.VehiclesViewListener {

	private VehicleService vehicleService = Services.getVehicleService();
	private VehiclesView vehiclesView;
	private boolean isHideDeletedCheckBoxTicked = false;

	public VehiclesPresenter(VehiclesView vehiclesView) {
		this.vehiclesView = vehiclesView;
		this.vehiclesView.addListener(this);
		setAndDisplayTableData(this.vehicleService.getVehicles());
	}

	private void setAndDisplayTableData(List<Vehicle> vehicles) {
		vehiclesView.attachVehiclesData(ContainerUtils.convertVehicleListToVehicleBeanContainer(vehicles));
		setHumanReadeableHeader();
		hideUnnecessaryColumnsInTable();
	}

	private void setHumanReadeableHeader() {
		vehiclesView.setColumnHeader("dailyPrice.value", "Daily Price");
		vehiclesView.setColumnHeader("manufacturer", "Manufacturer");
		vehiclesView.setColumnHeader("type", "Type");
		vehiclesView.setColumnHeader("vehicleState", "State");
		vehiclesView.setColumnHeader("numberPlate", "Numberplate");
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
		Set<String> selection = (Set<String>) vehiclesView.getSelectedRows();
		if (selection != null && !selection.isEmpty()) {
			selection.forEach(this.vehicleService::delete);
		}
		displayVehiclesAccordingToCheckBoxState();
	}

	void displayVehiclesAccordingToCheckBoxState() {
		if (isHideDeletedCheckBoxTicked) {
			setAndDisplayTableData(this.vehicleService.getUndeletedVehicles());
			hideUnnecessaryColumnsInTable();
		} else {
			setAndDisplayTableData(this.vehicleService.getVehicles());
			hideUnnecessaryColumnsInTable();
		}
	}

	@Override
	public void onNewVehicleButtonClick(ClickEvent event) {
		this.vehiclesView.displayModalDialog();
	}

	@Override
	public void onVehicleAddClick(ClickEvent event) {
		Vehicle vehicle = new Vehicle(this.vehiclesView.getNewManufacturer(), this.vehiclesView.getNewTypeProperty(),
				new Euro(Double.parseDouble(this.vehiclesView.getDailyPriceProperty())),
				this.vehiclesView.getVehicleStateProperty(), this.vehiclesView.getNumberPlateProperty());
		this.setAndDisplayTableData(this.vehicleService.addVehicle(vehicle));
	}

	@Override
	public void onModalCancleClick(ClickEvent event) {
		this.vehiclesView.closeModalDialog();
	}
}
