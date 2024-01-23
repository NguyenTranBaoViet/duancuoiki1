package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import controller.ControllerDanhGia;
import database.JDBCUtil;
import model.QuanLyModel;

public class DanhGiaKhachSan extends JFrame{
	 private JLabel label;
	    public JComboBox<Integer> ratingComboBox;
	    private JButton submitButton;
	    

	    public DanhGiaKhachSan() {
	        setTitle("Đánh giá khách sạn");
	        setSize(getMaximumSize());
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(new BorderLayout());
	       
            JPanel jPanel_button = new JPanel();
            jPanel_button.setLayout(new GridLayout(1,2));
	        
	        label = new JLabel("Vui lòng đánh giá khách sạn từ 1 đến 5 sao:");
	        ratingComboBox = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
	        submitButton = new JButton("Gửi");
	        submitButton.addActionListener(e -> {
	            int rating = (int) ratingComboBox.getSelectedItem();
	            if (rating < 1 || rating > 5) {
	                JOptionPane.showMessageDialog(this, "Đánh giá không hợp lệ. Vui lòng nhập từ 1 đến 5 sao.");
	            } else {
	                JOptionPane.showMessageDialog(this, "Cảm ơn bạn đã đánh giá khách sạn!\nĐánh giá của bạn: " + rating + " sao.");
	            }
	        });
	        ControllerDanhGia danhGia = new ControllerDanhGia(this);
	        JButton quaylai = new JButton("Quay lại");
	        quaylai.addActionListener(danhGia);
	        quaylai.addActionListener(e -> {
				GiaoDienNguoiDungView dienNguoiDungView = new GiaoDienNguoiDungView();
				dispose();
				dienNguoiDungView.setVisible(true);
			});
	        jPanel_button.add(submitButton);
	        jPanel_button.add(quaylai);

	        add(label,BorderLayout.NORTH);
	        add(ratingComboBox,BorderLayout.CENTER);
	        add(jPanel_button,BorderLayout.SOUTH);

	       pack();
	        setLocationRelativeTo(null);
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	            DanhGiaKhachSan danhGiaKhachSan = new DanhGiaKhachSan();
	            danhGiaKhachSan.setVisible(true);
	        });
	    }
	    public void HotelDAODanhGia(QuanLyModel dienThongTinModel) {
			try {
				String sql = "INSERT INTO users (DanhGia)\r\n"
						+ " VALUES(\"" +ratingComboBox.getSelectedItem()+ "\")";
				Connection connection = JDBCUtil.getConnection();
				Statement st = connection.createStatement();
				st.executeUpdate(sql);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	    public int ma(int ma) {
	    	return ma;
	    	
	    }
}
