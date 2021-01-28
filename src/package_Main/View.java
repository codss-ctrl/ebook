package package_Main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import package_VO.BookKindVO;
import package_VO.BookVO;
import package_VO.RentVO;
import package_VO.UserVO;

public class View {
	private UserVO user = null;
	private final IServiseImpl iServiceImpl = new IServiseImpl();
	
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
		
		while(true){
			
			System.out.println("회원 가입 메서드 호출");
			System.out.println("[ 0 ] 뒤로가기");
			
			switch (iInput()) {
			case 0:
				// 이전 페이지로 돌아가기
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
		}
	}
	
	/**
	 * 아이디가 유일한지 확인 - 사용자 메서드
	 * 
	 * @author 조유진
	 * @return 아이디가 유일한지 확인하고 String 반환
	 */
	private String checkId(){
	//DB
	//boolean checkId(String id);
	//@param loginInfo
	//@return 로그인 성공 시 true, 실패 시 true 반환
	
		String id;
		while(true){
			id = scanId();
			boolean result = iServiceImpl.checkId(id);

			if(result){
				break;
			}else{
				System.out.println("중복된 아이디입니다.");
			}
		}
		return id;
	}
	
	/**
	 * 아이디가 규칙에 맞는지 확인 - 사용자 메서드
	 * 
	 * @author 조유진
	 * @return 아이디의 규칙이 맞는지 확인하고 입력받은 값 변환
	 */
	public String scanId(){
		String input;
		while(true){
			System.out.println("아이디 입력를 입력하세요");
			System.out.println("****정규식***** 8~20자리의 영문 또는 숫자 조합이 가능합니다");
			
			input = sInput();
			if(RegEx.checkUser_id(input)){
				return input;
			}
			System.out.println("입력하신 아이디가 형식에 맞지 않습니다.");
		}
	}
	
	/**
	 * 이름 받아오는 메서드 - 사용자 메서드
	 * 
	 * @author 조유진
	 * @return 이름이 규칙에 맞는지 확인 후 String 반환
	 */
	private String scanName(){
		String input;
		while(true){
			System.out.println();
			System.out.println("이름 입력");
			System.out.println("***정규식***2~17자의 한글만 입력해주세요. (※특수기호, 공백 사용 불가※ )");
			System.out.println("========================================================");
			
			input = sInput();
			if (RegEx.checkUser_name(input)){
				return input;
			}
			System.out.println("입력하신 이름이 형식에 맞지 않습니다.");
		}
	}
	
	/**
	 * 비밀번호 받아오는 메서드 - 사용자 메서드
	 * 
	 * @author 조유진
	 * @return 비밀번호 규칙확인을 위해 String 반환
	 */
	private String scanPw(){
		String input;
		while(true){
			System.out.println();
			System.out.println("비밀번호 입력");
			System.out.println("******정규식※8~20자의 숫자 또는 문자를 입력해주세요※");
			System.out.println("========================================================");
			
			input = sInput();
			if (RegEx.checkUser_pw(input)){
				return input;
			}
			System.out.println("입력하신 비밀번호가 형식에 맞지 않습니다.");
		}
	}
	
	/**
	 * 포인트 받아오는 메서드 - 사용자 메서드
	 * 
	 * @author 조유진
	 * @return 충전하려는 금액을 int로 반환
	 */
	private int scanPoint(){
		int point;
		while(true){
			System.out.println();
			System.out.println("포인트 입력");
			System.out.println();
			System.out.println("포인트를 입력해주세요");
			
			point = iInput();
			
			if (point > 0) {
				break;
			}
		}
		return point;
	}
	
	/**
	 * 로그인 뷰 - 관리자/사용자 메서드 - 아이디 비밀번호 값을 받아 database에서 비교
	 * 
	 * @author 조유진
	 */
	private void loginView(){
		while(true){
			System.out.println("로그인 뷰 메서드 호출");
			System.out.println("[ 1 ] 사용자 화면 ");
			System.out.println("[ 2 ] 관리자 화면");
			System.out.println("[ 0 ] 뒤로가기");
	
			switch (iInput()) {
			case 0:
				// 이전 페이지로 돌아가기
				return;
			case 1:
				// 유저 화면 호출
				userMainView();
				break;
			case 2:
				// 관리자 화면 호출
				adminMainView();
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
		}
	}

	
	/**
	 * 회원 메인 뷰- 사용자 메서드
	 * @홍유리
	 */
	private void userMainView() {
		String message = "";
		while (true) {
//			if (user == null) {
//				return;
//			}
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

			default:
				break;
			}
		}//end while
	}//end method	

