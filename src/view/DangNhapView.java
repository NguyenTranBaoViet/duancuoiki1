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

public class DangNhapView extends JFrame{

	public JTextField usernameField;
	public JPasswordField passwordField;

	public DangNhapView() {
		this.setTitle("Đăng nhập");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		Color color2 = new Color(210,105,30);
		Color color_jlb = new Color(255,222,173);
		Color color_letter = new Color(105,105,105);
		
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new BorderLayout());
		jPanel.setBackground(color_jlb);
		
		JPanel panel_all = new JPanel();
		panel_all.setLayout(new GridLayout(4,2));
		panel_all.setBackground(color_jlb);
		
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
        
		
		ControllerDangKy dangnhap = new ControllerDangKy(this);
		JButton loginButton = new JButton("Đăng nhập");
		loginButton.setBackground(Color.YELLOW);
        loginButton.addActionListener(dangnhap);
        
        JButton quaylai = new JButton("Quay lại");
        quaylai.setBackground(Color.YELLOW);
        quaylai.addActionListener(e -> {
			chonView chonView = new chonView();
			dispose();
			chonView.setVisible(true);
		});
        panel_all.add(usernameLabel);
        panel_all.add(usernameField);
        panel_all.add(passwordLabel);
        panel_all.add(passwordField);
        panel_all.add(loginButton);
        panel_all.add(quaylai);
        
        jPanel.add(panel_all,BorderLayout.NORTH);
        JLabel jLabel_dangky = new JLabel("NẾU BẠN CHƯA CÓ TÀI KHOẢN HÃY TẠO TÀI KHOẢN");
        JButton button_dangky = new JButton("Tạo tài khoản");
        button_dangky.setBackground(Color.YELLOW);
        button_dangky.addActionListener(e -> {
			DangKyView dangKyView = new DangKyView();
			dispose();
			dangKyView.setVisible(true);
		});
        
        
        jPanel.add(jLabel_dangky,BorderLayout.CENTER);
        jPanel.add(button_dangky,BorderLayout.SOUTH);
        
        JLabel jLabel_image = new JLabel();
        jLabel_image.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("dangnhap2.jpg"))));

        
        this.setLayout(new BorderLayout());
        this.add(jPanel,BorderLayout.NORTH);
        this.add(jLabel_image,BorderLayout.CENTER);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new DangNhapView();
	}

}
