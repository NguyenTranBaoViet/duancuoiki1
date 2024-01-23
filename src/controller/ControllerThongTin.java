package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ThongTinView;

public class ControllerThongTin implements ActionListener{
	private ThongTinView thongTinView;
	public ControllerThongTin(ThongTinView thongTinView) {
		this.thongTinView = thongTinView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if(button.equals("Sửa thông tin")) {
			this.thongTinView.xoa();
		}
		
	}

}
