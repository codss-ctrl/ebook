package package_VO;

public class UserVO {
	
	private String id;
	private String userName;
	
	private String pw;
	private int point;
	private boolean isActivate = true;
	

	
	public String getId() {
		return id;
	}
	public String getUserName() {
		return userName;
	}
	
	public String getPw() {
		return pw;
	}
	public int getPoint() {
		return point;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	
	@Override
	public String toString() {
		return "";
	}
	public boolean isActivate() {
		return isActivate;
	}
	public void setActivate(boolean isActivate) {
		this.isActivate = isActivate;
	}
	
}

