package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import DAO.HotelDAO;
import controller.ControllerHotel;
import model.HotelModel;

public class HotelView extends JFrame {
	private JTextField jtf_soPhong;
	private JTextField jtf_loaiPhong;
	private JTextField jtf_giaPhong;
	private JTextField jtf_trangThai;
	private JTextField jtf_maNguoiThue;
	private JTextField jtf_tenNguoithue;
	private JTextField jtf_gioiTinh;
	private JTextField jtf_sdt;
	private DefaultTableModel dm;
	private JTable tbl;
	private JComboBox ratingComboBox;
	public HotelView() {
		this.setTitle("Hotel Management System");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		ControllerHotel ls = new ControllerHotel(this);
		Color color_jlb = new Color(255,222,173);
		Color color_letter = new Color(105,105,105);
		JPanel jPanel_n = new JPanel();
		jPanel_n.setLayout(new BorderLayout(10,10));
		jPanel_n.setBackground(Color.ORANGE);
		
		
		JPanel jPanel_jlb = new JPanel();
		jPanel_jlb.setLayout(new GridLayout(2,4,10,10));
		jPanel_jlb.setBackground(Color.ORANGE);
	
		Color color2 = new Color(210,105,30);
		JLabel jlb_soPhong = new JLabel("Số phòng");
		jtf_soPhong = new JTextField();
		jlb_soPhong.setBackground(color2);
		jlb_soPhong.setOpaque(true);
		jlb_soPhong.setForeground(Color.BLACK);
		jtf_soPhong.setBackground(color_jlb);
		jtf_soPhong.setOpaque(true);
		jtf_soPhong.setForeground(color_letter);
		
		JLabel jlb_loaiPhong = new JLabel("Loại phòng");
		jtf_loaiPhong = new JTextField();
		jlb_loaiPhong.setBackground(color2);
		jlb_loaiPhong.setOpaque(true);
		jlb_loaiPhong.setForeground(Color.BLACK);
		jtf_loaiPhong.setBackground(color_jlb);
		jtf_loaiPhong.setOpaque(true);
		jtf_loaiPhong.setForeground(color_letter);
		
		JLabel jlb_giaPhong = new JLabel("Giá phòng");
		jtf_giaPhong = new JTextField();
		jlb_giaPhong.setBackground(color2);
		jlb_giaPhong.setOpaque(true);
		jlb_giaPhong.setForeground(Color.BLACK);
		jtf_giaPhong.setBackground(color_jlb);
		jtf_giaPhong.setOpaque(true);
		jtf_giaPhong.setForeground(color_letter);
		
		JLabel jlb_trangThai = new JLabel("Trạng thái");
		jtf_trangThai = new JTextField();
		jlb_trangThai.setBackground(color2);
		jlb_trangThai.setOpaque(true);
		jlb_trangThai.setForeground(Color.BLACK);
		jtf_trangThai.setBackground(color_jlb);
		jtf_trangThai.setOpaque(true);
		jtf_trangThai.setForeground(color_letter);
		
		JLabel jlb_maNguoiThue = new JLabel("Mã người thuê");
		jtf_maNguoiThue = new JTextField();
		jlb_maNguoiThue.setBackground(color2);
		jlb_maNguoiThue.setOpaque(true);
		jlb_maNguoiThue.setForeground(Color.BLACK);
		jtf_maNguoiThue.setBackground(color_jlb);
		jtf_maNguoiThue.setOpaque(true);
		jtf_maNguoiThue.setForeground(color_letter);
		
		JLabel jlb_tenNguoiThue = new JLabel("Tên người thuê");
		jtf_tenNguoithue = new JTextField();
		jlb_tenNguoiThue.setBackground(color2);
		jlb_tenNguoiThue.setOpaque(true);
		jlb_tenNguoiThue.setForeground(Color.BLACK);
		jtf_tenNguoithue.setBackground(color_jlb);
		jtf_tenNguoithue.setOpaque(true);
		jtf_tenNguoithue.setForeground(color_letter);
		
		JLabel jlb_gioiTinh = new JLabel("Giới tính");
		jtf_gioiTinh = new JTextField();
		jlb_gioiTinh.setBackground(color2);
		jlb_gioiTinh.setOpaque(true);
		jlb_gioiTinh.setForeground(Color.BLACK);
		jtf_gioiTinh.setBackground(color_jlb);
		jtf_gioiTinh.setOpaque(true);
		jtf_gioiTinh.setForeground(color_letter);
		
		JLabel jlb_sdt = new JLabel("Số điện thoại");
		jtf_sdt = new JTextField();
		jlb_sdt.setBackground(color2);
		jlb_sdt.setOpaque(true);
		jlb_sdt.setForeground(Color.BLACK);
		jtf_sdt.setBackground(color_jlb);
		jtf_sdt.setOpaque(true);
		jtf_sdt.setForeground(color_letter);
		
		jPanel_jlb.add(jlb_soPhong);
		jPanel_jlb.add(jtf_soPhong);
		jPanel_jlb.add(jlb_loaiPhong);
		jPanel_jlb.add(jtf_loaiPhong);
		jPanel_jlb.add(jlb_giaPhong);
		jPanel_jlb.add(jtf_giaPhong);
		jPanel_jlb.add(jlb_trangThai);
		jPanel_jlb.add(jtf_trangThai);
		jPanel_jlb.add(jlb_maNguoiThue);
		jPanel_jlb.add(jtf_maNguoiThue);
		jPanel_jlb.add(jlb_tenNguoiThue);
		jPanel_jlb.add(jtf_tenNguoithue);
		jPanel_jlb.add(jlb_gioiTinh);
		jPanel_jlb.add(jtf_gioiTinh);
		jPanel_jlb.add(jlb_sdt);
		jPanel_jlb.add(jtf_sdt);
		jPanel_n.add(jPanel_jlb,BorderLayout.CENTER);
		
		JPanel jpn_button = new JPanel();
		jpn_button.setLayout(new GridLayout(1,4,10,10));
		jpn_button.setBackground(Color.ORANGE);
		Color color_button = new Color(255,218,185);
		
		
		JButton button_lamTrong = new JButton("Làm trống");
		button_lamTrong.addActionListener(ls);
		button_lamTrong.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("new.png"))));
		button_lamTrong.setBackground(Color.YELLOW);
		
		JButton button_xoa = new JButton("Xóa");
		button_xoa.addActionListener(ls);
		button_xoa.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("delete.png"))));
		button_xoa.setBackground(Color.YELLOW);
		
		JButton button_sua = new JButton("Sửa");
		button_sua.addActionListener(ls);
		button_sua.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("update.png"))));
		button_sua.setBackground(Color.YELLOW);
		
		JButton button_hienthi = new JButton("Hiển thị");
		button_hienthi.addActionListener(ls);
		button_hienthi.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("eyes.png"))));
		button_hienthi.setBackground(Color.YELLOW);
		
		JButton button_luu = new JButton("Cập nhật");
		button_luu.addActionListener(ls);
		button_luu.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("save.png"))));
		button_luu.setBackground(Color.YELLOW);
		
		JButton button_them = new JButton("Thêm");
		button_them.addActionListener(ls);
		button_them.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("add.png"))));
		button_them.setBackground(Color.YELLOW);
		
		jpn_button.add(button_lamTrong);
		jpn_button.add(button_xoa);
		jpn_button.add(button_sua);
		jpn_button.add(button_luu);
		jpn_button.add(button_them);
		jPanel_n.add(jpn_button,BorderLayout.SOUTH);
		
		dm = new DefaultTableModel();
		tbl = new JTable(dm);
		dm.addColumn("Số phòng");
		dm.addColumn("Loại phòng");
		dm.addColumn("Giá phòng");
		dm.addColumn("Trạng thái");
		dm.addColumn("Mã người thuê");
		dm.addColumn("Tên người thuê");
		dm.addColumn("Giới tính");
		dm.addColumn("Số điện thoại");
		JScrollPane scr = new JScrollPane(tbl);
		scr.setBorder(BorderFactory.createLineBorder(Color.BLACK));
