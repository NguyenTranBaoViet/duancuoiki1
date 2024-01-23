package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GiaoDienNguoiDungView extends JFrame{

	public GiaoDienNguoiDungView() {
		this.setTitle("Giao diện người dùng");
		this.setSize(400,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		JPanel jPanel = new JPanel();
		jPanel.setBackground(Color.DARK_GRAY);
		
		jPanel.setLayout(new GridLayout(1,3,10,10));
		
		
		JButton button_goimon = new JButton("Gọi món");
		button_goimon.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("call.png"))));
		button_goimon.addActionListener(e -> {
			thucDonView thucDonView = new thucDonView();
			dispose();
			thucDonView.setVisible(true);
		});
		JButton button_Thoat = new JButton("Đăg xuất");
		button_Thoat.addActionListener(e -> {
			int option = JOptionPane.showOptionDialog(
	                null,
	                "Bạn có chắc muốn Đăng xuất?",
	                "Xác nhận đăng xuất",
	                JOptionPane.YES_NO_OPTION,
	                JOptionPane.QUESTION_MESSAGE,
	                null,
	                new Object[]{"Đồng ý", "Không"},
	                "Không"
	        );
			if (option == JOptionPane.YES_OPTION) {
	            System.out.println("Đã thoát thành công!");
	            this.dispose();
	            DangNhapView dangNhapView = new DangNhapView();
	            dangNhapView.setVisible(true);
	        } else {
	            System.out.println("Tiếp tục hoạt động!");
	        }
		});
		
		jPanel.add(button_goimon);
		jPanel.add(button_Thoat);
		
		this.setLayout(new BorderLayout());
		this.add(jPanel,BorderLayout.CENTER);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new GiaoDienNguoiDungView();
	}
}
