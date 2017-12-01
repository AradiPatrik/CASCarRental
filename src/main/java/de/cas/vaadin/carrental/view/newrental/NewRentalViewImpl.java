package de.cas.vaadin.carrental.view.newrental;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.data.Container;
import com.vaadin.data.Property;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import de.cas.vaadin.carrental.CASCarRentalApplication;
import de.cas.vaadin.carrental.presenter.NavigationPresenter;
import de.cas.vaadin.carrental.view.navigation.NavigationView;
import de.cas.vaadin.carrental.view.navigation.NavigationViewImpl;

public class NewRentalViewImpl extends CustomComponent implements NewRentalView {

	private final NavigationView navigationView = new NavigationViewImpl();
	private final NavigationPresenter navigationPresenter = new NavigationPresenter(navigationView);
	private final VerticalLayout mainLayout = new VerticalLayout();
	private final HorizontalLayout contentLayout = new HorizontalLayout();
	private final FormLayout formLayout = new FormLayout();
	private final HorizontalLayout formButtonsLayout = new HorizontalLayout();

	private final Table vehiclesTable = new Table();
	private final Table customersTable = new Table();
	private final DateField startDateField = new DateField("Start date: ");
	private final DateField endDateField = new DateField("End date: ");
	private final TextField numberOfVehiclesField = new TextField("Number of vehicles: ");
	private final TextField dailyPriceField = new TextField("DailyPrice: ");
	private final TextField totalPriceField = new TextField("Total: ");
	private final Button createRentButton = new Button("Rent", this::notifyRentButtonClick);

	private final List<NewRentalViewListener> listeners = new ArrayList<NewRentalViewListener>();

	public NewRentalViewImpl() {
		formButtonsLayout.addComponents(createRentButton);
		formButtonsLayout.setSpacing(true);
		formLayout.addComponents(startDateField, endDateField, numberOfVehiclesField, dailyPriceField, totalPriceField,
				formButtonsLayout);
		formLayout.setSpacing(true);
		formLayout.setMargin(true);
		totalPriceField.setEnabled(false);
		dailyPriceField.setEnabled(false);
		numberOfVehiclesField.setEnabled(false);
		startDateField.setImmediate(true);
		endDateField.setImmediate(true);
		contentLayout.addComponents(vehiclesTable, customersTable, formLayout);
		contentLayout.setSpacing(true);
		customersTable.setSelectable(true);
		customersTable.setImmediate(true);
		mainLayout.setSpacing(true);
		mainLayout.addComponents(navigationView, contentLayout);
		mainLayout.setMargin(true);
		this.setCompositionRoot(mainLayout);
		vehiclesTable.setSelectable(true);
		vehiclesTable.setMultiSelect(true);
		vehiclesTable.setImmediate(true);

		startDateField.addValueChangeListener(this::notifyStartDateValueChange);
		endDateField.addValueChangeListener(this::notifyEndDateValueChange);
		vehiclesTable.addValueChangeListener(this::notifyVehicleTableValueChange);
		customersTable.addValueChangeListener(this::notifyCustomerTableValueChange);
	}

	@Override
	public void addListener(NewRentalViewListener listener) {
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
	public void setVehiclesTableHeader(String propertyName, String headerName) {
		this.vehiclesTable.setColumnHeader(propertyName, headerName);
	}

	@Override
	public void setVehiclesTableVisibleColumns(Object... propertyName) {
		this.vehiclesTable.setVisibleColumns(propertyName);
	}

	@Override
	public void attachCustomerData(Container container) {
		this.customersTable.setContainerDataSource(container);
	}

	@Override
	public void setCustomerTableHeader(String propertyName, String headerName) {
		this.customersTable.setColumnHeader(propertyName, headerName);
	}

	@Override
	public void setCustomerTableVisibleColumns(Object... propertyName) {
		this.customersTable.setVisibleColumns(propertyName);
	}
	
	@Override
	public void clearStartDate() {
		this.startDateField.setValue(null);
	}
	
	@Override
	public void clearEndDate() {
		this.endDateField.setValue(null);
	}
	
	@Override
	public void clearCustomerSelection() {
		this.customersTable.setValue(null);
	}

	@Override
	public void clearVehicleSelection() {
		this.vehiclesTable.select(null);
		this.vehiclesTable.setValue(null);
	}

	@Override
	public void setNumberOfVehicles(Integer num) {
		this.numberOfVehiclesField.setValue(num.toString());
	}
	
	@Override
	public void setDailyPrice(Double value) {
		this.dailyPriceField.setValue(value.toString());
	}
	
	@Override
	public void setTotal(Double value) {
		this.totalPriceField.setValue(value.toString());
	}

	@Override
	public void showWrongStartDate(String message) {
		showNotificationMessage(message, Type.ERROR_MESSAGE, -1);
	}
	
	@Override
	public void showWrongEndDate(String message) {
		showNotificationMessage(message, Type.ERROR_MESSAGE, -1);
	}
	
	@Override
	public void showRentUnsuccessfull(String message) {
		showNotificationMessage(message, Type.ERROR_MESSAGE, -1);
	}
	
	@Override
	public void showRentSuccessfull(String message) {
		Notification.show("Info", message, Type.TRAY_NOTIFICATION);
	}
	
	private void showNotificationMessage(String message, Notification.Type type, int delay) {
		Notification notif = new Notification(type.toString(), message, Type.ERROR_MESSAGE);
		notif.setDelayMsec(delay);
		notif.setIcon(FontAwesome.CLOSE);
		notif.show(CASCarRentalApplication.getMainUI().getPage());
	}

	// Listeners
	public void notifyRentButtonClick(Button.ClickEvent event) {
		this.listeners.forEach(e -> e.onRentButtonClick(event));
	}

	public void notifyStartDateValueChange(Property.ValueChangeEvent event) {
		this.listeners.forEach(e -> e.onStartDateValueChange(event));
	}

	public void notifyEndDateValueChange(Property.ValueChangeEvent event) {
		this.listeners.forEach(e -> e.onEndDateValueChange(event));
	}
	
	public void notifyVehicleTableValueChange(Property.ValueChangeEvent event) {
		this.listeners.forEach(e -> e.onVehicleTableValueChange(event));
	}
	
	public void notifyCustomerTableValueChange(Property.ValueChangeEvent event) {
		this.listeners.forEach(e -> e.onCustomerTableValueChange(event));
	}
}
