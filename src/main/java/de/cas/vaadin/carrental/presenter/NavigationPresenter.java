package de.cas.vaadin.carrental.presenter;

import de.cas.vaadin.carrental.service.Navigation;
import de.cas.vaadin.carrental.service.Routes;
import de.cas.vaadin.carrental.view.navigation.NavigationView;
import de.cas.vaadin.carrental.view.navigation.NavigationView.NavigationViewListener;

public class NavigationPresenter implements NavigationViewListener{

	NavigationView navigationView;
	
	public NavigationPresenter(NavigationView view) {
		this.navigationView = view;
		this.navigationView.addListener(this);
	}
	
	@Override
	public void onVehiclesClick() {
		System.out.println("vehicles");
		Navigation.navigateTo(Routes.VEHICLES);
	}

	@Override
	public void onCustomersClick() {
		System.out.println("customers");
		Navigation.navigateTo(Routes.CUSTOMERS);
	}

	@Override
	public void onRentalsClick() {
		System.out.println("rentals");
		Navigation.navigateTo(Routes.RENTALS);
	}

	@Override
	public void onNewRentalClick() {
		System.out.println("new rental");
		Navigation.navigateTo(Routes.NEW_RENTAL);
	}
	
}
