package de.cas.vaadin.carrental;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import de.cas.vaadin.carrental.presenter.LoginPresenter;
import de.cas.vaadin.carrental.service.login.LoginService;
import de.cas.vaadin.carrental.service.login.LoginServiceImpl;
import de.cas.vaadin.carrental.view.LoginView;
import de.cas.vaadin.carrental.view.LoginViewImpl;

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


	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	final LoginViewImpl loginView = new LoginViewImpl();
    	final LoginService loginService = new LoginServiceImpl();
    	final LoginPresenter loginPresenter = new LoginPresenter(loginService, loginView);
    	loginView.addListener(loginPresenter);
    	VerticalLayout layout = new VerticalLayout();
    	layout.addComponent(loginView);
    	setContent(loginView);
    }

    @WebServlet(value = {"/carrental/*", "/VAADIN/*"}, name = "CASCarRentalApplicationServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = CASCarRentalApplication.class, productionMode = false)
    public static class CASCarRentalApplicationServlet extends VaadinServlet {
    }
}
