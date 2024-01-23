package model;

public class HotelModel {
	private int soPhong;
	private String loaiPhong;
	private float giaPhong;
	private String trangThai;
	private String maNguoiThue;
	private String tenNguoiThue;
	private String gioiTinh;
	private String soDienThoai;
	
	public HotelModel() {
		
	}
	public HotelModel(int soPhong, String loaiPhong, float giaPhong, String trangThai, String maNguoiThue,
			String tenNguoiThue, String gioiTinh, String soDienThoai) {
		this.soPhong = soPhong;
		this.loaiPhong = loaiPhong;
		this.giaPhong = giaPhong;
		this.trangThai = trangThai;
		this.maNguoiThue = maNguoiThue;
		this.tenNguoiThue = tenNguoiThue;
		this.gioiTinh = gioiTinh;
		this.soDienThoai = soDienThoai;
	}
	public int getSoPhong() {
		return soPhong;
	}
	public void setSoPhong(int soPhong) {
		this.soPhong = soPhong;
	}
	public String getLoaiPhong() {
		return loaiPhong;
	}
	public void setLoaiPhong(String loaiPhong) {
		this.loaiPhong = loaiPhong;
	}
	public float getGiaPhong() {
		return giaPhong;
	}
	public void setGiaPhong(float giaPhong) {
		this.giaPhong = giaPhong;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public String getMaNguoiThue() {
		return maNguoiThue;
	}
	public void setMaNguoiThue(String maNguoiThue) {
		this.maNguoiThue = maNguoiThue;
	}
	public String getTenNguoiThue() {
		return tenNguoiThue;
	}
	public void setTenNguoiThue(String tenNguoiThue) {
		this.tenNguoiThue = tenNguoiThue;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	
	}



