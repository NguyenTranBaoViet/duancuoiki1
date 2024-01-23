package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class chonView extends JFrame{
	
	public chonView() {
		this.setTitle("CHỌN");
		this.setSize(500,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		Font font = new Font("Arial", Font.BOLD, 30);
		Color color2 = new Color(210,105,30);
		Color color_jlb = new Color(255,222,173);
		Color color_letter = new Color(105,105,105);	
		
		JLabel jLabel_TieuDe = new JLabel("Bạn là ai");
		jLabel_TieuDe.setBackground(color_jlb);
		jLabel_TieuDe.setOpaque(true);
		jLabel_TieuDe.setFont(font);
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(2,1,20,20));
		
		Font font2 = new Font("Arial", Font.ITALIC, 20);
		JButton button_users = new JButton("Người dùng");
		button_users.setBackground(Color.YELLOW);
		button_users.setFont(font2);
		button_users.addActionListener(e -> {
			DangNhapView dangNhapView = new DangNhapView();
			dispose();
			dangNhapView.setVisible(true);
		});
		
		JButton button_manage = new JButton("Quản lý");
		button_manage.setBackground(Color.YELLOW);
		button_manage.setFont(font2);
		button_manage.addActionListener(e -> {
			login login = new login();
			dispose();
			login.setVisible(true);
		});

		jPanel.add(button_users);
		jPanel.add(button_manage);
		jPanel.setBackground(color_jlb);
		this.setLayout(new BorderLayout());
		this.add(jLabel_TieuDe,BorderLayout.NORTH);
		this.add(jPanel,BorderLayout.CENTER);
		this.setVisible(true);		
	}
	public static void main(String[] args) {
		new chonView();
	}
}
