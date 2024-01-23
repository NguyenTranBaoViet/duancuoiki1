package view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import DAO.HotelDAOThongTin;
import controller.ControllerThongTin;

import model.QuanLyModel;

public class ThongTinView extends JFrame{

	public JLabel labelTen;
	public JLabel labelNgaySinh;
	public JLabel labelQueQuan;
	public JLabel labelSdt;
	public JLabel labelGioiTinh;
	public JButton buttonSuaThongTin;
	private QuanLyModel quanLyModel;
	private DangNhapView dangNhapView;

	public ThongTinView() {
		setTitle("Thông tin người dùng");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7,1));
        
        labelTen = new JLabel();
        panel.add(labelTen);
        
        labelNgaySinh = new JLabel();
        panel.add(labelNgaySinh);
        
        labelQueQuan = new JLabel();
        panel.add(labelQueQuan);
        
        labelSdt = new JLabel();
        panel.add(labelSdt);
        
        labelGioiTinh = new JLabel();
        panel.add(labelGioiTinh);
        
        
        
        JButton button_dichVu = new JButton("Dịch vụ");
        button_dichVu.addActionListener(e -> {
			GiaoDienNguoiDungView view = new GiaoDienNguoiDungView();
			dispose();
			view.setVisible(true);
		});
        panel.add(button_dichVu);
        
        this.add(panel);
        this.setVisible(true);
    }
    


	public void hienThiThongTin(String ten, String ngaySinh, String queQuan, String sdt, String gioiTinh) {
		
        labelTen.setText("Tên: " + ten);
        labelNgaySinh.setText("Ngày sinh: " + ngaySinh);
        labelQueQuan.setText("Quê quán: " + queQuan);
        labelSdt.setText("Số điện thoại: " + sdt);
        labelGioiTinh.setText("Giới tính: " + gioiTinh);
        
        
        setVisible(true);
    
	}
public static void main(String[] args) {
	new ThongTinView();
}
public void xoa() {
	ThongTinView thongTinView = new ThongTinView();
	
	HotelDAOThongTin daoThongTin = new HotelDAOThongTin();
	daoThongTin.xoaDuLieu(thongTinView);
	
}
}
