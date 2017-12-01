package de.cas.vaadin.carrental.view.rentals;

import com.vaadin.data.Container;
import com.vaadin.navigator.View;

public interface RentalsView extends View {
	interface RentalsViewListener {
		
	}
	
	void addListener(RentalsViewListener listener);
	void attachRentalData(Container container);
	void setColumnHeader(String propertyName, String headerName);
	void setVisibleColumns(Object... propertyName);
}
