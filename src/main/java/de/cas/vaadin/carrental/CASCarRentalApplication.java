package de.cas.vaadin.carrental;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import de.cas.vaadin.carrental.presenter.CustomersPresenter;
import de.cas.vaadin.carrental.presenter.LoginPresenter;
import de.cas.vaadin.carrental.presenter.RentalsPresenter;
import de.cas.vaadin.carrental.presenter.VehiclesPresenter;
import de.cas.vaadin.carrental.service.Navigation;
import de.cas.vaadin.carrental.service.Routes;
import de.cas.vaadin.carrental.view.customers.CustomersView;
import de.cas.vaadin.carrental.view.customers.CustomersViewImpl;
import de.cas.vaadin.carrental.view.login.LoginView;
import de.cas.vaadin.carrental.view.login.LoginViewImpl;
import de.cas.vaadin.carrental.view.rentals.RentalsView;
import de.cas.vaadin.carrental.view.rentals.RentalsViewImpl;
import de.cas.vaadin.carrental.view.vehicles.VehiclesView;
import de.cas.vaadin.carrental.view.vehicles.VehiclesViewImpl;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@Title("CAS Car Rental Application")
public class CASCarRentalApplication extends UI {
	
	private static UI instance;
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	instance = this;
    	final LoginView loginView = new LoginViewImpl();
    	final LoginPresenter loginPresenter = new LoginPresenter(loginView);
    	final VehiclesView vehiclesView = new VehiclesViewImpl();
    	final VehiclesPresenter vehiclesPresenter = new VehiclesPresenter(vehiclesView);
    	final CustomersView customersView = new CustomersViewImpl();
    	final CustomersPresenter customersPresenter = new CustomersPresenter(customersView);
    	final RentalsView rentalsView = new RentalsViewImpl();
    	final RentalsPresenter rentalsPresenter = new RentalsPresenter(rentalsView);
    	Navigation.init(this);
    	Navigation.addView(Routes.LOGIN, loginView);
    	Navigation.addView(Routes.VEHICLES, vehiclesView);
    	Navigation.addView(Routes.CUSTOMERS, customersView);
    	Navigation.addView(Routes.RENTALS, rentalsView);
    	VerticalLayout layout = new VerticalLayout();
    	this.setWidthUndefined();
    }
    
    public static UI getMainUI() {
    	return instance;
    }
    
    @WebServlet(value = {"/carrental/*", "/VAADIN/*"}, name = "CASCarRentalApplicationServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = CASCarRentalApplication.class, productionMode = false)
    public static class CASCarRentalApplicationServlet extends VaadinServlet {
    }
}
