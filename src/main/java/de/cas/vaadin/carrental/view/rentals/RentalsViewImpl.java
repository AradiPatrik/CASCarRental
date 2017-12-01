package de.cas.vaadin.carrental.view.rentals;

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

public class RentalsViewImpl extends CustomComponent implements RentalsView {
	
	private final NavigationView navigationView = new NavigationViewImpl();
	private final NavigationPresenter navigationPresenter = new NavigationPresenter(navigationView);
	
	private final List<RentalsViewListener> listeners = new ArrayList<>();
	private final VerticalLayout mainLayout = new VerticalLayout();
	private final Table rentalsTable = new Table();
	
	public RentalsViewImpl() {
		mainLayout.setMargin(true);
		mainLayout.setSpacing(true);
		mainLayout.addComponents(navigationView, rentalsTable);
		this.setCompositionRoot(mainLayout);
	}

	@Override
	public void addListener(RentalsViewListener listener) {
		this.listeners.add(listener);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		this.listeners.forEach(e -> e.onViewEnter());
	}

	@Override
	public void attachRentalData(Container container) {
		this.rentalsTable.setContainerDataSource(container);
	}

	@Override
	public void setColumnHeader(String propertyName, String headerName) {
		this.rentalsTable.setColumnHeader(propertyName, headerName);
		
	}

	@Override
	public void setVisibleColumns(Object... propertyName) {
		this.rentalsTable.setVisibleColumns(propertyName);
	}
}
