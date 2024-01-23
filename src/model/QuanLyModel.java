package model;

public class QuanLyModel {
	private int ma;
	private String username;
	private String password;
	private String email;
	private String Ten;
	private String NgaySinh;
	private String QueQuan;
	private String GioiTinh;
	private String Sdt;
	
	public QuanLyModel() {
		
	}
	
	public QuanLyModel(int ma, String username, String password, String email,String ten, String ngaySinh, String queQuan, String gioiTinh,String sdt) {
		this.ma = ma;
		this.username = username;
		this.password = password;
		this.email = email;
		this.Ten = ten;
		this.NgaySinh = ngaySinh;
		this.QueQuan = queQuan;
		this.GioiTinh = gioiTinh;
		this.Sdt = sdt;
	}
	
	public int getMa() {
		return ma;
	}

	public void setMa(int ma) {
		this.ma = ma;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getTen() {
		return Ten;
	}
	public void setTen(String ten) {
		Ten = ten;
	}
	public String getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public String getQueQuan() {
		return QueQuan;
	}
	public void setQueQuan(String queQuan) {
		QueQuan = queQuan;
	}
	public String getSdt() {
		return Sdt;
	}
	public void setSdt(String sdt) {
		Sdt = sdt;
	}
	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
	

}
