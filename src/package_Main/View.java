package package_Main;



import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import package_VO.UserVO;

public class View {

	
	/**
	 * 문자열 입력 메서드
	 * 
	 * @author 조유진
	 * @return String - 입력받은 문자열
	 */
	String sInput(){
		Scanner scanner = new Scanner(System.in);
		return scanner.next().trim();
	}
	
	/**
	 * 숫자 입력 메서드
	 * 
	 * @author 조유진
	 * @return int - 입력받은 숫자
	 */
	int iInput(){
		int input;
		while(true){
			try{
				Scanner scanner = new Scanner(System.in);
				input = scanner.nextInt();
				break;
			}catch (Exception e){
				System.out.println();
				System.out.println("숫자만 입력해주세요.");
			}
		}
		return input;
	}
	
	/**
	 * 메인뷰
	 * 
	 * @author 홍유리
	 * 
	 */
	void startMethod(){
		String message = "";
		while (true) {
			System.out.println(" ┌──────────────────────────┐ ");
			System.out.println("  ꧁글사랑닷컴에 오신걸 환영합니다.꧂");
			System.out.println(" └────────────γ─────────────┘ ");
			System.out.println("︵‿︵‿︵‿︵‿◝(⁰▿⁰)◜︵‿︵‿︵‿︵‿︵ ");
			System.out.println();
			System.out.println("[1] 로그인");
			System.out.println("[2] 회원가입");
			System.out.println("[0] 종료");
			if (!"".equals(message)) {
				System.out.println();
				System.out.println(message);
				message = "";
			}
			
			switch (iInput()){
			case 0 :
				System.out.println("프로그램을 종료합니다.");
				return;
			case 1 :
				loginView();
				break;
			case 2 :
				insertUserView();
				break;
				default :
					message = "잘못 입력하셨습니다. 다시 입력해 주세요.";
			}
		}
	}
	
	/**
	 * 배너 표시
	 * 
	 * @author 
	 * @param string - 표시해줄 문자열
	 */
	private void showBanner(String string) {
		System.out.println("");
		System.out.println(" ┌───────────────────────────────┐ ");
		System.out.println(" |   개미는  (ง˙∇˙)ว 오늘도              ♪ ♬ | ");
		System.out.println(" |        열심히  (ว˙∇˙)ง           | ");
		System.out.println(" | ♬♪                     일을  ٩(ˊᗜˋ*)و 하네  | ");
		System.out.println(" └───────────────────────────────┘ ");
		System.out.println("\t" + string);
		System.out.println("  ‿︵‿︵‿︵‿︵‿︵‿︵☆︵‿︵‿︵‿︵‿︵︵‿︵");
		System.out.println();
	}
	
	/**
	 * 회원가입 - 사용자 메서드
	 * 
	 * @author 조유진
	 */
	public void insertUserView(){
		UserVO user = new UserVO();
		user.setPoint(-1);
		
		while (true){
			System.out.println("┌─────────────────────────────┐");
			if (user.getId() == null){
				System.out.println("| → 1. 아이디 설정               |");
				System.out.println("|2. 이름 설정                        |");
				System.out.println("|3. 비밀번호 설정                  |");
				System.out.println("|4. 포인트 입력                     |");
			}else if(user.getUserName() == null){
				System.out.println("|1. 아이디 설정                     |");
				System.out.println("| → 2. 이름 설정                  |");
				System.out.println("|3. 비밀번호 설정                  |");
				System.out.println("|4. 포인트 입력                     |");
			}else if(user.getPw() == null){
				System.out.println("|1. 아이디 설정                     |");
				System.out.println("|2. 이름 설정                        |");
				System.out.println("| → 3. 비밀번호 설정            |");
				System.out.println("|4. 포인트 입력                     |");	
			}else{
				System.out.println("|1. 아이디 설정                     |");
				System.out.println("|2. 이름 설정                        |");
				System.out.println("|3. 비밀번호 설정                  |");
				System.out.println("| → 4. 포인트 입력               |");
			}
			System.out.println("└─────────────────────────────┘");
			if(user.getId()==null){
				user.setId(checkId());
				continue;
			}else if(user.getUserName()==null){
				user.setUserName(scanName());
				continue;
			}else if(user.getPw()==null){
				user.setPw(scanPw());
				continue;
			}else if (user.getPoint()== -1){
				user.setPoint(scanPoint());
				continue;
			}
			break;
		}
		if (iServiseImpl.insertUser(user)){
			System.out.println("회원 등록 완료");
		}
	}
	