	/**
	 * 대여 목록 조회 - 사용자 메서드
	 * @author 홍유리
	 */
	//DB 필요 - rentList - 사용자의 대여 목록이 떠야함
	//@param iInput - rentList의 seq를 입력 
	//@return 입력받은 seq의 bookList를 통해 책 정보를 반환./ 0 을 입력받으면 전 메뉴화면으로 돌아간다.
	private void rentListView(){
		String message = "";
		while(true){
			System.out.println("도서의 상세정보를 보시려면 해당번호를 입력하세요.");
			System.out.println("[1] 1번 도서");
			System.out.println("[2] 2번 도서");
			System.out.println("[0] 뒤로 가기");
			switch (iInput()) {
			case 0:
				return;
			case 1:
				rentBookDetail();
				break;
			case 2: 
				rentBookDetail();
			default:
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
				continue;
			}
		}
	}
	/**
	 * 대여 도서 상세 보기 - 사용자 메서드
	 * @author 홍유리
	 */
	//DB 필요 - rentList에 저장된 책 정보가 보이고,
		//평점을 입력,수정,삭제하면 bookList와 userInfoList의 grade, user_grade에 저장되어야한다
		//@param iInput
		//@return
	private void rentBookDetail(){
		String message = "";
		int grade;
		while(true){
			System.out.println("해당 도서 상세 정보입니다.");
			System.out.println("[1] 평점 달기");
			System.out.println("[2] 평점 수정");
			System.out.println("[3] 평점 삭제");
			System.out.println("[0] 뒤로 가기");
			
			switch (iInput()) {
			case 0:
				return;
			case 1:
				giveGrade();
				break;
			case 2:
				modifyGrade();
				break;
			case 3:
				deleteGrade();
				break;
			default:
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
				continue;
			}
		}
	}	
	/**
	 * 평점 달기 - 사용자 메서드
	 * @author 홍유리 
	 */
	
	//DB 필요 - userInfoList의 user_grade에 return값이 저장되어야 함 
	//@param iInput 으로 입력받아 int로 변환
	//return 성공시 true, 실패시 false 반환
	
	private int giveGrade(){
		String message = "";
		int grade;
		while(true){
			System.out.println();
			System.out.println("10점 만점 중에 몇 점을 주시겠습니까?");
			
			if(!"".equals(message)){
				System.out.println();
				System.out.println(message);
			}
			grade = iInput();
			
			if (grade > 0) {
				break;
			}
			message = "올바른 숫자를 입력해주세요.";
		}
		return grade;
	}
	/**
	 * 평점 수정 - 사용자 메서드
	 * @author 홍유리
	 * @return 
	 */
	//DB 필요 - userInfoList의 user_grade의 값을 새로 입력받은 값으로 수정
	//@param iInput
	//return 성공시 true, 실패시 false 반환
	private int modifyGrade(){
		String message = "";
		int grade;
		while(true){
			System.out.println();
			System.out.println("수정하실 평점을 입력해주세요.");
			
			if(!"".equals(message)){
				System.out.println();
				System.out.println(message);
			}
			grade = iInput();
			
			if (grade > 0) {
				break;
			}
			message = "올바른 숫자를 입력해주세요.";
		}
		return grade;
	}
	/**
	 * 평점 삭제 - 사용자 메서드
	 * @author 홍유리
	 */
	//DB 필요 - userInfoList의 user_grade를 삭제함
	//@param
	//return 성공시 true, 실패시 false 반환
	public void deleteGrade(){
		// sql → DBClass
		// boolean deleteGrade(int grade_seq)
		String message = "";
		int grade;
		while(true){
			System.out.println("아이스크림 정보를 삭제하시겠습니까?");
			System.out.println("[ 1 ] Y");
			System.out.println("[ 2 ] N");
			System.out.println(message);
			System.out.println("평점을 삭제하였습니다.");
			break;
		}
	}
		
	/**
	 * 내 정보 조회 - 유저메서드
	 * @author 조유진
	 */
	//DB - UserVO
	//
	//
	private void userInfo(){
		String message = "";
		while(true){
			System.out.println("[ 1 ] 이름 변경");
			System.out.println("[ 2 ] 비밀번호 변경");
			System.out.println("[ 3 ] 회원 탈퇴");
			System.out.println("[ 0 ] 뒤로 가기");
			switch(iInput()){
			case 0 :
				return;
			case 1 :
				modifyName();
				break;
			case 2 :
				modifyPassword();
				break;
			case 3 :
				deleteUser();
				break;
			default :
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");		
				continue;
			}
		}
	}
	
	/**
	 * user_name 변경 -사용자 메서드
	 * @author 조유진
	 * 
	 */
	//DB - UserVO
	//
	//
	private void modifyName(){
		String message = "";
		while(true){
			System.out.println("이름을 변경하시겠습니까?");
			System.out.println("[ 1 ] Y");
			System.out.println("[ 0 ] 뒤로 가기");
			
			switch(iInput()){
			case 0 :
				return;
			case 1 :
				System.out.println("이름이 변경되었습니다.");
				break;
			default :
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
				continue;
					
			}
		}
	}
	
