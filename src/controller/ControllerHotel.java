package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.text.View;

import database.JDBCUtil;
import model.HotelModel;
import view.HotelView;
import view.login;

public class ControllerHotel implements ActionListener {
	private HotelView hotelView;
	private Object rs;

	public ControllerHotel(HotelView hotelView) {
		this.hotelView = hotelView;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if(button.equals("Làm trống")) {
			this.hotelView.lamTrong();
			
		}
		else if(button.equals("Xóa")) {
			this.hotelView.xoa();
		}
		
		else if(button.equals("Sửa")) {
			this.hotelView.sua();
		}
		else if(button.equals("Hiển thị")) {
			this.hotelView.hienThi();
		}
		else if(button.equals("Cập nhật")) {
			this.hotelView.luu();
		}
		else if(button.equals("Thêm")) {
			this.hotelView.them();
		}
		else if(button.equals("Thoát")) {
			System.exit(0);
		}
		else if(button.equals("Tìm kiếm")) {
			
		}else if(button.equals("Thực đơn")) {
			
		}else if(button.equals("Thống kê")) {
			
		}else if(button.equals("Đăng xuất")) {
			int option = JOptionPane.showOptionDialog(
	                null,
	                "Bạn có chắc muốn đăng xuất?", 
	                "Xác nhận đăng xuất",
	                JOptionPane.YES_NO_OPTION,
	                JOptionPane.QUESTION_MESSAGE,
	                null,
	                new Object[]{"Đồng ý", "Không"}, 
	                "Không" 
	        );

	        if (option == JOptionPane.YES_OPTION) {
	            System.out.println("Đăng xuất thành công!");
	            hotelView.dispose();
	            login login = new login();
	            login.setVisible(true);
	        } else {
	           
	            System.out.println("Tiếp tục hoạt động!");
	        }
		}
		
	}

}
