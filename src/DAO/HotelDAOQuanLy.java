package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;

import model.HotelModel;
import model.QuanLyModel;
import view.timKiem;

public class HotelDAOQuanLy {
	private QuanLyModel quanLyModel;
	
	
	public ArrayList<QuanLyModel> sellectAll(){
		quanLyModel = new QuanLyModel();
		ArrayList<QuanLyModel> ketQua = new ArrayList<QuanLyModel>();
		
		try {
			Connection connection = JDBCUtil.getConnection();
			Statement st = connection.createStatement();
			String sql = "SELECT * FROM users";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int ma = rs.getInt("ma");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String Ten = rs.getString("Ten");
				String NgaySinh = rs.getString("NgaySinh");
				String QueQuan = rs.getString("QueQuan");
				String GioiTinh = rs.getString("GioiTinh");
				String Sdt = rs.getString("Sdt");
				
				QuanLyModel quanLyModel = new QuanLyModel(ma, username, password, email, Ten, NgaySinh, QueQuan, GioiTinh, Sdt);
				ketQua.add(quanLyModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ketQua;
	}
	public boolean suaDuLieu(QuanLyModel model) {
		String query = "UPDATE users SET ma = ?, username = ?, password = ?, email = ?, Ten = ?, NgaySinh = ?, QueQuan = ?,gioitinh = ?,Sdt = ? WHERE soPhong = ?";
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement st = connection.prepareStatement(query);
			
			st.setInt(1, model.getMa());
			st.setString(2, model.getUsername());
			st.setString(3, model.getPassword());
			st.setString(4, model.getEmail());
			st.setString(5, model.getTen());
			st.setString(6, model.getNgaySinh());
			st.setString(7, model.getQueQuan());
			st.setString(8, model.getGioiTinh());
			st.setString(9, model.getSdt());
			int rowUpdate = st.executeUpdate();
			return rowUpdate > 0;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	public void luuDuLieu(QuanLyModel model) {
		 try {
			 if(kiemTraTonTai(model)) {
					System.out.println("Bản ghi tồn tại ,không thể thêm mới");
					return;
				}
		        Connection connection = JDBCUtil.getConnection();
		        String sql = "UPDATE users SET  username = ?, password = ?, email = ?, Ten = ?, NgaySinh = ?, QueQuan = ?, GioiTinh = ?, Sdt = ? WHERE ma = ?";

		        PreparedStatement statement = connection.prepareStatement(sql);
		        statement.setString(1, model.getUsername());
		        statement.setString(2, model.getPassword());
		        statement.setString(3, model.getEmail());
		        statement.setString(4, model.getTen()); 	
		        statement.setString(5, model.getNgaySinh());
		        statement.setString(6, model.getQueQuan());
		        statement.setString(7, model.getGioiTinh());
		        statement.setString(8, model.getSdt());
		        statement.setInt(9, model.getMa());

		        statement.executeUpdate();
		        statement.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

}
	public boolean kiemTraTonTai(QuanLyModel model) {
		String sql = "SELECT * FROM users WHERE soPhong = ?";
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, model.getMa());
			ResultSet rs = st.executeQuery();
			boolean tonTai = rs.next();
			rs.close();
			st.close();
			return tonTai;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}


