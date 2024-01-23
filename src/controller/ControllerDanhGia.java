package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import model.QuanLyModel;
import view.DanhGiaKhachSan;


public class ControllerDanhGia implements ActionListener{
	private DanhGiaKhachSan danhGiaKhachSan;
	private QuanLyModel model;
	public ControllerDanhGia(DanhGiaKhachSan danhGiaKhachSan) {
		this.danhGiaKhachSan = danhGiaKhachSan;
	}
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if(button.equals("Quay lại")) {
			
		}
		else if(button.equals("Gửi")) {
			this.danhGiaKhachSan.HotelDAODanhGia(model);
		}
		
	}

}
