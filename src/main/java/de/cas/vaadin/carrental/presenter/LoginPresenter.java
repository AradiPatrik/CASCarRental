package de.cas.vaadin.carrental.presenter;

import com.vaadin.ui.Notification;

import de.cas.vaadin.carrental.service.Navigation;
import de.cas.vaadin.carrental.service.Routes;
import de.cas.vaadin.carrental.service.Services;
import de.cas.vaadin.carrental.service.exception.UserNotFoundException;
import de.cas.vaadin.carrental.service.exception.WrongPasswordException;
import de.cas.vaadin.carrental.service.login.LoginService;
import de.cas.vaadin.carrental.view.login.LoginView;

public class LoginPresenter implements LoginView.LoginViewListener {

	LoginView loginView;
	LoginService loginService;

	public LoginPresenter(LoginView loginView) {
		this.loginService = Services.getLoginService();
		this.loginView = loginView;
		this.loginView.addListener(this);
	}

	@Override
	public void onLogin(String username, String password) {
		try {
			tryToLogin(username, password);
		} catch (UserNotFoundException ex) {
			loginView.notifyUserNotFound(username);
		} catch (WrongPasswordException ex) {
			loginView.notifyBadPassword(password);
		}
	}

	public void tryToLogin(String username, String password) throws UserNotFoundException, WrongPasswordException {
		this.loginService.authenticateAndGetUser(username, password);
		Navigation.navigateTo(Routes.VEHICLES);
	}

}
