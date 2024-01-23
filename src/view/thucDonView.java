package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;

import controller.ThucDonController;
import model.thucDonModel;

public class thucDonView extends JFrame{
	public thucDonModel thucDonModel;
	public JRadioButton jRadioButton_Com;
	public JRadioButton jRadioButton_Pho;
	public JRadioButton jRadioButton_BanhMi;
	public ButtonGroup buttonGroup_MonChinh;
	public JCheckBox jCheckBox_TraSua;
	public JCheckBox jCheckBox_Cocacola;
	public JCheckBox jCheckBox_Keo;
	public JCheckBox jCheckBox_Pingchiling;
	public JLabel jLabel_ThongTin;
	public ArrayList<JCheckBox> list_buttonGroup_MonPhu;
	public JLabel jLabel_ThongTin1;
	public JLabel jLabel_ThongTin2;
	

	public thucDonView() {
		this.thucDonModel = new thucDonModel();
		init();
	}
	public void init() {
		this.setTitle("Thực đơn");
		this.setSize(500,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		
		JPanel jPanel_all = new JPanel();
		jPanel_all.setLayout(new BorderLayout());
		
		Font font = new Font("Arial", Font.BOLD, 40);
		
		Color color_jlb = new Color(255,222,173);
		JLabel label_header = new JLabel("THỰC ĐƠN KHÁCH SẠN");
		label_header.setFont(font);
		label_header.setBackground(color_jlb);
		label_header.setOpaque(true);
		
		JPanel jPanel_TieuDe = new JPanel();
		jPanel_TieuDe.add(label_header);
		
				
		JPanel jPanel_MonChinh = new JPanel();
		
		jPanel_MonChinh.setLayout(new GridLayout(3,2));
		 jRadioButton_Com = new JRadioButton("Cơm");
		jRadioButton_Com.setFont(new Font("Arial", Font.ITALIC, 30));
		 jRadioButton_Pho = new JRadioButton("Phở");
		jRadioButton_Pho.setFont(new Font("Arial", Font.ITALIC, 30));
		 jRadioButton_BanhMi = new JRadioButton("Bánh mì");
		jRadioButton_BanhMi.setFont(new Font("Arial", Font.ITALIC, 30));
		
		 buttonGroup_MonChinh = new ButtonGroup();
		buttonGroup_MonChinh.add(jRadioButton_Com);
		JLabel com = new JLabel();
		buttonGroup_MonChinh.add(jRadioButton_Pho);
		JLabel pho = new JLabel();
		buttonGroup_MonChinh.add(jRadioButton_BanhMi);
		JLabel banhmi = new JLabel();
		
		com.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("comn.jpg"))));
		pho.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("pho.jpg"))));
		banhmi.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("banhmi.jpg"))));

		
		jPanel_MonChinh.add(jRadioButton_Com);
		jPanel_MonChinh.add(com);
		jPanel_MonChinh.add(jRadioButton_Pho);
		jPanel_MonChinh.add(pho);
		jPanel_MonChinh.add(jRadioButton_BanhMi);
		jPanel_MonChinh.add(banhmi);
		
		
		JPanel jPanel_MonPhu = new JPanel();
		jPanel_MonPhu.setLayout(new GridLayout(2,4));
		
		Font font1 = new Font("Arial", Font.ITALIC, 20);
		 jCheckBox_TraSua = new JCheckBox("Trà sữa");
		jCheckBox_TraSua.setFont(font1);
		JLabel trasua = new JLabel();
		 jCheckBox_Cocacola = new JCheckBox("Cocacola");
		jCheckBox_Cocacola.setFont(font1);
		JLabel cocacola = new JLabel();
		 jCheckBox_Keo = new JCheckBox("Kẹo");
		jCheckBox_Keo.setFont(font1);
		JLabel keo = new JLabel();
		 jCheckBox_Pingchiling = new JCheckBox("Ping Chi Ling");
		jCheckBox_Pingchiling.setFont(font1);
		JLabel pingchiling = new JLabel();
		
		trasua.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("trasua1.jpg"))));
		cocacola.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("cocacola1.jpg"))));
		keo.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("keo1.jpg"))));
		pingchiling.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("kem1.jpg"))));
		
		list_buttonGroup_MonPhu = new ArrayList<JCheckBox>();
		list_buttonGroup_MonPhu.add(jCheckBox_TraSua);
		list_buttonGroup_MonPhu.add(jCheckBox_Cocacola);
		list_buttonGroup_MonPhu.add(jCheckBox_Keo);
		list_buttonGroup_MonPhu.add(jCheckBox_Pingchiling);
		
		jPanel_MonPhu.add(jCheckBox_TraSua);
		jPanel_MonPhu.add(trasua);
		jPanel_MonPhu.add(jCheckBox_Cocacola);
		jPanel_MonPhu.add(cocacola);
		jPanel_MonPhu.add(jCheckBox_Keo);
		jPanel_MonPhu.add(keo);
		jPanel_MonPhu.add(jCheckBox_Pingchiling);
		jPanel_MonPhu.add(pingchiling);
		
		
		JPanel jPanel_LuaChon = new JPanel();
		jPanel_LuaChon.setLayout(new GridLayout(2,1));
		jPanel_LuaChon.add(jPanel_MonChinh);
		jPanel_LuaChon.add(jPanel_MonPhu);
		
		JPanel jPanel_ThanhToan = new JPanel();
		jPanel_ThanhToan.setLayout(new GridLayout(4,1));
		
		 jLabel_ThongTin = new JLabel();
		jLabel_ThongTin.setFont(new Font("Arial", Font.BOLD, 20));
		 jLabel_ThongTin1 = new JLabel();
		jLabel_ThongTin1.setFont(new Font("Arial", Font.BOLD, 20));
		 jLabel_ThongTin2 = new JLabel();
		jLabel_ThongTin2.setFont(new Font("Arial", Font.BOLD, 20));
		
		JButton button_ThanhToan = new JButton("Thanh toán");
		button_ThanhToan.setFont(font);
		ThucDonController td = new ThucDonController(this);
		button_ThanhToan.addActionListener(td);
		jPanel_ThanhToan.add(jLabel_ThongTin);
		jPanel_ThanhToan.add(jLabel_ThongTin1);
		jPanel_ThanhToan.add(jLabel_ThongTin2);
		jPanel_ThanhToan.add(button_ThanhToan);
		
		JPanel panel_quaylaiJPanel = new JPanel();
		JButton button_quaylai = new JButton("Quay lại");
		button_quaylai.addActionListener(td);
		button_quaylai.addActionListener(e -> {
			GiaoDienNguoiDungView dienNguoiDungView = new GiaoDienNguoiDungView();
			dispose();
			dienNguoiDungView.setVisible(true);
		});
		
		panel_quaylaiJPanel.add(button_quaylai);
		
		jPanel_all.add(jPanel_LuaChon,BorderLayout.CENTER);
		jPanel_all.add(jPanel_TieuDe,BorderLayout.NORTH);
		
		this.setLayout(new BorderLayout());
		this.add(jPanel_all,BorderLayout.NORTH);
		this.add(jPanel_ThanhToan,BorderLayout.CENTER);
		this.add(panel_quaylaiJPanel,BorderLayout.SOUTH);
		this.setVisible(true);
	}
	public void hienThiKetQua() {
		String kq ="Món chính: " + this.thucDonModel.getLuaChon_MonChinh() + ".";
		String kq1 = "Món phụ: " + this.thucDonModel.getLuaChon_MonPhu() + ".";
		String kq2 = "Tổng tiền: " + this.thucDonModel.getTongTien();
		
		
		this.jLabel_ThongTin.setText(kq);
		this.jLabel_ThongTin1.setText(kq1);
		this.jLabel_ThongTin2.setText(kq2);
		
	}
	public static void main(String[] args) {
		new thucDonView();
	}
}
