package de.cas.vaadin.carrental.presenter;

import de.cas.vaadin.carrental.service.exception.UserNotFoundException;
import de.cas.vaadin.carrental.service.exception.WrongPasswordException;
import de.cas.vaadin.carrental.service.login.LoginService;
import de.cas.vaadin.carrental.view.LoginView;

public class LoginPresenter implements LoginView.LoginViewListener {

	LoginView loginView;
	LoginService loginService;

	public LoginPresenter(LoginService loginService, LoginView loginView) {
		this.loginService = loginService;
		this.loginView = loginView;
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
	}

}
