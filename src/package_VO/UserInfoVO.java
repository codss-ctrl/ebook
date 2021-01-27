package package_VO;

public class UserInfoVO {
	private int seq;
	private String buyDate;
	private boolean isActivate = true;
	private String user_id;
	private int v_seq;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}
	public boolean isActivate() {
		return isActivate;
	}
	public void setActivate(boolean isActivate) {
		this.isActivate = isActivate;
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
