package DAO;

import java.awt.geom.Area;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import database.JDBCUtil;
import model.HotelModel;
import view.timKiem;

public class HotelDAO {
	private HotelModel hotelModel;
	public timKiem timkiem;
	public ArrayList<HotelModel> sellectAll(){
		hotelModel = new HotelModel();
		ArrayList<HotelModel> ketQua = new ArrayList<HotelModel>();

		try {
			Connection connection = JDBCUtil.getConnection();
			Statement st = connection.createStatement();
			String sql = "SELECT * FROM hotel";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int soPhong = rs.getInt("soPhong");
				String loaiPhong = rs.getString("loaiPhong");
				float giaPhong = rs.getFloat("giaPhong");
				String trangThai = rs.getString("trangThai");
				String maNguoiThue = rs.getString("maNguoiThue");
				String tenNguoiThue = rs.getString("tenNguoiThue");
				String gioiTinh = rs.getString("gioiTinh");
				String soDienThoai = rs.getString("soDienThoai");

				HotelModel hotelModel = new HotelModel(soPhong, loaiPhong, giaPhong, trangThai, maNguoiThue, tenNguoiThue, gioiTinh, soDienThoai);
				ketQua.add(hotelModel);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}
	
	public void luuDuLieu(HotelModel model) {
		try {
			if(kiemTraTonTai(model)) {
				System.out.println("Bản ghi tồn tại ,không thể thêm mới");
				return;
			}
			Connection connection = JDBCUtil.getConnection();
			 String sql = "UPDATE hotel SET loaiPhong = ?, giaPhong = ?, trangThai = ?, maNguoiThue = ?, tenNguoiThue = ?, gioiTinh = ?, soDienThoai = ? WHERE soPhong = ?";
			 PreparedStatement statement = connection.prepareStatement(sql);
	        
	        statement.setString(1, model.getLoaiPhong());
	        statement.setDouble(2, model.getGiaPhong());
	        statement.setString(3, model.getTrangThai());
	        statement.setString(4, model.getMaNguoiThue());
	        statement.setString(5, model.getTenNguoiThue());
	        statement.setString(6, model.getGioiTinh());
	        statement.setString(7, model.getSoDienThoai());
	        statement.setInt(8, model.getSoPhong());

	        statement.executeUpdate();
	        statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void xoaDuLieu(HotelModel model) {
		String sql = "DELETE FROM hotel WHERE soPhong = ?";
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1,model.getSoPhong() );
			st.executeUpdate();
			st.close();
			System.out.println("Dữ liệu đã được xóa thành công");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean kiemTraTonTai(HotelModel model) {
		String sql = "SELECT * FROM hotel WHERE soPhong = ?";
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, model.getSoPhong());
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

	public boolean suaDuLieu(HotelModel model) {
		String query = "UPDATE hotel SET loaiPhong = ?, giaPhong = ?, trangThai = ?, maNguoiThue = ?, tenNguoiThue = ?, gioiTinh = ?, soDienThoai = ? WHERE soPhong = ?";
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement st = connection.prepareStatement(query);
			
			st.setString(1, model.getLoaiPhong());
			st.setFloat(2, model.getGiaPhong());
			st.setString(3, model.getTrangThai());
			st.setString(4, model.getMaNguoiThue());
			st.setString(5, model.getTenNguoiThue());
			st.setString(6, model.getGioiTinh());
			st.setString(7, model.getSoDienThoai());
			st.setInt(8, model.getSoPhong());
			int rowUpdate = st.executeUpdate();
			return rowUpdate > 0;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	public void themDuLieu(HotelModel model) {
		try {
			Connection connection = JDBCUtil.getConnection();
			Statement st = connection.createStatement();
			
			String sql = "INSERT INTO hotel (soPhong, loaiPhong, giaPhong, trangThai, maNguoiThue, tenNguoiThue, gioiTinh, soDienThoai) "
			        + "VALUES (" + model.getSoPhong() + ", '" + model.getLoaiPhong() + "', " + model.getGiaPhong()
			        + ", '" + model.getTrangThai() + "', '" + model.getMaNguoiThue() + "', '"
			        + model.getTenNguoiThue() + "', '" + model.getGioiTinh() + "', '" + model.getSoDienThoai() + "')";
			st.executeUpdate(sql);
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<HotelModel> timKiemDuLieu(int so) {
	    ArrayList<HotelModel> ketQua = new ArrayList<HotelModel>();

	    try {
	        Connection connection = JDBCUtil.getConnection();
	        Statement st = connection.createStatement();
	        String sql = "Select * from hotel where soPhong like "+so+"";
	        
	       
	        ResultSet rs = st.executeQuery(sql);

	        while (rs.next()) {
	            int soPhong = rs.getInt("soPhong");
	            String loaiPhong = rs.getString("loaiPhong");
	            float giaPhong = rs.getFloat("giaPhong");
	            String trangThai = rs.getString("trangThai");
	            String maNguoiThue = rs.getString("maNguoiThue");
	            String tenNguoiThue = rs.getString("tenNguoiThue");
	            String gioiTinh = rs.getString("gioiTinh");
	            String soDienThoai = rs.getString("soDienThoai");

	            HotelModel hotelModel = new HotelModel(soPhong, loaiPhong, giaPhong, trangThai, maNguoiThue, tenNguoiThue, gioiTinh, soDienThoai);
	            ketQua.add(hotelModel);
	        }

	        st.close();
	        connection.close();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return ketQua;
	}
	public ArrayList<HotelModel> timKiemDuLieuTheoLoai(String loai) {
	    ArrayList<HotelModel> ketQua = new ArrayList<HotelModel>();

	    try {
	        Connection connection = JDBCUtil.getConnection();
	        Statement st = connection.createStatement();
	        String sql = "Select * from hotel where loaiPhong like '%"+loai+"%'";
	        
	       
	        ResultSet rs = st.executeQuery(sql);

	        while (rs.next()) {
	            int soPhong = rs.getInt("soPhong");
	            String loaiPhong = rs.getString("loaiPhong");
	            float giaPhong = rs.getFloat("giaPhong");
	            String trangThai = rs.getString("trangThai");
	            String maNguoiThue = rs.getString("maNguoiThue");
	            String tenNguoiThue = rs.getString("tenNguoiThue");
	            String gioiTinh = rs.getString("gioiTinh");
	            String soDienThoai = rs.getString("soDienThoai");

	            HotelModel hotelModel = new HotelModel(soPhong, loaiPhong, giaPhong, trangThai, maNguoiThue, tenNguoiThue, gioiTinh, soDienThoai);
	            ketQua.add(hotelModel);
	        }

	        st.close();
	        connection.close();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return ketQua;
	}
}
