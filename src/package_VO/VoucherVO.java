package package_VO;

import package_Database.Database;

public class VoucherVO {
	private int V_seq; //이용권 PK
	private int v_period; //이용권 기간
	private String v_name; //이용권 이름
	private int v_price; //이용권 가격
	private boolean isActivate=true; //이용권 삭제 여부

	
	public boolean isActivate() {
		return isActivate;
	}


	public void setActivate(boolean isActivate) {
		this.isActivate = isActivate;
	}


	public int getV_seq() {
		return V_seq;
	}


	public void setV_seq() {
		V_seq = ++Database.v_cur_seq;
	}


	public int getV_period() {
		return v_period;
	}


	public void setV_period(int v_period) {
		this.v_period = v_period;
	}


	public String getV_name() {
		return v_name;
	}


	public void setV_name(String v_name) {
		this.v_name = v_name;
	}


	public int getV_price() {
		return v_price;
	}


	public void setV_price(int v_price) {
		this.v_price = v_price;
	}
	
	public void setV_seq(int seq) {
		V_seq = ++Database.v_cur_seq;
	}


	@Override
	public String toString() {
		return "";
	}
}