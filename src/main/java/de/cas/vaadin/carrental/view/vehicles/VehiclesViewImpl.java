package de.cas.vaadin.carrental.view.vehicles;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.data.Container;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class VehiclesViewImpl extends CustomComponent implements VehiclesView{	
	
	private List<VehiclesViewListener> listeners = new ArrayList<>();
	private final VerticalLayout mainLayout = new VerticalLayout();
	private final HorizontalLayout controlls = new HorizontalLayout();
	private final CheckBox hideDeletedCheckBox = new CheckBox("Hide Deleted", false);
	private final Button deleteButton = new Button("Delete", this::notifyDeleteButtonClick);
	private final Button newVehicleButton = new Button("Create New Vehicle", this::notifyNewVehicleButtonClick);
	private final Table vehiclesTable = new Table();
		
	public VehiclesViewImpl() {
		vehiclesTable.setMultiSelect(true);
		vehiclesTable.setSelectable(true);
		vehiclesTable.setImmediate(true);
		hideDeletedCheckBox.addValueChangeListener(this::notifyCheckBoxValueChanged);
		hideDeletedCheckBox.setImmediate(true);
		controlls.addComponents(hideDeletedCheckBox, deleteButton, newVehicleButton);
		controlls.setMargin(true);
		controlls.setSpacing(true);
		controlls.setComponentAlignment(hideDeletedCheckBox, Alignment.MIDDLE_LEFT);
		this.mainLayout.addComponents(vehiclesTable, controlls);
		this.mainLayout.setMargin(true);
		this.mainLayout.setSpacing(true);
		this.setCompositionRoot(mainLayout);
	}
	
	@Override
	public void addListener(VehiclesViewListener listener) {
		this.listeners.add(listener);
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		// intentionally left blank
	}

	@Override
	public void attachVehiclesData(Container container) {
		this.vehiclesTable.setContainerDataSource(container);
	}

	@Override
	public void setColumnHeader(String propertyName, String headerName) {
		this.vehiclesTable.setColumnHeader(propertyName, headerName);
	}

	@Override
	public void setVisibleColumns(Object... propertyNames) {
		this.vehiclesTable.setVisibleColumns(propertyNames);
	}
	
	@Override
	public Object getSelectedRows() {
		return this.vehiclesTable.getValue();
	}
	
	// LISTENERS
	public void notifyCheckBoxValueChanged(ValueChangeEvent event) {
		listeners.forEach(e -> e.onCheckBoxValueChanged(event));
	}
	
	
	public void notifyDeleteButtonClick(Button.ClickEvent event) {
		listeners.forEach(e -> e.onDeleteClick(event));
	}
	
	public void notifyNewVehicleButtonClick(Button.ClickEvent event) {
		listeners.forEach(e -> e.onNewVehicleButtonClick(event));
	}

	
}
