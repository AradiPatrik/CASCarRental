package de.cas.vaadin.carrental.view.navigation;

import com.vaadin.ui.Component;

public interface NavigationView extends Component {
	public interface NavigationViewListener {
		void onVehiclesClick();
		void onCustomersClick();
		void onRentalsClick();
		void onNewRentalClick();
	}
	
	public void addListener(NavigationViewListener listener);
}
