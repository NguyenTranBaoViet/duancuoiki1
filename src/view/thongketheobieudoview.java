package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import database.JDBCUtil;

public class thongketheobieudoview extends JFrame {

	public JLabel label;
	public JTextArea textarea;
	public JButton button_thongke;

	public thongketheobieudoview() {
		this.setTitle("Thống kê");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Tổng số phòng", this.tongPhong());
		dataset.setValue("Số phòng trống", this.phongcon());
		dataset.setValue("Số phòng đã thuê ", this.phongdathue());
		dataset.setValue("Số phòng VIP", this.phongvip());
		dataset.setValue("Số phòng thường", this.phongthuong());
		JFreeChart barchar = ChartFactory.createPieChart3D("Biểu đồ thống kê sách trong thư viện", (PieDataset) dataset,
				true, true, false);
		ChartPanel panel = new ChartPanel(barchar);
		
		JButton button_tat = new JButton("Tắt");
		button_tat.addActionListener(e -> {
			HotelView hotelView = new HotelView();
			dispose();
			
			hotelView.hienThi();
		});
		
		this.add(panel,BorderLayout.CENTER);
		this.add(button_tat,BorderLayout.SOUTH);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new thongketheobieudoview();
	}

	public int tongPhong() {
		int tongPhong = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			Statement statement = connection.createStatement();

			ResultSet rsTongPhong = statement.executeQuery("SELECT COUNT(*) as tongPhong FROM hotel");
			rsTongPhong.next();
			tongPhong = rsTongPhong.getInt("tongPhong");
			rsTongPhong.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tongPhong;
	}

	public int phongcon() {
		int phongcon = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			Statement statement = connection.createStatement();

			ResultSet rsPhongCon = statement
					.executeQuery("SELECT COUNT(*) as phongCon FROM hotel WHERE trangThai = 'Còn'");
			rsPhongCon.next();
			phongcon = rsPhongCon.getInt("phongCon");
			rsPhongCon.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return phongcon;
	}

	public int phongdathue() {
		int phongdathue = 0;
		try {

			phongdathue = this.tongPhong() - this.phongcon();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return phongdathue;
	}
	public int phongvip() {
		int phongvip = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			Statement statement = connection.createStatement();
			 ResultSet rsPhongVIP = statement.executeQuery("SELECT COUNT(*) as phongVIP FROM hotel WHERE loaiPhong = 'VIP'");
		     rsPhongVIP.next();
		     phongvip = rsPhongVIP.getInt("phongVIP");
		     rsPhongVIP.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return phongvip;
	}
	public int phongthuong() {
		int phongthuong = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			Statement statement = connection.createStatement();
			 ResultSet rsPhongThuong = statement.executeQuery("SELECT COUNT(*) as phongThuong FROM hotel WHERE loaiPhong = 'thường'");
			 rsPhongThuong.next();
			 phongthuong = rsPhongThuong.getInt("phongThuong");
		     rsPhongThuong.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return phongthuong;
	}
	
	
}
