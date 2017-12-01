package de.cas.vaadin.carrental.view.customers;

import com.vaadin.data.Container;
import com.vaadin.navigator.View;

public interface CustomersView extends View {
	interface CustomersViewListener {
		
	}
	
	void addListener(CustomersViewListener listener);
	void attachCustomerData(Container container);
	void setColumnHeader(String propertyName, String headerName);
	void setVisibleColumns(Object... propertyName);
}
