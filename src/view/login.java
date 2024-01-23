package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.ControllerLogin;

public class login extends JFrame {
	
	private JTextField textField_tenDangNhap;
	private JPasswordField jPasswordField_mk;
	public login() {
		this.setTitle("Hệ thống đăng nhập quản lí khách sạn");
		this.setSize(700,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		Color color2 = new Color(210,105,30);
		
		ControllerLogin login = new ControllerLogin(this);
		JPanel jPanel_center = new JPanel();
		jPanel_center.setBackground(Color.LIGHT_GRAY);
		jPanel_center.setLayout(new GridLayout(5,2,10,10));
		
		JLabel jLabel_tenDangNhap = new JLabel("Tên tài khoản");
		jLabel_tenDangNhap.setBackground(color2);
		jLabel_tenDangNhap.setOpaque(true);
		jLabel_tenDangNhap.setForeground(Color.BLACK);
		jLabel_tenDangNhap.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("username.png"))));
		textField_tenDangNhap = new JTextField();
		textField_tenDangNhap.setBackground(Color.GRAY);
		textField_tenDangNhap.setOpaque(true);
		textField_tenDangNhap.setForeground(Color.BLACK);
		
		JLabel jLabel_mk = new JLabel("Mật khẩu");
		jLabel_mk.setBackground(color2);
		jLabel_mk.setOpaque(true);
		jLabel_mk.setForeground(Color.BLACK);
		jLabel_mk.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("pass.png"))));
		jPasswordField_mk = new JPasswordField();
		jPasswordField_mk.setBackground(Color.GRAY);
		jPasswordField_mk.setOpaque(true);
		jPasswordField_mk.setForeground(Color.BLACK);
		
		JButton button_dangNhap = new JButton("Đăng nhập");
		button_dangNhap.setBackground(Color.YELLOW);
		button_dangNhap.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("login.png"))));
		
		
		 JButton quaylai = new JButton("Quay lại");
		 quaylai.setBackground(Color.orange);
	        quaylai.addActionListener(e -> {
				chonView chonView = new chonView();
				dispose();
				chonView.setVisible(true);
			});
	        
		button_dangNhap.addActionListener(login);
		jPanel_center.add(jLabel_tenDangNhap);
		jPanel_center.add(textField_tenDangNhap);
		jPanel_center.add(jLabel_mk);
		jPanel_center.add(jPasswordField_mk);
		jPanel_center.add(button_dangNhap);

		JLabel jLabel_image = new JLabel();
		jLabel_image.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("khachsan2.jpg"))));
		
		this.setLayout(new BorderLayout());
		this.add(quaylai,BorderLayout.SOUTH);
		this.add(jPanel_center,BorderLayout.CENTER);
		this.add(jLabel_image,BorderLayout.EAST);
		this.setVisible(true);
	}
	public void heThongLogin() {
		String tk = textField_tenDangNhap.getText();
		String password = new String(jPasswordField_mk.getPassword());
		
		if(tk.equals("")) {
			JOptionPane.showMessageDialog(this, "Tên tài khoản không được để trống");
			return;
		}
		if(password.equals("")) {
			JOptionPane.showMessageDialog(this, "Mật khẩu không được để trống");
			return;
		}
		if(tk.equals("viet123") && password.equals("viet123")) {
			JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
			HotelView hotelView = new HotelView();
			dispose();
			hotelView.setVisible(true);
			hotelView.hienThi();
		
		}
		else{
			JOptionPane.showMessageDialog(this, "Tài khoản không tồn tại");
			this.setVisible(true);
		}
		
		
		
	}
public static void main(String[] args) {
	new login();
}
}
