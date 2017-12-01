package de.cas.vaadin.carrental.view.customers;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;

import de.cas.vaadin.carrental.presenter.NavigationPresenter;
import de.cas.vaadin.carrental.view.customers.CustomersView.CustomersViewListener;
import de.cas.vaadin.carrental.view.navigation.NavigationView;
import de.cas.vaadin.carrental.view.navigation.NavigationViewImpl;

public class CustomersViewImpl implements CustomersView {

	private NavigationView navigationView = new NavigationViewImpl();


	private NavigationPresenter navigationPresenter = new NavigationPresenter(navigationView);
	
	
	@Override
	public void enter(ViewChangeEvent event) {
		// intentionally left blank
	}
	
	@Override
	public void addListener(CustomersViewListener listener) {
		// TODO Auto-generated method stub
		
	}
	
	
}
