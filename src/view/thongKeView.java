package view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import controller.ControllerThongKe;

public class thongKeView extends JFrame{
	
	public JLabel label;
	public JTextArea textarea;
	public JButton button_thongke;

	public thongKeView() {
		this.setTitle("Thống kê");
		this.setSize(300,100);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		
		ControllerThongKe tke = new ControllerThongKe(this);
		button_thongke = new JButton("Thống kê");
		button_thongke.setBackground(Color.yellow);
		button_thongke.addActionListener(tke);
		
		JButton button_tat = new JButton("Tắt");
		button_tat.setBackground(Color.yellow);
		button_tat.addActionListener(tke);
		
		this.add(button_thongke);
		this.add(button_tat);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new thongKeView();
	}

}
