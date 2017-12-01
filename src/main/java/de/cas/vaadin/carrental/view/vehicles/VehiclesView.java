package de.cas.vaadin.carrental.view.vehicles;

import com.vaadin.data.Container;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;

import de.cas.vaadin.carrental.model.VehicleState;

public interface VehiclesView extends View {
	
	interface VehiclesViewListener {
		void onCheckBoxValueChanged(ValueChangeEvent event);
		void onDeleteClick(Button.ClickEvent event);
		void onNewVehicleButtonClick(Button.ClickEvent event);
		void onVehicleAddClick(Button.ClickEvent event);
		void onModalCancleClick(Button.ClickEvent event);
	}
	
	void addListener(VehiclesViewListener listener);
	void attachVehiclesData(Container container);
	void setColumnHeader(String propertyName, String headerName);
	void setVisibleColumns(Object... propertyName);
	void displayModalDialog();
	void closeModalDialog();
	Object getSelectedRows();
	
	String getNewManufacturer();
	String getNewTypeProperty();
	String getDailyPriceProperty();
	VehicleState getVehicleStateProperty();
	String getNumberPlateProperty();
}
