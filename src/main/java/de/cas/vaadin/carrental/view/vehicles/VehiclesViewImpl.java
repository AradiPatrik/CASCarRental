package de.cas.vaadin.carrental.view.vehicles;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;

public class VehiclesViewImpl implements VehiclesView{	
	
	private List<VehiclesViewListener> listeners = new ArrayList<>();
	
	public VehiclesViewImpl() {
		
	}
	
	@Override
	public void addListener(VehiclesViewListener listener) {
		// TODO Auto-generated method stub
		this.listeners.add(listener);
	}
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
}
