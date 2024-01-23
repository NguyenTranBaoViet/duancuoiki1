package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import database.JDBCUtil;

import view.ThongTinView;

public class HotelDAOThongTin {
	private ThongTinView thongTinView;
	public void xoaDuLieu(ThongTinView thongTinView) {
		String sql = "DELETE FROM users WHERE Ten = ?";
		String Ten = thongTinView.labelTen.getText();
		String Ngaysinh = thongTinView.labelNgaySinh.getText();
		String quequan = thongTinView.labelQueQuan.getText();
		String sdt = thongTinView.labelSdt.getText();
		String gioitinh = thongTinView.labelGioiTinh.getText();
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1,Ten);
			st.executeUpdate();
			st.close();
			JOptionPane.showMessageDialog(thongTinView, "Dữ liệu được xóa thành công");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
   
   
}