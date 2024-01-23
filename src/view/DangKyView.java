package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.ControllerDangKy;

public class DangKyView extends JFrame{

	public JTextField usernameField;
	public JPasswordField passwordField;
	public JTextField emailField;
	public ControllerDangKy controllerDangKy;
	public JButton dangNhap;
	public JTextField field_ten;
	public JTextField field_ngaysinh;
	public JTextField field_quequan;
	public JTextField field_sdt;
	public JTextField field_gioitinh;
	public DangKyView() {
		this.setTitle("Đăng ký");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		Color color2 = new Color(210,105,30);
		Color color_jlb = new Color(255,222,173);
		Color color_letter = new Color(105,105,105);
		
		 JPanel panel = new JPanel();
	        panel.setLayout(new BorderLayout());

	        JPanel formPanel = new JPanel();
	        formPanel.setLayout(new GridLayout(9, 2));

	        JLabel usernameLabel = new JLabel("Tên đăng nhập:");
	        usernameLabel.setBackground(color2);
	        usernameLabel.setOpaque(true);
	        usernameField = new JTextField();
	        usernameField.setBackground(color_jlb);
	        JLabel passwordLabel = new JLabel("Mật khẩu:");
	        passwordLabel.setBackground(color2);
	        passwordLabel.setOpaque(true);
	        passwordField = new JPasswordField();
	        passwordField.setBackground(color_jlb);
	        JLabel emailLabel = new JLabel("Email:");
	        emailLabel.setBackground(color2);
	        emailLabel.setOpaque(true);
	        emailField = new JTextField();
	        emailField.setBackground(color_jlb);
	        JLabel jLabel_ten = new JLabel("Tên");
	        jLabel_ten.setBackground(color2);
	        jLabel_ten.setOpaque(true);
			 field_ten = new JTextField();
			 field_ten.setBackground(color_jlb);
			JLabel jLabel_ngaysinh = new JLabel("Ngày sinh");
			jLabel_ngaysinh.setBackground(color2);
			jLabel_ngaysinh.setOpaque(true);
			 field_ngaysinh = new JTextField();
			 field_ngaysinh.setBackground(color_jlb);
			JLabel jLabel_quequan = new JLabel("Quê quán");
			jLabel_quequan.setBackground(color2);
			jLabel_quequan.setOpaque(true);
			 field_quequan = new JTextField();
			 field_quequan.setBackground(color_jlb);
			JLabel jLabel_sdt = new JLabel("Số điện thoại");
			jLabel_sdt.setBackground(color2);
			jLabel_sdt.setOpaque(true);
			 field_sdt = new JTextField();
			 field_sdt.setBackground(color_jlb);
			JLabel jLabel_gioitinh = new JLabel("Giới tính");
			jLabel_gioitinh.setBackground(color2);
			jLabel_gioitinh.setOpaque(true);
			 field_gioitinh = new JTextField();
			 field_gioitinh.setBackground(color_jlb);
	        
	        ControllerDangKy dangKy = new ControllerDangKy(this);
	        JButton registerButton = new JButton("Đăng ký");
	        registerButton.setBackground(Color.YELLOW);
	        registerButton.addActionListener(dangKy);
	        
	        dangNhap = new JButton("Đến Đăng Nhập");
	        dangNhap.setBackground(Color.YELLOW);
	        dangNhap.setVisible(false);
	        dangNhap.addActionListener(e -> {
				DangNhapView dangNhapView = new DangNhapView();
				dispose();
				dangNhapView.setVisible(true);
			});
	        
	        JButton quaylai = new JButton("Quay lại");
	        quaylai.setBackground(Color.YELLOW);
	        quaylai.addActionListener(e -> {
				DangNhapView dangNhapView = new DangNhapView();
				dispose();
				dangNhapView.setVisible(true);
			});
	        
	        
	        formPanel.add(usernameLabel);
	        formPanel.add(usernameField);
	        formPanel.add(passwordLabel);
	        formPanel.add(passwordField);
	        formPanel.add(emailLabel);
	        formPanel.add(emailField);
	        formPanel.add(jLabel_ten);
	        formPanel.add(field_ten);
	        formPanel.add(jLabel_ngaysinh);
	        formPanel.add(field_ngaysinh);
	        formPanel.add(jLabel_quequan);
	        formPanel.add(field_quequan);
	        formPanel.add(jLabel_sdt);
	        formPanel.add(field_sdt);
	        formPanel.add(jLabel_gioitinh);
	        formPanel.add(field_gioitinh);
	        formPanel.add(registerButton);
	        formPanel.add(quaylai);
	        
	      JLabel jLabel_image = new JLabel();
	      jLabel_image.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("dangnhap2.jpg"))));

	        
	        panel.add(formPanel,BorderLayout.NORTH);
	        this.setLayout(new BorderLayout());
	        this.add(dangNhap,BorderLayout.CENTER);
	        this.add(panel,BorderLayout.NORTH);
	        this.add(jLabel_image,BorderLayout.SOUTH);
	       this.setVisible(true);
	       
	}
	public static void main(String[] args) {
		new DangKyView();
	}
}