	/**
	 * user_pw 변경 -사용자 메서드
	 * @author 조유진
	 */
	//DB - UserVO
	//
	//
	private void modifyPassword(){
		String massage = "";
		while(true){
			System.out.println("비밀번호를 변경하시겠습니까?");
			System.out.println("[ 1 ] Y");
			System.out.println("[ 0 ] 뒤로 가기");
			
			switch(iInput()){
			case 0 :
				return;
			case 1 :
				System.out.println("비밀번호가 변경되었습니다.");
				break;
			default :
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
				continue;
			}
		}
	}
	
	/**
	 * 회원탈퇴 -사용자 메서드
	 * @author 조유진
	 */
	//DB - UserVO
	//
	//
	private void deleteUser(){
		String message = "";
		while(true){
			System.out.println("정말로 탈퇴하시겠습니까?");
			System.out.println("[ 1 ] 회원 탈퇴");
			System.out.println("[ 0 ] 뒤로 가기");
			switch(iInput()){
			case 0 :
				return;
			case 1 :
				System.out.println("탈퇴가 정상적으로 처리되었습니다.");
				break;
			default :
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
				continue;
			}
		}
	}		
		
	
	/**
	 * 금액 충전- 사용자 메서드
	 * @author 홍유리
	 */
	// userList의 point에 입력받은 값을 더함
	//@param iInput()
	//@return 입력받은 값을 더한 총 금액 반환 (userList의 point + iInput() = int)
	private int chargePoint(){
		String message = "";
		int point;
		while(true){
			System.out.println();
			
			System.out.println("현재 고객님이 보유하고 계신 금액은");
			System.out.println("\t 입니다.");
			System.out.println("충전하실 금액을 입력해주세요");
			
			
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
		//총 금액 출력 줄 추가
	}
	/**
	 * 공지 사항 보기 - 사용자 메서드
	 * @author 홍유리
	 */
	//보기 외의 기능없으므로 DB x
	//@param iInput() - 입력받은 숫자로 뷰 이동
	//@return 각 숫자에 맞는 뷰
	private void notifyView(){
		String message = "";
		while(true){
			
			System.out.println("[1] 글사랑 공지사항");
			System.out.println("[2] 이번주 신간 도서");
			System.out.println("[3] 이번주 인기 도서");
			System.out.println("[0] 뒤로 가기");
			
			switch (iInput()) {
			case 0:
				return;
			case 1: 
				userNotifyview();
				break;
			case 2:
				newBookView();
				break;
			case 3:
				popularBookView();
				break;
			default:
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
				continue;
			}
		}	
	}
	/**
	 * 유저용 공지사항 - 사용자 메서드
	 * @author 홍유리
	 * 읽기 기능 외 기능 없음
	 */
	//DB - notifyList의 seq를 나열
	//@param iInput() - 뒤로가기 0만 입력받음
	//return 0을 입력받으면 전 뷰로 넘어감
	private void userNotifyview(){
		while(true){
			System.out.println("공지사항1");
			System.out.println("공지사항2");
			System.out.println("공지사항3");
			System.out.println("[0] 뒤로가기");
			
			switch (iInput()) {
			case 0:
				return;
			}
		}
	}
	/**
	 * 신간도서 보기 - 사용자 메서드
	 * @author 홍유리
	 * 읽기 기능 외 기능 없음
	 */
	
	//DB - bookList의 end index로부터 3~5개의 seq를 추출하여 보여줌
	//@param iInput() - 뒤로가기 0만 입력받음
	//return 0을 입력받으면 전 뷰로 넘어감
	private void newBookView(){
		while(true){
			System.out.println("신간1");
			System.out.println("신간2");
			System.out.println("신간3");
			System.out.println("[0] 뒤로가기");
			
			switch (iInput()) {
			case 0:
				return;
			}
		}
	}
	/**
	 * 인기도서 보기 - 사용자 메서드
	 * @author 홍유리
	 * 읽기 기능 외 기능 없음
	 */
	//DB 필요 - rentList에 있는 book_seq의 개수를 합산하여 가장 높은 순서대로 3위까지 추출함
	//@param iInput() - 뒤로가기 0만 입력가능
	//return 0 입력받으면 전 뷰로 돌아감
	private void popularBookView(){
		System.out.println("인기도서1");
		System.out.println("인기도서2");
		System.out.println("인기도서3");
		System.out.println("[0] 뒤로가기");
		
		switch (iInput()) {
		case 0:
			return;
		}
	}
	
	
	/**
	 * 이용권 보기 - 사용자 메서드
	 * @author 홍유리
	 */
	//DB 필요 - 사용자가 소유한 이용권 내역 확인- userInfoList에서 buyDate별로 지정된 v-seq를 이용
	//									activate 여부 확인 가능하게
	//@param iInput() 입력받은 숫자로 뷰 이동
	//return userInfoList - 사용자가 소유한 이용권 내역  
	private void voucherView(){
		String message = "";
		while(true){
			System.out.println("고객님이 보유하신 이용권 내역입니다 .");
			System.out.println();
			System.out.println("[1] 이용권 구매");
			System.out.println("[0] 뒤로가기");
			
			switch (iInput()) {
			case 0:
				return;
			case 1:
				buyvoucher();
				break;
			default:
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
				continue;
			}
		}
	}
	/**
	 * 이용권 구매 - 사용자 메서드
	 * @author 홍유리
	 */
	//DB 필요 - voucherList에서 price 이용해서 구매
	//@param iInput() - 입력받은 숫자
	//return 이용권 구매 후 pointAfterbuy()메서드로 이용권 구매 후 남은 포인트 출력   
	private void buyvoucher(){
		String message = "";
		while(true){
			System.out.println("이용권 구매입니다.");
			System.out.println("[1] 1일권");
			System.out.println("[2] 7일권");
			System.out.println("[3] 14일권");
			System.out.println("[4] 30일권");
			System.out.println("[5] 90일권");
			System.out.println("[6] 180일권");
			System.out.println("[7] 365일권");
			System.out.println("[0] 뒤로가기");
			
			switch (iInput()) {
			case 0:
				return;
			case 1:
				System.out.println("1일권입니다");
				return;
			case 2:
				System.out.println("7일권입니다");
				return;
			case 3:
				System.out.println("14일권");
				return;
			case 4:
				System.out.println("30일권");
				return;
			case 5:
				System.out.println("90일권");
				return;
			case 6:
				System.out.println("180일권");
				return;
			case 7:
				System.out.println("365일권");
				return;
			default:
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
				continue;
			}
		}
	}

	/**
	 * 도서 검색 - 사용자 메서드
	 * @author 홍유리
	 */
	//도서 검색 뷰로 DB 필요x
	//@param iInput() 입력받은 숫자대로
	//return 뷰 이동
	private void bookView(){
		String message = "";
		while(true){
			System.out.println("[1] 검색 조건을 선택해주세요");
			System.out.println("[2] 도서 대출");
			System.out.println("[0] 뒤로가기");
			
			switch (iInput()) {
			case 0:
				return;
			case 1:
				selectBookFilter();
				break;
			case 2:
				rentBook();
				break;
			default:
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
				continue;
			}
		}
	}
	/**
	 * 도서 검색 조건 선택 - 사용자 메서드
	 * @author 홍유리
	 */
	//DB 필요x
	//@param iInput() 입력받은 숫자대로
	//return 뷰 이동
	private void selectBookFilter(){
		String message = "";
		while(true){
			System.out.println("[1] 책 제목");
			System.out.println("[2] 작가");
			System.out.println("[3] 장르");
			System.out.println("[0] 뒤로가기");
			
			switch (iInput()) {
			case 0:
				return;
			case 1:
				
				searchBookName();	
				System.out.println("번호를 입력하시면 상세보기가 가능합니다.");
				break;
			case 2:
				
				searchBookAuthor();
				System.out.println("번호를 입력하시면 상세보기가 가능합니다.");
				break;
			case 3:
				
				searchBookGenre();
				System.out.println("번호를 입력하시면 상세보기가 가능합니다.");
				break;
			default:
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
				continue;
			}
		}
	}
	/**
	 * 이름으로 책 검색 - 사용자 메서드 
	 * @author  홍유리
	 * @param String - bookList  bookName 
	 * @return bookList를 입력받은 String 으로 필터링한 책목록 
	 */
	//DB -  bookList  bookName,author/ kindList genre
	//@param String - bookList  bookName,author/ kindList genre
	//@return bookList를 입력받은 String 으로 필터링한 책목록 
	private void searchBookName(){
		System.out.println("검색어를 입력하세요");
		System.out.println("-검색 수행하는 부분 추가-");
		System.out.println("[1] 상세보기");
		System.out.println("[0] 뒤로가기");
		switch (iInput()) {
		
		case 0:
			return;
		case 1:
			userBookDetail();

		default:
			break;
		}
		
		
	}
	/**
	 * 작가로 책 검색 - 사용자 메서드
	 * @author  홍유리
	 * @param String - bookList author
	 * @return bookList를 입력받은 String 으로 필터링한 책목록 
	 */
	//DB -  bookList author
	//@param String  - bookList author
	//@return bookList를 입력받은 String 으로 필터링한 책목록
	private void searchBookAuthor(){
		System.out.println("검색어를 입력하세요");
		System.out.println("-검색 수행하는 부분 추가-");
		System.out.println("[1] 상세보기");
		System.out.println("[0] 뒤로가기");
		switch (iInput()) {
		case 0:
			return;
		case 1:
			userBookDetail();

		default:
			break;
		}
		
	}
	/**
	 * 장르로 책 검색 - 사용자 메서드
	 * @author  홍유리
	 * @param String - kindList genre
	 * @return bookList를 입력받은 String 으로 필터링한 책목록
	 */
	//DB - kindList genre
	//@param String - kindList genre
	//@return bookList를 입력받은 String 으로 필터링한 책목록
	private void searchBookGenre(){
		System.out.println("검색어를 입력하세요");
		System.out.println("-검색 수행하는 부분 추가-");
		System.out.println("[1] 상세보기");
		System.out.println("[0] 뒤로가기");
		switch (iInput()) {
		case 0:
			return;
		case 1:
			userBookDetail();

		default:
			break;
		}
		
	}
	/**
	 * 
	 * 도서 상세 보기 - 사용자 메서드
	 * @author  홍유리
	 */
	//DB bookList - BookVO 변수들(book_seq제외)
	//@param 
	//@return String BookVO 변수들(book_seq제외)
	private void userBookDetail(){
		String message = "";
		System.out.println("도서 상세 정보 페이지");
		
	}
	/**
	 * 대여하기 - 사용자 메서드
	 * @author 홍유리
	 */
	//DB rentList
	//@para - bookList - book_seq를 받아 rentList에 저장하여 유저가 확인할 수 있어야함
	//@return - 성공시 true, 실패 시 false
	private void rentBook(){
		String message = "";
			System.out.println("대출 수행");
			System.out.println("대여해주셔서 감사합니다.");
		//
	}

	
	
	
	
	
	/**
	 * 관리자 메인 뷰
	 * 
	 * @author 김대호
	 * 
	 */
	private void adminMainView(){
		String message = "";
		while (true) {
			System.out.println("[ 1 ] 대출 목록 조회");
			System.out.println("[ 2 ] 보유도서 조회");
			System.out.println("[ 3 ] 회원 목록 조회");
			System.out.println("[ 4 ] 공지 목록 조회 ");
			System.out.println("[ 5 ] 이용권 조회 조회");
			System.out.println("[ 6 ] 매출 조회");
			System.out.println("[ 0 ] 로그아웃");
			System.out.println();
			System.out.println("메뉴를 선택하세요.");
			
			switch (iInput()) {
			case 0:
				// 뒤로가기
				return;
			case 1:
				// 대출 목록 조회 메서드 호출
				readRentList();
				break;
			case 2:
				// 보유 도서 조회 메서드 호출
				readBook();
				break;
			case 3:
				// 회원 목록 조회 메서드 호출
				readAllUser();
				break;
			case 4:
				// 공지 사항 조회 메서드 호출
				readAllNotify();
				break;
			case 5:
				// 이용권 조회 메서드 호출
				readVoucher();
				break;
			case 6:
				// 매출 조회 메서드 호출
				readSales();
				break;
			default:
				message = "잘못 입력하셨습니다. 다시 입력해 주세요.";
			}
		}
	}
	
	
	/**
	 * 대출 목록 조회 - 관리자 메서드
	 * 
	 * @author 김대호
	 */
	private void readRentList(){
	//DB
	//List<RentVO> readRentList();
	//@param
	//@return 대여 리스트

		List<RentVO> rentList = iServiceImpl.readRentList();

		for(RentVO rentInfo : rentList){
			
			int book_seq = rentInfo.getBook_seq();
			List<BookVO> bookList = iServiceImpl.readAllBook();
			BookVO selBook = null;
			for(BookVO book : bookList){
				if(book.getBook_seq() == book_seq){
					selBook = book;
					break;
				}
			}

			System.out.print(rentInfo.getBook_seq() + "   ");
			System.out.print(rentInfo.getUser_Id() + "   ");
			System.out.print(selBook.getBook_name() + "   ");
			System.out.println(rentInfo.getRent_date());
		}
		
		while(true){
			System.out.println("[ 0 ] 뒤로가기");
			
			switch (iInput()) {
			case 0:
				return;
			default:
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
			}
		
		}
	}
	
	
	/**
	 * 보유 도서 조회 - 관리자 메서드
	 * 
	 * @author 김대호
	 */
	private void readBook(){
	//DB
	//List<BookVO> readBook();
	//@param
	//@return 보유 책 리스트	
		while(true){
			
			List<BookVO> bookList = iServiceImpl.readAllBook();
			List<BookKindVO> kindList = iServiceImpl.readAllKind();
			for(BookVO book : bookList){
				System.out.print(book.getBook_seq() + "  ");
				System.out.print(book.getBook_name() + "  ");
				for(BookKindVO kind : kindList){
					if(kind.getGenre_seq() == book.getG_seq()){
						System.out.print(kind.getGenre_name() + "  ");
						break;
					}
				}
				System.out.print(book.getAuthor() + "  ");
				System.out.println(book.getRegDate());
		
			}
			System.out.println();
			System.out.println("[ 1 ] 추가하기");
			System.out.println("[ 2 ] 상세 정보 조회하기");
			System.out.println("[ 0 ] 뒤로가기");
	
			switch (iInput()) {
			case 0:
				// 이전 페이지로 돌아가기
				return;
			case 1:
				// 도서 추가
				addBook();
				break;
			case 2:
				// 상세 정보
				bookDetailView(1);
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
		}
	}
	
	
	/**
	 * 도서 추가 - 관리자 메서드
	 * 
	 * @author 김대호
	 */
	private void addBook(){
	//DB
	//boolean addBook(BookVO book);
	//@param 추가할 책 객체 -> get메소드 활용 책속성 설정 
	//@return 책 추가 성공시 true, 실패 시 false반환
		
		while(true){
			BookVO book = new BookVO();

			System.out.println("도서를 추가합니다");
			System.out.println("[ 0 ] 뒤로가기");
			switch (iInput()) {
			case 0:
				// 이전 페이지로 돌아가기
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
		
		}
	}
	
	/**
	 * 선택한 책 상세  정보 - 관리자 메서드
	 * 
	 * @author 김대호
	 */
	private void bookDetailView(int book_seq){
	//DB
	//BookVO bookDetailView(int book_req);
	//@param 선택한 책  seq
	//@return 선택한 책 객체
		while(true){
			
			System.out.println("세부 정보 보기");
			System.out.println("[ 1 ] 도서수정");
			System.out.println("[ 2 ] 도서 삭제");
			System.out.println("[ 0 ] 뒤로가기");
			switch (iInput()) {
			case 0:
				// 이전 페이지로 돌아가기
				return;
			case 1:
				// 도서 수정
				modifyBook(1);
				break;
			case 2:
				// 도서 삭제
				deleteBook();
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
			
		}
	}
	
	
	/**
	 * 보유 도서 수정 - 관리자 메서드
	 * 
	 * @author 김대호
	 */
	private void modifyBook(int book_seq){
	//DB
	//boolean modifyBook(Map<String, Object> bookInfo)
	//@param 수정할 정보 Map으로 전달
	//@return 수정 성공시 true, 실패 시 false반환

		while(true){
			//BookVO selectBook(int book_seq) - 선택책 내용 보여주기
			System.out.println("도서를 수정합니다");
			System.out.println("[ 0 ] 뒤로가기");
			switch (iInput()) {
			case 0:
				// 이전 페이지로 돌아가기
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
		}
	}
	
	
	/**
	 * 보유 도서 제거 - 관리자 메서드
	 * 
	 * @author 김대호
	 */
	
	private void deleteBook(){
	//DB
	//boolean deleteBook(int book_seq);
	//@param 선택한 책 seq 전달
	//@return 삭제 성공시 true, 실패 시 false반환
		while(true){
			
			System.out.println("도서를 삭제합니다");
			System.out.println("[ 0 ] 뒤로가기");
			switch (iInput()) {
			case 0:
				// 이전 페이지로 돌아가기
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
		}
	}
	
	
	/**
	 * 회원 목록 조회 - 관리자 메서드
	 * 
	 * @author 김대호
	 */
	private void readAllUser(){
	//DB
	//List<UserVO> readAllUser();
	//@param 
	//@return 모든 유저 리스트
		
		while(true){
			
			System.out.println("회원 목록 조회 메서드 호출");
			System.out.println("[ 1 ] 회원 상세 조회");
			System.out.println("[ 0 ] 뒤로가기");
			
			switch (iInput()) {
			case 0:
				// 이전 페이지로 돌아가기
				return;
			case 1:
				// 회원 상세 조회
				userDetailView(1);
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
		}
	}
	
	
	/**
	 * 선택한 회원 상세 조회 - 관리자 메서드
	 * 
	 * @author 김대호
	 */
	private void userDetailView(int user_seq){
	//DB
	//UserVO userDetailView(String user_id);
	//@param 선택한 유저 id
	//@return 선택한 유저 정보

		while(true){
			System.out.println("회원 상세 조회");
			System.out.println("[ 0 ] 뒤로가기");
	
			switch (iInput()) {
			case 0:
				// 이전 페이지로 돌아가기
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
		}
	}
	
	
	/**
	 * 모든 공지 조회 - 관리자 메서드
	 * 
	 * @author 김대호
	 */
	private void readAllNotify(){
	//DB
	//List<notifyVO> readAllNotify();
	//@param 
	//@return 모든 공지 리스트 조회
		while(true){
			
			System.out.println("공지 사항 조회 메서드 호출");
			System.out.println("[ 1 ] 공지 추가 하기");
			System.out.println("[ 2 ] 상세 정보 조회하기");
			System.out.println("[ 0 ] 뒤로가기");
	
			switch (iInput()) {
			case 0:
				// 이전 페이지로 돌아가기
				return;
			case 1:
				// 공지 추가
				addNotify();
				break;
			case 2:
				// 상세 정보
				notifyDetailView(1);
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
		}
		
	}
	
	
	/**
	 * 공지 추가 - 관리자 메서드
	 * 
	 * @author 김대호
	 */
	private void addNotify(){
	//DB
	//boolean addNotify(NotifyVO notify);
	//@param 추가할 공지 객체 전달
	//@return 공지 추가 성공시 true, 실패 시 false반환
		while(true){
			
			System.out.println("공지 추가 하기");
			System.out.println("[ 0 ] 뒤로가기");
			
			switch (iInput()) {
			case 0:
				// 이전 페이지로 돌아가기
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
		}
		
	}
	
	
	/**
	 * 선택한 공지 상세 조회 - 관리자 메서드
	 * 
	 * @author 김대호
	*/
	private void notifyDetailView(int notify_req){
	//DB
	//NotifyVO notifyDetailView(int notify_seq);
	//@param 선택한 공지사항 seq 전달
	//@return 선택한 공지 객체 가져오기 
		while(true){
			
			System.out.println("공지 상세 조회 메서드 호출");
			System.out.println("[ 1 ] 공지 수정 하기");
			System.out.println("[ 2 ] 공지 삭제 하기");
			System.out.println("[ 0 ] 뒤로가기");
			
			switch (iInput()) {
			case 0:
				// 이전 페이지로 돌아가기
				return;
			case 1:
				// 공지 수정
				modifyNotify();
				break;
			case 2:
				// 상세 정보
				deleteNotify();
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
		}
		
	}
	
	
	/**
	 * 공지 수정 - 관리자 메서드
	 * 
	 * @author 김대호
	 */
	private void modifyNotify(){
	//DB
	//boolean modifyNotify(Map<String, Object> modifyInfo);	
	//@param 수정할 정보 Map으로 전달
	//@return 수정 성공시 true, 실패 시 false반환
		while(true){
			
			//NofifyVO sellectNotify(int notify_req); - 선택 목록 가져오기	
			System.out.println("공지 수정 메서드 호출");
			System.out.println("[ 0 ] 뒤로가기");
			
			switch (iInput()) {
			case 0:
				// 이전 페이지로 돌아가기
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
		}
	}
	
	
	/**
	 * 공지 삭제 - 관리자 메서드
	 * 
	 * @author 김대호
	 */
	private void deleteNotify(){
	//DB
	//boolean deleteNotify(int notify_seq);
	//@param 선택한 공지 seq 전달
	//@return 삭제 성공시 true, 실패 시 false반환
		while(true){
			
			System.out.println("공지 삭제 메서드 호출");
			System.out.println("[ 0 ] 뒤로가기");
			
			switch (iInput()) {
			case 0:
				// 이전 페이지로 돌아가기
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
		}
	}

	
	
	/**
	 * 모든 이용권 조회 - 관리자 메서드
	 * 
	 * @author 김대호
	 */
	private void readVoucher(){
	//DB
	//List<VoucherVO> readAllVoucher();
	//@param 
	//@return 모든 이용권 리스트 
	
		while(true){
			
			System.out.println("이용권 조회 메서드 호출");
			System.out.println("[ 1 ] 공지 추가 하기");
			System.out.println("[ 2 ] 상세 정보 조회하기");
			System.out.println("[ 0 ] 뒤로가기");
	
			switch (iInput()) {
			case 0:
				// 이전 페이지로 돌아가기
				return;
			case 1:
				// 이용권 추가
				addVoucher();
				break;
			case 2:
				// 이용권 상세 정보
				voucherDetailView(1);
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
		}
	}
	
	
	/**
	 * 이용권 추가 - 관리자 메서드
	 * 
	 * @author 김대호
	 */
	private void addVoucher(){
	//DB
	//boolean addVoucher(VoucherVO voucher);
	//@param 추가할 이용권 객체 전달 
	//@return 추가 성공시 true, 실패 시 false반환
		while(true){
			System.out.println("이용권 추가 메서드 호출");
			System.out.println("[ 0 ] 뒤로가기");
			
			switch (iInput()) {
			case 0:
				// 이전 페이지로 돌아가기
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
			
		}
	}
	
	
	/**
	 * 선택한 이용권 상세 보기 - 관리자 메서드
	 * 
	 * @author 김대호
	 */
	private void voucherDetailView(int voucher_seq){
	//DB
	//VoucherVO voucherDetailView(int voucher_seq);
	//@param 선택한 이용권 seq 전달 
	//@return 선택한 이용권 객체 
		while(true){
			System.out.println("이용권 상세 보기 메서드 호출");
			System.out.println("[ 1 ] 이용권 수정 하기");
			System.out.println("[ 2 ] 이용권 상세 정보 조회하기");
			System.out.println("[ 0 ] 뒤로가기");
	
			switch (iInput()) {
			case 0:
				// 이전 페이지로 돌아가기
				return;
			case 1:
				// 이용권 수정
				modifyVoucher();
				break;
			case 2:
				// 이용권 삭제
				deleteVoucher();
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
		}
	}
	
	
	/**
	 * 이용권 수정 - 관리자 메서드
	 * 
	 * @author 김대호
	 */
	private void modifyVoucher(){
	//DB
	//boolean modifyVoucher(Map<String, Object> voucherInfo);
	//@param 수정할 이용권 정보 Map으로 전달 
	//@return 수정 성공시 true, 실패 시 false반환
		while(true){
			
			System.out.println("이용권 수정 메서드 호출");
			System.out.println("[ 0 ] 뒤로가기");
			
			switch (iInput()) {
			case 0:
				// 이전 페이지로 돌아가기
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
		}
	}
	
	
	/**
	 * 이용권 삭제 - 관리자 메서드
	 * 이용권 비활성화
	 * @author 김대호
	 */
	private void deleteVoucher(){
	//DB
	//boolean deleteVoucher(int voucher_seq); 
	//@param 삭제할 이용권 seq 전달 
	//@return 삭제 성공시 true, 실패 시 false 반환
		while(true){
			
			System.out.println("이용권 삭제 메서드 호출");
			System.out.println("[ 0 ] 뒤로가기");
			
			switch (iInput()) {
			case 0:
				// 이전 페이지로 돌아가기
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
		}
	}
	
	
	/**
	 * 매출 조회 - 관리자 메서드
	 * 
	 * @author 김대호
	 */
	private void readSales(){
	
		while(true){

			System.out.println("매출 조회 메서드 호출");
			System.out.println("[ 1 ] 일매출 보기");
			System.out.println("[ 2 ] 월매출 보기");
			System.out.println("[ 0 ] 연매출 보기");
	
			switch (iInput()) {
			case 0:
				// 이전 페이지로 돌아가기
				return;
			case 1:
				// 일매출 보기
				dailySalesView();
				break;
			case 2:
				// 월매출 보기
				monthlySalesView();
				break;
			case 3:
				// 연매출
				annualSalesView();
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
		}
	}
	
	
	/**
	 * 일매출 조회 - 관리자 메서드
	 * 
	 * @author 김대호
	 */
	private void dailySalesView(){
	//DB
	//List<UserInfoVO> dailySalesView();
	//@param 
	//@return 일매출 리스트(유저정보)	
		while(true){
			
			System.out.println("일매출 조회 메서드 호출");
			System.out.println("[ 0 ] 뒤로가기");
			
			switch (iInput()) {
			case 0:
				// 이전 페이지로 돌아가기
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
		}
	}
	
	
	/**
	 * 월매출 조회 - 관리자 메서드
	 * 
	 * @author 김대호
	 */
	private void monthlySalesView(){
	//DB
	//List<UserInfoVO> monthlySalesView();
	//@param
	//@return 월매출 리스트(유저정보)
	
		while(true){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
//			Date date = new Date();
			Calendar cal = Calendar.getInstance();
			Date date = cal.getTime(); 
			System.out.println("월매출 조회 메서드 호출");
			System.out.println("[ 0 ] 뒤로가기");
			
			switch (iInput()) {
			case 0:
				// 이전 페이지로 돌아가기
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
		}
	}
	
	
	/**
	 * 연매출 조회 - 관리자 메서드
	 * 
	 * @author 김대호
	 */
	private void annualSalesView(){
	//DB
	//List<UserInfoVO> annualSalesView();
	//@param
	//@return 월매출 리스트(유저정보)
		while(true){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
//			Date date = new Date();
			Calendar cal = Calendar.getInstance();
			
			String date = simpleDateFormat.format(cal.getTime());
			System.out.println("연매출 조회 메서드 호출");
			System.out.println("[ 0 ] 뒤로가기");
			
			switch (iInput()) {
			case 0:
				// 이전 페이지로 돌아가기
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
		}
	}
	
	
	
	
	
}
