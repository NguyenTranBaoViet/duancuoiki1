package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

import DAO.HotelDAO;
import controller.ControllerTimKiem;
import model.HotelModel;

public class timKiem extends JFrame {

	public JTextArea area;
	public JTextField jtf_Nhap;
	private DefaultTableModel dm;
	private JTable tbl;
	
	public timKiem() {
		this.setTitle("Tìm kiếm");
		this.setSize(700,530);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		Color color2 = new Color(210,105,30);
		Color color_jlb = new Color(255,222,173);
		Color color_letter = new Color(105,105,105);
		
		ControllerTimKiem tk = new ControllerTimKiem(this);
		JPanel panel_all = new JPanel();
		panel_all.setLayout(new BorderLayout());
		
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(2,3));
		
		jtf_Nhap = new JTextField();
		
		
		JRadioButton button_timKiem = new JRadioButton("Tìm kiếm theo số");
		button_timKiem.setBackground(color_jlb);
		JRadioButton button_tkLoai = new JRadioButton("Tìm kiếm theo loại");
		button_tkLoai.setBackground(color_jlb);
		
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(button_timKiem);
		buttonGroup.add(button_tkLoai);
		
		JButton button_tim = new JButton("Tìm");
		button_tim.setBackground(Color.yellow);
		button_tim.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String button = e.getActionCommand();
				if(button.equals("Tìm")) {
					if(button_timKiem.isSelected()) {
						timKiemTheoSo();
					}
					else if(button_tkLoai.isSelected()) {
						timKiemTheoLoai();
					}
				}
				
			}
		});
		
		JButton button_quayLai = new JButton("Quay lại");
		button_quayLai.setBackground(Color.YELLOW);
		button_quayLai.addActionListener(tk);
		button_quayLai.addActionListener(e -> {
			HotelView hotelView = new HotelView();
			dispose();
			hotelView.setVisible(true);
			hotelView.hienThi();
		});
		
		jPanel.add(button_timKiem);
		jPanel.add(jtf_Nhap);
		jPanel.add(button_tkLoai);
		jPanel.add(button_tim);
	
	
		
		
		panel_all.add(jPanel,BorderLayout.CENTER);
		
		JPanel jpn = new JPanel();
		jpn.setLayout(new BorderLayout());
		
		
		
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
		scr.setBackground(Color.ORANGE);
		tbl.setBackground(Color.ORANGE);

		jpn.add(scr,BorderLayout.CENTER);
		jpn.add(button_quayLai,BorderLayout.SOUTH);
		
		this.setLayout(new BorderLayout());
		this.add(jpn,BorderLayout.SOUTH);
		this.add(panel_all,BorderLayout.CENTER);
		this.setVisible(true);
		
	}
	
public static void main(String[] args) {
	new timKiem();
}
public void timKiemTheoSo() {
   int soPhong = Integer.parseInt(jtf_Nhap.getText());
   HotelDAO dao = new HotelDAO();
   ArrayList<HotelModel> list = dao.timKiemDuLieu(soPhong);
   dm.setRowCount(0);
for (HotelModel hotelModel : list) {
	dm.addRow(new Object[] {hotelModel.getSoPhong(),hotelModel.getLoaiPhong(),hotelModel.getGiaPhong(),hotelModel.getTrangThai(),hotelModel.getMaNguoiThue(),hotelModel.getTenNguoiThue(),hotelModel.getGioiTinh(),hotelModel.getSoDienThoai()});
}
}
public void timKiemTheoLoai() {
	 String loai = jtf_Nhap.getText();
	   HotelDAO dao = new HotelDAO();
	   ArrayList<HotelModel> list = dao.timKiemDuLieuTheoLoai(loai);
	   dm.setRowCount(0);
	for (HotelModel hotelModel : list) {
		dm.addRow(new Object[] {hotelModel.getSoPhong(),hotelModel.getLoaiPhong(),hotelModel.getGiaPhong(),hotelModel.getTrangThai(),hotelModel.getMaNguoiThue(),hotelModel.getTenNguoiThue(),hotelModel.getGioiTinh(),hotelModel.getSoDienThoai()});
	}
}
}