	/**
	 * 아이디가 유일한지 확인 - 사용자 메서드
	 * 
	 * @author 조유진
	 * @return 아이디가 유일한지 확인하고 String 반환
	 */
	private String checkId(){
		String id;
		while(true){
			id = scanId();
			boolean result = iServiceImpl.checkId(id);
			if(result){
				break;
			}else{
				System.out.println("중복된 아이디입니다.");
			}
			return id;
		}
	}
	
	/**
	 * 아이디가 규칙에 맞는지 확인 - 사용자 메서드
	 * 
	 * @author 조유진
	 * @return 아이디의 규칙이 맞는지 확인하고 입력받은 값 변환
	 */
	private String scanId(){
		String input;
		String message = "";
		while(true){
			System.out.println("아이디 입력");
			System.out.println("****정규식***** 8~20자리의 영문 또는 숫자 조합이 가능합니다");
			if(!"".equals(message)){
				System.out.println();
				System.out.println(message);
			}
			input = sInput();
			if (RegEx.checkUser_id(input)){
				break;
			}
			message = "올바르지 않은 아이디 형식입니다";
		}
		return input;
	}
	/**
	 * 이름 받아오는 메서드 - 사용자 메서드
	 * 
	 * @author 조유진
	 * @return 이름이 규칙에 맞는지 확인 후 String 반환
	 */
	private String scanName(){
		String input;
		String message = "";
		while(true){
			System.out.println();
			System.out.println("이름 입력");
			System.out.println("***정규식***2~17자의 한글만 입력해주세요. (※특수기호, 공백 사용 불가※ )");
			System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
			if(!"".equals(message)){
				System.out.println();
				System.out.println(message);
			}
			input = sInput();
			if (RegEx.checkUser_name(input)){
				break;
			}
			message = "올바르지 않은 이름 형식입니다.";
		}
		return input;
	}
	/**
	 * 비밀번호 받아오는 메서드 - 사용자 메서드
	 * 
	 * @author 이학재
	 * @return 비밀번호 규칙확인을 위해 String 반환
	 */
	private String scanPw(){
		String message = "";
		String input;
		while(true){
			System.out.println();
			System.out.println("비밀번호 입력");
			System.out.println("******정규식※8~20자의 숫자 또는 문자를 입력해주세요※");
			System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
			if(!"".equals(message)){
				System.out.println();
				System.out.println(message);
			}
			input = sInput();
			if (RegEx.checkUser_pw(input)){
				break;
			}
			message = "올바르지 않은 비밀번호 형식입니다";
		}
		return input;
	}
	/**
	 * 포인트 받아오는 메서드 - 사용자 메서드
	 * 
	 * @author 조유진
	 * @return 충전하려는 금액을 int로 반환
	 */
	private int scanPoint(){
		String message = "";
		int point;
		while(true){
			System.out.println();
			System.out.println("포인트 입력");
			System.out.println();
			System.out.println("포인트를 입력해주세요");
			if(!"".equals(message)){
				System.out.println();
				System.out.println(message);
			}
			point = iInput();
			
			if (point > 0) {
				break;
			}
			message = "올바른 숫자를 입력해주세요.";
		}
		return point;
	}
	/**
	 * 로그인 뷰 - 관리자/사용자 메서드 - 아이디 비밀번호 값을 받아 database에서 비교
	 * 
	 * @author 조유진
	 */
	private void loginView(){
		String userId = null;
		String userPw = null;
		String message = "";
		
		while(true){
			System.out.println();
			if(userId == null){
				System.out.println(" → 1. 아이디 입력");
				System.out.println("2.비밀번호 입력");
			}else if(userPw == null){
				System.out.println("1. 아이디 입력");
				System.out.println(" → 2. 비밀번호 입력");
			}
			System.out.println();
			
			if(userId == null){
				System.out.println("아이디를 입력하세요.");
				if(!"".equals(message)){
					System.out.println();
					System.out.println(message);
					message= "";
				}
				userId = sInput();
				continue;
			}else if(userPw == null){
				System.out.println("비밀번호를 입력하세요");
				userPw = sInput();
				continue;
			}
			Map<String, String> loginInfo = new HashMap<>();
			loginInfo.put("user_id", userId);
			loginInfo.put("user_pw", userPw);
			
			if(iServiceImpl.adminLogin(loginInfo)){
				adminMainView();
				break;
			}else if (iServiceImpl.userLogin(loginInfo)){
				user = iServiceImpl.selectUser(userId);
				userMainView();
				break;
			}
			message = "아이디 또는 비밀번호를 확인하세요.";
			userId = null;
			userPw = null;
		}
	}
	/**
	 * 관리자 메인 뷰
	 */
	private void adminMainView() {
		String message = "";
		while (true) {
			showBanner("관리자 페이지");
			System.out.println("[1] 고객 대출 목록 조회");
			System.out.println("[2] 보유 도서 조회");
			System.out.println("[3] 회원 목록 조회");
			System.out.println("[4] 공지 목록 조회");
			System.out.println("[5] 이용권 조회");
			System.out.println("[6] 매출 조회");
			System.out.println("[7] 로그아웃");
			System.out.println();
			System.out.println("메뉴를 선택하세요");
			if (!"".equals(message)) {
				System.out.println();
				System.out.println(message);
				message = "";
			}//end if
			switch (iInput()) {
			case 1:
				System.out.println("고객 대출 목록 조회입니다.");
				break;
			case 2:
				System.out.println("보유 도서 조회입니다.");
				break;	
			case 3:
				System.out.println("회원 목록 조회입니다.");
				break;	
			case 4:
				System.out.println("공지 목록 조회입니다.");
				break;	
			case 5:
				System.out.println("이용권 조회 메뉴입니다.");
				break;	
			case 6:
				System.out.println("메출 조회 메뉴입니다.");
				break;	
			case 7:
				return;
				
			default:
				break;
			}
		}	
		
			
	}//end method
	
