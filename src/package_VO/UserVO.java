package package_VO;

public class UserVO {
	
	private String user_id; //유저 아이디 PK
	private String user_name; //유저 이름
	private String user_pw; //유저 비밀번호
	private int user_point; //유저 포인트
	private boolean user_isActivate=true; //유저 활성화 여부
		
		
	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getUser_pw() {
		return user_pw;
	}


	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}


	public int getUser_point() {
		return user_point;
	}


	public void setUser_point(int user_point) {
		this.user_point = user_point;
	}


	public boolean isUser_isActivate() {
		return user_isActivate;
	}


	public void setUser_isActivate(boolean user_isActivate) {
		this.user_isActivate = user_isActivate;
	}


	@Override
	public String toString() {
		return "";
	}
	
}
