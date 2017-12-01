package de.cas.vaadin.carrental.view.newrental;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.data.Container;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Calendar;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import de.cas.vaadin.carrental.presenter.NavigationPresenter;
import de.cas.vaadin.carrental.view.navigation.NavigationView;
import de.cas.vaadin.carrental.view.navigation.NavigationViewImpl;

public class NewRentalViewImpl extends CustomComponent implements NewRentalView {

	private final NavigationView navigationView = new NavigationViewImpl();
	private final NavigationPresenter navigationPresenter = new NavigationPresenter(navigationView);
	private final VerticalLayout mainLayout = new VerticalLayout();
	private final HorizontalLayout contentLayout = new HorizontalLayout();
	private final FormLayout formLayout = new FormLayout();
	
	private final Table vehiclesTable = new Table();
	private final Table customersTable = new Table();
	private final DateField startDateField = new DateField("Start date: ");
	private final DateField endDateField = new DateField("End date: ");
	private final TextField numberOfVehiclesField = new TextField("Number of vehicles: ");
	private final TextField dailyPriceField = new TextField("DailyPrice: ");
	private final TextField totalPriceField = new TextField("Total: ");
	
	private final List<NewRentalViewListener> listeners = new ArrayList<NewRentalViewListener>();
	
	public NewRentalViewImpl() {
		formLayout.addComponents(startDateField, endDateField, numberOfVehiclesField, dailyPriceField, totalPriceField);
		numberOfVehiclesField.setReadOnly(true);
		dailyPriceField.setReadOnly(true);
		totalPriceField.setReadOnly(true);
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
	
}