	/**
	 * 회원 메인 뷰- 사용자 메서드
	 * @홍유리
	 */
	private void userMainView() {
		String message = "";
		while (true) {
			if (user == null) {
				return;
			}
			System.out.println("-------------------");
			System.out.println("[1] 대출 목록 조회");
			System.out.println("[2] 내 정보 조회");
			System.out.println("[3] 금액 충전");
			System.out.println("[4] 공지 조회");
			System.out.println("[5] 이용권 조회");
			System.out.println("[6] 도서 검색");
			System.out.println("[7] 로그아웃");
			System.out.println();
			System.out.println("메뉴를 선택하세요");
			if (!"".equals(message)) {
				System.out.println();
				System.out.println(message);
				message = "--------------------";
			}//end if
			switch (iInput()) {
			case 1:
				System.out.println("대출 목록 조회입니다.");
				break;
			case 2:
				System.out.println("내 정보 조회입니다.");
				break;	
			case 3:
				System.out.println("금액 충전 메뉴입니다.");
				break;	
			case 4:
				System.out.println("공지 조회 메뉴입니다.");
				break;	
			case 5:
				System.out.println("이용권 조회 메뉴입니다.");
				break;	
			case 6:
				System.out.println("도서 검색 메뉴입니다.");
				break;	
			case 7:
				return;
				break;	

			default:
				break;
			}
		}//end while
	}//end method	
}
