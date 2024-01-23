package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import database.JDBCUtil;
import view.thongKeView;

public class ControllerThongKe implements ActionListener {
    private thongKeView thongKeView;

    public ControllerThongKe(thongKeView thongKeView) {
        this.thongKeView = thongKeView;
    }
   

    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();
        if (button.equals("Thống kê")) {
            try {
                Connection connection = JDBCUtil.getConnection();
                Statement statement = connection.createStatement();
                
                
                ResultSet rsTongPhong = statement.executeQuery("SELECT COUNT(*) as tongPhong FROM hotel");
                rsTongPhong.next();
                int tongPhong = rsTongPhong.getInt("tongPhong");
                rsTongPhong.close();
                
                
                ResultSet rsPhongCon = statement.executeQuery("SELECT COUNT(*) as phongCon FROM hotel WHERE trangThai = 'Còn'");
                rsPhongCon.next();
                int phongCon = rsPhongCon.getInt("phongCon");
                rsPhongCon.close();
                
              
                int phongHet = tongPhong - phongCon;
                
                
                ResultSet rsPhongVIP = statement.executeQuery("SELECT COUNT(*) as phongVIP FROM hotel WHERE loaiPhong = 'VIP'");
                rsPhongVIP.next();
                int phongVIP = rsPhongVIP.getInt("phongVIP");
                rsPhongVIP.close();
                
             
                int phongThuong = tongPhong - phongVIP;
                
             
                ResultSet rsGioiTinh = statement.executeQuery("SELECT gioiTinh, COUNT(*) as soLuong FROM hotel GROUP BY gioiTinh");
                StringBuilder gioiTinhResult = new StringBuilder();
                while (rsGioiTinh.next()) {
                    String gioiTinh = rsGioiTinh.getString("gioiTinh");
                    int soLuong = rsGioiTinh.getInt("soLuong");
                    gioiTinhResult.append(gioiTinh).append(": ").append(soLuong).append("\n");
                }
                rsGioiTinh.close();
                
                String result = "Tổng số phòng: " + tongPhong + "\n";
                result += "Số phòng còn: " + phongCon + "\n";
                result += "Số phòng hết: " + phongHet + "\n";
                result += "Số phòng VIP: " + phongVIP + "\n";
                result += "Số phòng thường: " + phongThuong + "\n";
                result += "Số lượng theo giới tính:\n" + gioiTinhResult.toString();

                JOptionPane.showMessageDialog(thongKeView, result, "Kết quả thống kê", JOptionPane.INFORMATION_MESSAGE);
             
                statement.close();
                connection.close();
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(thongKeView, "Lỗi kết nối CSDL: " + e2.getMessage(), "Lỗi",
                        JOptionPane.ERROR_MESSAGE);

            }
        }
        if(button.equals("Tắt")) {
        	thongKeView.dispose();
        }
    }
}