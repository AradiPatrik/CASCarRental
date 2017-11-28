package de.cas.vaadin.carrental.view.vehicles;

import java.util.List;

import com.vaadin.data.Container;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;

import de.cas.vaadin.carrental.model.Vehicle;

public interface VehiclesView extends View {
	
	interface VehiclesViewListener {
		void onCheckBoxValueChanged(ValueChangeEvent event);
		void onDeleteClick(Button.ClickEvent event);
		void onNewVehicleButtonClick(Button.ClickEvent event);
	}
	
	void addListener(VehiclesViewListener listener);
	void attachVehiclesData(Container container);
	void setColumnHeader(String propertyName, String headerName);
	void setVisibleColumns(Object... propertyName);
	Object getSelectedRows();
	
}
