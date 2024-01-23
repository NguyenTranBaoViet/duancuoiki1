package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.quanlykhachsanView;

public class ControllerQuanLy implements ActionListener{
	public quanlykhachsanView view;
	public ControllerQuanLy(quanlykhachsanView view) {
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String button = e.getActionCommand();
		if(button.equals("Hiển thị người dùng")) {
			this.view.hienThi();
		}else if(button.equals("Sửa dữ liệu")) {
			this.view.suadulieu();
		}else if(button.equals("Lưu dữ liệu")) {
			this.view.luu();
		}
	}

}
