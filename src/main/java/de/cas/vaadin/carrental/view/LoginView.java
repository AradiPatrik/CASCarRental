package de.cas.vaadin.carrental.view;

import com.vaadin.ui.FormLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;

public interface LoginView {
	interface LoginViewListener {
		void onLogin(String username, String password);
	}
	
	void addListener(LoginViewListener listener);
	void notifyBadPassword(String password);
	void notifyUserNotFound(String username);
}
