package package_VO;

public class UserInfoVO {
	
	private int info_seq; //유저 이용권 내역 PK
	private String buy_date; //유저 이용권 구매일
	private boolean info_isActivate = true; // 유저 이용권 만료 여부
	private String user_id; // 유저 아이디 FK
	private int v_seq; // 이용권 FK
	
	
	public int getInfo_seq() {
		return info_seq;
	}
	public void setInfo_seq(int info_seq) {
		this.info_seq = info_seq;
	}
	public String getBuy_date() {
		return buy_date;
	}
	public void setBuy_date(String buy_date) {
		this.buy_date = buy_date;
	}
	public boolean isInfo_isActivate() {
		return info_isActivate;
	}
	public void setInfo_isActivate(boolean info_isActivate) {
		this.info_isActivate = info_isActivate;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getV_seq() {
		return v_seq;
	}
	public void setV_seq(int v_seq) {
		this.v_seq = v_seq;
	}
	
	
	
}
