package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.HotelModel;
import view.thucDonView;
import view.timKiem;

public class ControllerTimKiem implements ActionListener{
	private timKiem timkiem;

	public ControllerTimKiem(timKiem timKiem) {
		this.timkiem = timKiem;
	}

	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if(button.equals("Tìm")) {
		
			
		}else if(button.equals("Quay lại")) {
			
		}
		
	}

}
