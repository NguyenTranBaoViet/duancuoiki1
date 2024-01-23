package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.HotelView;
import view.login;

public class ControllerLogin implements ActionListener{
	private login login;

	public ControllerLogin(view.login login) {
		this.login = login;
	}

	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if(button.equals("Đăng nhập")) {
			
			
			this.login.heThongLogin();
			
		}
		
	}
	

}
