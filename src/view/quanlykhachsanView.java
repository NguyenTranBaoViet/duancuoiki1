package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.HotelDAO;
import DAO.HotelDAOQuanLy;
import controller.ControllerQuanLy;

import model.HotelModel;
import model.QuanLyModel;

public class quanlykhachsanView extends JFrame{

	public DefaultTableModel dm;
	private JTable tbl;
	private JTextField field_ma;
	private JTextField field_username;
	private JTextField field_password;
	private JTextField field_email;
	private JTextField field_ten;
	private JTextField field_ngaysinh;
	private JTextField field_quequan;
	private JTextField field_gioitinh;
	private JTextField field_sdt;
	

	public quanlykhachsanView() {
		this.setTitle("Quản lý tài khoản ");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout(10,10));
		ControllerQuanLy ql = new ControllerQuanLy(this);
		
		Color color2 = new Color(210,105,30);
		Color color_jlb = new Color(255,222,173);
		Color color_letter = new Color(105,105,105);
		
		JPanel jPanel_all = new JPanel();
		jPanel_all.setLayout(new BorderLayout(10,10));
		jPanel_all.setBackground(Color.ORANGE);
		
		JPanel jPanel_north = new JPanel();
		jPanel_north.setLayout(new GridLayout(5,2,10,10));
		jPanel_north.setBackground(Color.ORANGE);
		
		JLabel jLabel_ma = new  JLabel("mã");
		jLabel_ma.setBackground(color2);
		jLabel_ma.setOpaque(true);
		jLabel_ma.setForeground(Color.BLACK);
		 field_ma = new JTextField();
		 field_ma.setBackground(color_jlb);
		 field_ma.setOpaque(true);
		 field_ma.setForeground(color_letter);
		 
		JLabel jLabel_username = new  JLabel("username");
		jLabel_username.setBackground(color2);
		jLabel_username.setOpaque(true);
		jLabel_username.setForeground(Color.BLACK);
		field_username = new JTextField();
		field_username.setBackground(color_jlb);
		field_username.setOpaque(true);
		field_username.setForeground(color_letter);
		 
		JLabel jLabel_password = new  JLabel("password");
		jLabel_password.setBackground(color2);
		jLabel_password.setOpaque(true);
		jLabel_password.setForeground(Color.BLACK);
			field_password = new JTextField();
			field_password.setBackground(color_jlb);
			field_password.setOpaque(true);
			field_password.setForeground(color_letter);
		 
		JLabel jLabel_email = new  JLabel("email");
		jLabel_email.setBackground(color2);
		jLabel_email.setOpaque(true);
		jLabel_email.setForeground(Color.BLACK);
			field_email = new JTextField();
			field_email.setBackground(color_jlb);
			field_email.setOpaque(true);
			field_email.setForeground(color_letter);
		 
		JLabel jLabel_ten = new  JLabel("tên");
		 jLabel_ten.setBackground(color2);
		 jLabel_ten.setOpaque(true);
		 jLabel_ten.setForeground(Color.BLACK);
		 field_ten = new JTextField();
		 field_ten.setBackground(color_jlb);
		 field_ten.setOpaque(true);
		 field_ten.setForeground(color_letter);
		 
		JLabel jLabel_ngaysinh = new  JLabel("ngày sinh");
		jLabel_ngaysinh.setBackground(color2);
		jLabel_ngaysinh.setOpaque(true);
		jLabel_ngaysinh.setForeground(Color.BLACK);
			field_ngaysinh = new JTextField();
			field_ngaysinh.setBackground(color_jlb);
			field_ngaysinh.setOpaque(true);
			field_ngaysinh.setForeground(color_letter);
		 
		JLabel jLabel_quequan = new  JLabel("quê quán");
		 field_quequan = new JTextField();
		 jLabel_quequan.setBackground(color2);
		 jLabel_quequan.setOpaque(true);
		 jLabel_quequan.setForeground(Color.BLACK);
		 field_quequan = new JTextField();
		 field_quequan.setBackground(color_jlb);
		 field_quequan.setOpaque(true);
		 field_quequan.setForeground(color_letter);
		 
		JLabel jLabel_gioitinh = new  JLabel("giới tính");
		 jLabel_gioitinh.setBackground(color2);
		 jLabel_gioitinh.setOpaque(true);
		 jLabel_gioitinh.setForeground(Color.BLACK);
		 field_gioitinh = new JTextField();
		 field_gioitinh.setBackground(color_jlb);
		 field_gioitinh.setOpaque(true);
		 field_gioitinh.setForeground(color_letter);
		 
		JLabel jLabel_sdt = new  JLabel("số điện thoại");
		 field_sdt = new JTextField();
		 jLabel_sdt.setBackground(color2);
		 jLabel_sdt.setOpaque(true);
		 jLabel_sdt.setForeground(Color.BLACK);
		 field_sdt = new JTextField();
		 field_sdt.setBackground(color_jlb);
		 field_sdt.setOpaque(true);
		 field_sdt.setForeground(color_letter);
		
		jPanel_north.add(jLabel_ma);
		jPanel_north.add(field_ma);
		jPanel_north.add(jLabel_username);
		jPanel_north.add(field_username);
		jPanel_north.add(jLabel_password);
		jPanel_north.add(field_password);
		jPanel_north.add(jLabel_email);
		jPanel_north.add(field_email);
		jPanel_north.add(jLabel_ten);
		jPanel_north.add(field_ten);
		jPanel_north.add(jLabel_ngaysinh);
		jPanel_north.add(field_ngaysinh);
		jPanel_north.add(jLabel_quequan);
		jPanel_north.add(field_quequan);
		jPanel_north.add(jLabel_gioitinh);
		jPanel_north.add(field_gioitinh);
		jPanel_north.add(jLabel_sdt);
		jPanel_north.add(field_sdt);
		
		
		
		
		dm = new DefaultTableModel();
		tbl = new JTable(dm);
		dm.addColumn("ma");
		dm.addColumn("username");
		dm.addColumn("password");
		dm.addColumn("email");
		dm.addColumn("Ten");
		dm.addColumn("NgaySinh");
		dm.addColumn("QueQuan");
		dm.addColumn("GioiTinh");
		dm.addColumn("Sdt");
		
