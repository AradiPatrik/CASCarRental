package de.cas.vaadin.carrental.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;

public class LoginViewImpl extends CustomComponent implements LoginView, Button.ClickListener {

	private TextField usernameTextField = new TextField("User Name: ");
	private PasswordField passwordField = new PasswordField("Password: ");
	private Button loginButton = new Button("Login");

	private static final String WRONG_PASSWORD_CAPTION = "Bad Password";
	private static final String WRONG_PASSWORD_MESSAGE = "If you forgot your password, please contact us at: notarealemail@gmail.com";
	
	private static final String WRONG_USER_CAPTION = "Could not find user with name: ";
	private static final String WRONG_USER_MESSAGE = "If you forgot your username, please contact us at: notarealemail@gmail.com";
	
	public LoginViewImpl() {
		FormLayout layout = new FormLayout();
		loginButton.addClickListener(this);
		layout.addComponents(usernameTextField, passwordField, loginButton);

		setCompositionRoot(layout);
	}

	List<LoginViewListener> listeners = new ArrayList<>();

	@Override
	public void addListener(LoginViewListener listener) {
		listeners.add(listener);
	}

	@Override
	public void buttonClick(Button.ClickEvent event) {
		for (LoginViewListener listener : listeners) {
			listener.onLogin(usernameTextField.getValue(), passwordField.getValue());
		}
	}

	@Override
	public void notifyBadPassword(String password) {
		Notification.show(WRONG_PASSWORD_CAPTION, WRONG_PASSWORD_MESSAGE, Type.ERROR_MESSAGE);
	}

	@Override
	public void notifyUserNotFound(String username) {
		Notification.show(WRONG_USER_CAPTION + username, WRONG_USER_MESSAGE, Type.ERROR_MESSAGE);
	}

}
