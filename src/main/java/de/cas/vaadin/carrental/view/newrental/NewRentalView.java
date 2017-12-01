package de.cas.vaadin.carrental.view.newrental;

import com.vaadin.data.Container;
import com.vaadin.data.Property;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;

public interface NewRentalView extends View {
	interface NewRentalViewListener {
		void onRentButtonClick(Button.ClickEvent event);
		void onStartDateValueChange(Property.ValueChangeEvent event);
		void onEndDateValueChange(Property.ValueChangeEvent event);
		void onVehicleTableValueChange(Property.ValueChangeEvent event);
		void onCustomerTableValueChange(Property.ValueChangeEvent event);
		void onViewEnter();
	}
	
	void addListener(NewRentalViewListener listener);
	void attachVehiclesData(Container container);
	void setVehiclesTableHeader(String propertyName, String headerName);
	void setVehiclesTableVisibleColumns(Object... propertyName);
	void attachCustomerData(Container container);
	void setCustomerTableHeader(String propertyName, String headerName);
	void setCustomerTableVisibleColumns(Object... propertyName);
	
	void showWrongStartDate(String message);
	void showWrongEndDate(String message);
	void showRentUnsuccessfull(String message);
	void showRentSuccessfull(String message);
	
	void clearStartDate();
	void clearEndDate();
	void clearCustomerSelection();
	void clearVehicleSelection();
	
	void setNumberOfVehicles(Integer num);
	void setDailyPrice(Double value);
	void setTotal(Double value);

}
