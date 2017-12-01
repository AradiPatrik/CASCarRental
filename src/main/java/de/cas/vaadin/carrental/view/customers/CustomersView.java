package de.cas.vaadin.carrental.view.customers;

import com.vaadin.navigator.View;

public interface CustomersView extends View {
	public interface CustomersViewListener {
		
	}
	
	public void addListener(CustomersViewListener listener);
}