tbl.setBackground(Color.ORANGE);
tbl.setOpaque(true);
scr.setBackground(Color.ORANGE);
		
		
		
		JMenuBar mnb = new JMenuBar();
		JMenu dichVu = new JMenu("Dịch vụ");
		dichVu.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("service.png"))));
		 
		
		
		JButton timKiem = new JButton("Tìm kiếm");
		timKiem.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("find.png"))));
		timKiem.addActionListener(ls);
		timKiem.addActionListener(e -> {
			timKiem kiem = new timKiem();
			dispose();
			kiem.setVisible(true);
		});
		JButton thongke = new JButton("Thống kê");
		thongke.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("find.png"))));
		thongke.addActionListener(ls);
		thongke.addActionListener(e -> {
			thongKeView thongKeView = new thongKeView();
			thongKeView.setVisible(true);
		});
		JButton thongketheobieudo = new JButton("Thống kê theo biểu đồ tròn");
		thongketheobieudo.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("find.png"))));
		thongketheobieudo.addActionListener(ls);
		thongketheobieudo.addActionListener(e -> {
			thongketheobieudoview thongketheobieudoo = new thongketheobieudoview();
			thongketheobieudoo.setVisible(true);
		});
		JButton quanlytk = new JButton("Quản lý người dùng");
		quanlytk.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("find.png"))));
		quanlytk.addActionListener(ls);
		quanlytk.addActionListener(e -> {
			quanlykhachsanView view = new quanlykhachsanView();
			dispose();
			view.setVisible(true);
			view.hienThi();
		});
		
		JMenu exit = new JMenu("Exit");
		exit.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("close.png"))));
		JButton thoat = new JButton("Thoát");
		thoat.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("login.png"))));
		thoat.addActionListener(ls);
		JButton dangXuat = new JButton("Đăng xuất");
		dangXuat.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("login.png"))));
		dangXuat.addActionListener(ls);
		
		dichVu.add(timKiem);
		dichVu.add(thongke);
		dichVu.add(thongketheobieudo);
		dichVu.add(quanlytk);
		exit.add(thoat);
		exit.add(dangXuat);
		mnb.add(dichVu);
		mnb.add(exit);
		
		
		
		this.setJMenuBar(mnb);
		this.setLayout(new BorderLayout(20,20));
		this.add(scr,BorderLayout.CENTER);
		this.add(jPanel_n,BorderLayout.NORTH);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		 SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new HotelView();
	            }
	        });
	}
	
	public void lamTrong() {
		this.jtf_soPhong.setText("");
		this.jtf_loaiPhong.setText("");
		this.jtf_trangThai.setText("");
		this.jtf_maNguoiThue.setText("");
		this.jtf_tenNguoithue.setText("");
		this.jtf_gioiTinh.setText("");
		this.jtf_sdt.setText("");
		this.jtf_giaPhong.setText("");
		
	}
	public void luu() {
		int selectRow = tbl.getSelectedRow();
		if(selectRow==-1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để lưu");
		}
		int soPhong = Integer.valueOf(this.jtf_soPhong.getText());
		String loaiPhong = this.jtf_loaiPhong.getText();
		Float giaPhong = Float.valueOf(this.jtf_giaPhong.getText());
		String trangThai = this.jtf_trangThai.getText();
		String maNguoiThue = this.jtf_maNguoiThue.getText();
		String tenNguoiThue = this.jtf_tenNguoithue.getText();
		String gioiTinh = this.jtf_gioiTinh.getText();
		String soDienThoai = this.jtf_sdt.getText();

		HotelModel model = new HotelModel(soPhong, loaiPhong, giaPhong, trangThai, maNguoiThue, tenNguoiThue, gioiTinh, soDienThoai);
		 int selectedRow = tbl.getSelectedRow();
		    if (selectedRow != -1) {
		        
		        dm.setValueAt(soPhong, selectedRow, 0);
		        dm.setValueAt(loaiPhong, selectedRow, 1);
		        dm.setValueAt(giaPhong, selectedRow, 2);
		        dm.setValueAt(trangThai, selectedRow, 3);
		        dm.setValueAt(maNguoiThue, selectedRow, 4);
		        dm.setValueAt(tenNguoiThue, selectedRow, 5);
		        dm.setValueAt(gioiTinh, selectedRow, 6);
		        dm.setValueAt(soDienThoai, selectedRow, 7);
		        
		 
		        HotelDAO hotelDAO = new HotelDAO();
		        
		        if (hotelDAO.suaDuLieu(model)) {
		            JOptionPane.showMessageDialog(this, "Sửa dữ liệu thành công");
		        } else {
		            JOptionPane.showMessageDialog(this, "Sửa dữ liệu thất bại");
		        }
		    } else {
		        JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để sửa");
		    }
		}
	
	public void sua() {
		int selectRow = tbl.getSelectedRow();
		if(selectRow==-1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để sửa");
		}
		if(selectRow!=-1) {
			int soPhong = Integer.valueOf(tbl.getValueAt(selectRow, 0)+"");
			String loaiPhong = tbl.getValueAt(selectRow, 1)+"";
			float giaPhong = Float.valueOf(tbl.getValueAt(selectRow, 2)+"");
			String trangThai = tbl.getValueAt(selectRow, 3)+"";
			String maNguoiThue = tbl.getValueAt(selectRow, 4)+"";
			String tenNguoiThue = tbl.getValueAt(selectRow, 5)+"";
			String gioiTinh = tbl.getValueAt(selectRow, 6)+"";
			String soDienThoai = tbl.getValueAt(selectRow, 7)+"";
			this.jtf_soPhong.setText(soPhong+"");
			this.jtf_loaiPhong.setText(loaiPhong);
			this.jtf_giaPhong.setText(giaPhong+"");
			this.jtf_trangThai.setText(trangThai);
			this.jtf_maNguoiThue.setText(maNguoiThue+"");
			this.jtf_tenNguoithue.setText(tenNguoiThue+"");
			this.jtf_gioiTinh.setText(gioiTinh+"");
			this.jtf_sdt.setText(soDienThoai+"");
			
		}
		
		
	}
	public void xoa() {
		int selectRow = tbl.getSelectedRow();
		if(selectRow==-1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để xóa");
		}
		  int[] selectedRows = tbl.getSelectedRows();
		  HotelDAO hotelDAO = new HotelDAO();
		  
		  List<Integer> rowDeXoa = new ArrayList<Integer>();
          for (int i = selectedRows.length - 1; i >= 0; i--) {
              int selectedRow = tbl.convertRowIndexToModel(selectedRows[i]);
                 rowDeXoa.add(selectedRow);           
          }
          for(int row : rowDeXoa) {
              int soPhong = Integer.parseInt(tbl.getValueAt(row, 0).toString());
              String loaiPhong = tbl.getValueAt(row, 1).toString();
              float giaPhong = Float.parseFloat(tbl.getValueAt(row, 2).toString());
              String trangThai = tbl.getValueAt(row, 3).toString();
              String maNguoiThue = tbl.getValueAt(row, 4).toString();
              String tenNguoiThue = tbl.getValueAt(row, 5).toString();
              String gioiTinh = tbl.getValueAt(row, 6).toString();
              String soDienThoai = tbl.getValueAt(row, 7).toString();
              
              HotelModel model = new HotelModel(soPhong, loaiPhong, giaPhong, trangThai, maNguoiThue, tenNguoiThue, gioiTinh, soDienThoai);
              hotelDAO.xoaDuLieu(model);
              dm.removeRow(row);
	}
	}
	
	public void hienThi() {
			HotelDAO hotelDAO = new HotelDAO();
			dm.setRowCount(0);
			ArrayList<HotelModel> list = hotelDAO.sellectAll();
			for (HotelModel hotelModel : list) {
				dm.addRow(new Object[] {hotelModel.getSoPhong(),hotelModel.getLoaiPhong(),hotelModel.getGiaPhong(),hotelModel.getTrangThai(),hotelModel.getMaNguoiThue(),hotelModel.getTenNguoiThue(),hotelModel.getGioiTinh(),hotelModel.getSoDienThoai()});
				
			}
		
	}
	public void them() {
		int soPhong = Integer.valueOf(this.jtf_soPhong.getText());
		String loaiPhong = this.jtf_loaiPhong.getText();
		Float giaPhong = Float.valueOf(this.jtf_giaPhong.getText());
		String trangThai = this.jtf_trangThai.getText();
		String maNguoiThue = this.jtf_maNguoiThue.getText();
		String tenNguoiThue = this.jtf_tenNguoithue.getText();
		String gioiTinh = this.jtf_gioiTinh.getText();
		String soDienThoai = this.jtf_sdt.getText();

		HotelModel model = new HotelModel(soPhong, loaiPhong, giaPhong, trangThai, maNguoiThue, tenNguoiThue, gioiTinh, soDienThoai);
		HotelDAO dao = new HotelDAO();
		dao.themDuLieu(model);
		
	    DefaultTableModel tableModel = (DefaultTableModel) tbl.getModel();
	    tableModel.addRow(new Object[]{soPhong, loaiPhong, giaPhong, trangThai, maNguoiThue, tenNguoiThue, gioiTinh, soDienThoai});
	    tbl.setModel(tableModel);
	}
	}

