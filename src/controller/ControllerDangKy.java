package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import database.JDBCUtil;
import view.DangKyView;
import view.DangNhapView;
import view.DanhGiaKhachSan;
import view.GiaoDienNguoiDungView;
import view.ThongTinView;


public class ControllerDangKy implements ActionListener{
	private DangKyView dangKyView;
	public ControllerDangKy(DangKyView dangKyView) {
		this.dangKyView = dangKyView;
	}
	private DangNhapView dangNhapView;
	public ControllerDangKy(DangNhapView dangNhapView) {
		this.dangNhapView = dangNhapView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if(button.equals("Đăng ký")) {
		String username = dangKyView.usernameField.getText();
		String password = new String(dangKyView.passwordField.getPassword());
		String email = dangKyView.emailField.getText();
		String Ten = dangKyView.field_ten.getText();
		String NgaySinh = dangKyView.field_ngaysinh.getText();
		String QueQuan = dangKyView.field_quequan.getText();
		String Sdt = dangKyView.field_sdt.getText();
		String GioiTinh = dangKyView.field_gioitinh.getText();
		try {
			Connection connection = JDBCUtil.getConnection();
			Statement statement = connection.createStatement();
			String sql = "INSERT INTO users (username, password, email, Ten, NgaySinh, QueQuan, Sdt, GioiTinh) VALUES ('" + username + "', '" + password + "', '" + email + "', '" + Ten + "', '" + NgaySinh + "', '" + QueQuan + "', '" + Sdt + "', '" + GioiTinh + "')";
			statement.executeUpdate(sql);
			
			JOptionPane.showMessageDialog(dangKyView, "Đăng ký tài khoản thành công");
			dangKyView.usernameField.setText("");
			dangKyView.passwordField.setText("");
			dangKyView.emailField.setText("");
			dangKyView.field_ten.setText("");
			dangKyView.field_ngaysinh.setText("");
			dangKyView.field_quequan.setText("");
			dangKyView.field_sdt.setText("");
			dangKyView.field_gioitinh.setText("");

			dangKyView.dangNhap.setVisible(true);
			
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}
		if(button.equals("Đăng nhập")) {
			String username = dangNhapView.usernameField.getText();
			String password = new String(dangNhapView.passwordField.getPassword());
			try {
				Connection connection = JDBCUtil.getConnection();
				Statement statement = connection.createStatement();
				String sql = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
				ResultSet rs = statement.executeQuery(sql);
				if(rs.next()) {
					JOptionPane.showMessageDialog(dangNhapView, "Đăng nhập thành công");
					dangNhapView.usernameField.setText("");
					dangNhapView.passwordField.setText("");
					ThongTinView thongTinView = new ThongTinView();
					DanhGiaKhachSan dg = new DanhGiaKhachSan();
					thongTinView.hienThiThongTin(rs.getString("Ten"), rs.getString("NgaySinh"),
					        rs.getString("QueQuan"), rs.getString("Sdt"), rs.getString("GioiTinh"));
					dangNhapView.dispose();
					thongTinView.setVisible(true);
					
				}else {
					JOptionPane.showMessageDialog(dangNhapView, "Tên đăng nhập nhập hoặc mật khẩu không đúng");
				}
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	

}
