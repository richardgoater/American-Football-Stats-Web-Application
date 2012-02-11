package uk.co.richardgoater.stats.ui;

import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

public class AdminLoginWindow extends Window {

	TextField username = new TextField("USERNAME");
	TextField password = new TextField("PASSWORD");
	Button login = new Button("LOGIN");

	public AdminLoginWindow() {
		// TODO Auto-generated constructor stub
	}

	public AdminLoginWindow(String caption) {
		super(caption);

		setModal(true);
		setPositionY(180);
		setPositionX(50);

		setWidth("200px");

		addComponent(username);
		addComponent(password);
		addComponent(login);
	}

	public Button getButton() {
		return login;
	}
}
