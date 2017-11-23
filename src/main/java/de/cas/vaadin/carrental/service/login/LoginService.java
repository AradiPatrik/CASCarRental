package de.cas.vaadin.carrental.service.login;

import java.io.IOException;

import de.cas.vaadin.carrental.model.Credentals;
import de.cas.vaadin.carrental.model.Customer;
import de.cas.vaadin.carrental.service.exception.UserNotFoundException;
import de.cas.vaadin.carrental.service.exception.WrongPasswordException;

public interface LoginService {

	Customer authenticateAndGetUser(String username, String password)
			throws UserNotFoundException, WrongPasswordException;
}
