package de.cas.vaadin.carrental.view.navigation;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;

public class NavigationViewImpl extends CustomComponent implements NavigationView {
	private final HorizontalLayout mainLayout = new HorizontalLayout();
	private final Button vehiclesButton = new Button("Vehicles", this::notifyVehiclesButtonClick);
	private final Button rentalsButton = new Button("Rentals", this::notifyRentalsButtonClick);
	private final Button customersButton = new Button("Customers", this::notifyCustomersButtonClick);
	private final Button newRentalButton = new Button("New Rental", this::notifyNewRentalButtonClick);
	
	private final List<NavigationViewListener> listeners = new ArrayList<>();
	
	public NavigationViewImpl() {
		mainLayout.addComponents(vehiclesButton, rentalsButton, customersButton, newRentalButton);
		mainLayout.setSpacing(true);
		this.setCompositionRoot(mainLayout);
	}
	
	@Override
	public void addListener(NavigationViewListener listener) {
		System.out.println("added listener");
		this.listeners.add(listener);
	}
	
	public void notifyVehiclesButtonClick(Button.ClickEvent event) {
		System.out.println("notify vehicles");
		this.listeners.forEach(e -> e.onVehiclesClick());
	}
	
	public void notifyRentalsButtonClick(Button.ClickEvent event) {
		this.listeners.forEach(e -> e.onRentalsClick());
	}
	
	public void notifyCustomersButtonClick(Button.ClickEvent event) {
		this.listeners.forEach(e -> e.onCustomersClick());
	}
	
	public void notifyNewRentalButtonClick(Button.ClickEvent event) {
		this.listeners.forEach(e -> e.onNewRentalClick());
	}
	
}
