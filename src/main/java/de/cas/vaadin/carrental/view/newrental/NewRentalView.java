package de.cas.vaadin.carrental.view.newrental;

import com.vaadin.data.Container;
import com.vaadin.navigator.View;

public interface NewRentalView extends View {
	interface NewRentalViewListener {
		
	}
	
	void addListener(NewRentalViewListener listener);
	void attachVehiclesData(Container container);
	void setVehiclesTableHeader(String propertyName, String headerName);
	void setVehiclesTableVisibleColumns(Object... propertyName);
	void attachCustomerData(Container container);
	void setCustomerTableHeader(String propertyName, String headerName);
	void setCustomerTableVisibleColumns(Object... propertyName);
}
