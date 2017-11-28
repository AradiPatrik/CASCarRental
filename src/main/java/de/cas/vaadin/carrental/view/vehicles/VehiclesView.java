package de.cas.vaadin.carrental.view.vehicles;

import com.vaadin.navigator.View;

public interface VehiclesView extends View {
	interface VehiclesViewListener {
		void onLogin(String username, String password);
	}
	
	void addListener(VehiclesViewListener listener);
	
}
