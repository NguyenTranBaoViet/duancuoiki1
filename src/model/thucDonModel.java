package model;

import java.util.StringTokenizer;

public class thucDonModel {
	private String luaChon_MonChinh;
	private String luaChon_MonPhu;
	private double tongTien;
	public thucDonModel() {
		this.luaChon_MonChinh = "";
		this.luaChon_MonPhu = "";
		this.tongTien = 0;
	}
	public String getLuaChon_MonChinh() {
		return luaChon_MonChinh;
	}
	public void setLuaChon_MonChinh(String luaChon_MonChinh) {
		this.luaChon_MonChinh = luaChon_MonChinh;
	}
	public String getLuaChon_MonPhu() {
		return luaChon_MonPhu;
	}
	public void setLuaChon_MonPhu(String luaChon_MonPhu) {
		this.luaChon_MonPhu = luaChon_MonPhu;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	public void tinhTongTien() {
		double tongTien = 0;
		if(this.luaChon_MonChinh.equals("Cơm")) {
			tongTien+= 20000;
		}else if(this.luaChon_MonChinh.equals("Phở")) {
			tongTien+= 50000;
		}else if(this.luaChon_MonChinh.equals("Bánh mì")) {
			tongTien+= 15000;
		}
		StringTokenizer stk = new StringTokenizer(this.luaChon_MonPhu + ";");
		while(stk.hasMoreElements()) {
			String monPhu = stk.nextToken();
			monPhu = monPhu.trim();
			if(monPhu.equals("Trà sữa")) {
				tongTien+= 20000;
			}else if(monPhu.equals("Cocacola")) {
				tongTien+= 10000;
			}else if(monPhu.equals("Kẹo")) {
				tongTien+= 5000;
			}else if(monPhu.equals("Ping Chi Ling")) {
				tongTien+= 10000;
			}
		}
		this.tongTien = tongTien;
	}


}
