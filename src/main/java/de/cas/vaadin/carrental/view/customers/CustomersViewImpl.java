package de.cas.vaadin.carrental.view.customers;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.data.Container;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

import de.cas.vaadin.carrental.presenter.NavigationPresenter;
import de.cas.vaadin.carrental.view.navigation.NavigationView;
import de.cas.vaadin.carrental.view.navigation.NavigationViewImpl;

public class CustomersViewImpl extends CustomComponent implements CustomersView {

	private final VerticalLayout mainLayout = new VerticalLayout();
	private final NavigationView navigationView = new NavigationViewImpl();
	private final NavigationPresenter navigationPresenter = new NavigationPresenter(navigationView);
	private final Table customerTable = new Table();
	
	private final List<CustomersViewListener> listeners = new ArrayList<>();
	
	public CustomersViewImpl() {
		mainLayout.setMargin(true);
		mainLayout.setSpacing(true);
		mainLayout.addComponents(navigationView, customerTable);
		this.setCompositionRoot(mainLayout);
	}
	
	@Override
	public void addListener(CustomersViewListener listener) {
		this.listeners.add(listener);
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		// intentionally left blank
	}
	
	@Override
	public void attachCustomerData(Container container) {
		this.customerTable.setContainerDataSource(container);
	}

	@Override
	public void setColumnHeader(String propertyName, String headerName) {
		this.customerTable.setColumnHeader(propertyName, headerName);
	}

	@Override
	public void setVisibleColumns(Object... propertyNames) {
		this.customerTable.setVisibleColumns(propertyNames);
	}
	
}
