package de.cas.vaadin.carrental.service;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.ui.UI;

public class Navigation {
	private static Navigator navigator;
	
	public static void init(UI ui) {
		navigator = new Navigator(ui, ui);
	}
	
	public static void addView(Routes route, View view) {
		navigator.addView(route.getPath(), view);
	}
	
	
}
