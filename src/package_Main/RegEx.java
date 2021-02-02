package package_Main;

import java.util.regex.Pattern;


public class RegEx {
	
	//4 ~ 12자리 영문 소문자, 숫자와 특수기호 _ , - 만 사용 가능합니다.
	public static boolean checkUser_id(String id) {
		String patternUId = "[a-z0-9_,-]{4,12}";
		return Pattern.matches(patternUId, id);
	}
	
	//8 ~ 15자리 영문 대 소문자, 숫자, 특수문자만 사용 가능합니다.
	public static boolean checkUser_pw(String pw) {
		String patternUPw = "(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@!%*#?&])[A-Za-z0-9$@!%*#?&]{8,15}";
		return Pattern.matches(patternUPw, pw);
	}
	
	//2~10자 한글만 사용 가능합니다. (특수기호, 공백 사용 불가)
	public static boolean checkUser_name(String userName) {
		String patternUName = "[가-힣]{2,10}";
		return Pattern.matches(patternUName, userName);
	}
	
	
	public static boolean checkNotify_date() {
		
		return false;
	}
}