		tbl.setBackground(Color.ORANGE);
		tbl.setOpaque(true);
		
		Color color_button = new Color(255,218,185);
		
		JPanel jPanel_button = new JPanel();
		jPanel_button.setLayout(new GridLayout(1,3,20,20));
		jPanel_button.setBackground(Color.ORANGE);
		
		JButton suadl = new JButton("Sửa dữ liệu");
		suadl.addActionListener(ql);
		suadl.setBackground(Color.YELLOW);
		
		JButton luudl = new JButton("Lưu dữ liệu");
		luudl.addActionListener(ql);
		luudl.setBackground(Color.YELLOW);
		
		JButton hienthi = new JButton("Hiển thị người dùng");
		hienthi.addActionListener(ql);
		hienthi.setBackground(Color.YELLOW);
		
		JButton quaylai = new JButton("Quay lại");
		quaylai.setBackground(Color.YELLOW);
		
		
		jPanel_button.add(suadl);
		jPanel_button.add(luudl);
		jPanel_button.add(quaylai);
		quaylai.addActionListener(e -> {
			HotelView hotelView = new HotelView();
			dispose();
			
			hotelView.hienThi();
		});
		
		jPanel_all.add(jPanel_north,BorderLayout.CENTER);
		jPanel_all.add(jPanel_button,BorderLayout.SOUTH);
		
		
		JScrollPane scr = new JScrollPane(tbl);
		scr.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	
		
		this.add(jPanel_all,BorderLayout.NORTH);
		this.add(scr,BorderLayout.CENTER);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new quanlykhachsanView();
	}
	public void hienThi() {
		HotelDAOQuanLy hotelDAOQuanLy = new HotelDAOQuanLy();
		dm.setRowCount(0);
		ArrayList<QuanLyModel> list = hotelDAOQuanLy.sellectAll();
		for (QuanLyModel quanLyModel : list) {
			dm.addRow(new Object[] {quanLyModel.getMa(),quanLyModel.getUsername(),quanLyModel.getPassword(),quanLyModel.getEmail(),quanLyModel.getTen(),quanLyModel.getNgaySinh(),quanLyModel.getQueQuan(),quanLyModel.getGioiTinh(),quanLyModel.getSdt()});
		}
	}
	public void suadulieu() {
		int selectRow = tbl.getSelectedRow();
		if(selectRow==-1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để sửa");
		}
		if(selectRow!=-1) {
			int ma = Integer.valueOf(tbl.getValueAt(selectRow, 0)+"");
			String username = tbl.getValueAt(selectRow, 1)+"";
			String password = tbl.getValueAt(selectRow, 2)+"";
			String email = tbl.getValueAt(selectRow, 3)+"";
			String ten = tbl.getValueAt(selectRow, 4)+"";
			String ngaysinh = tbl.getValueAt(selectRow, 5)+"";
			String quequan = tbl.getValueAt(selectRow, 6)+"";
			String gioitinh = tbl.getValueAt(selectRow, 7)+"";
			String sdt = tbl.getValueAt(selectRow, 8)+"";
			this.field_ma.setText(ma+"");
			this.field_username.setText(username+"");
			this.field_password.setText(password+"");
			this.field_email.setText(email+"");
			this.field_ten.setText(ten+"");
			this.field_ngaysinh.setText(ngaysinh+"");
			this.field_quequan.setText(quequan+"");
			this.field_gioitinh.setText(gioitinh+"");
			this.field_sdt.setText(sdt+"");
			
		}
	}
	public void luu() {
		int selectRow = tbl.getSelectedRow();
		if(selectRow==-1) {
			JOptionPane.showMessageDialog(this, "Hãy sửa dữ liệu rồi lưu");
		}
		int ma = Integer.valueOf(this.field_ma.getText());
		String username = this.field_username.getText();
		String password = this.field_password.getText();
		String email = this.field_email.getText();
		String ten = this.field_ten.getText();
		String ngaysinh = this.field_ngaysinh.getText();
		String quenquan = this.field_quequan.getText();
		String gioitinh = this.field_gioitinh.getText();
		String sdt = this.field_sdt.getText();

		QuanLyModel model = new QuanLyModel(ma, username, password, email, ten, ngaysinh, quenquan, gioitinh, sdt);
		 int selectedRow = tbl.getSelectedRow();
		    if (selectedRow != -1) {
		        
		        dm.setValueAt(ma, selectedRow, 0);
		        dm.setValueAt(username, selectedRow, 1);
		        dm.setValueAt(password, selectedRow, 2);
		        dm.setValueAt(email, selectedRow, 3);
		        dm.setValueAt(ten, selectedRow, 4);
		        dm.setValueAt(ngaysinh, selectedRow, 5);
		        dm.setValueAt(quenquan, selectedRow, 6);
		        dm.setValueAt(gioitinh, selectedRow, 7);
		        dm.setValueAt(sdt, selectedRow, 8);
		        
		 
		        HotelDAOQuanLy dao = new HotelDAOQuanLy();
		        dao.luuDuLieu(model);
		}
}
}