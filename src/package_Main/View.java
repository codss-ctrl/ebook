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
			System.out.println(" ︵‿︵‿︵‿︵‿◝(⁰▿⁰)◜︵‿︵‿︵‿︵‿︵ ");
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
		System.out.println(" | ♬♪                           일을  ٩(ˊᗜˋ*)و 하네  | ");
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
	//DB필요 - checkUser_pw
	//
	//
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
	
//	private String checkId(){
//		String id;
//		while(true){
//			id = scanId();
//			boolean result = iServiceImpl.checkId(id);
//			if(result){
//				break;
//			}else{
//				System.out.println("중복된 아이디입니다.");
//			}
//			return id;
//		}
//	}
	
	/**
	 * 아이디가 규칙에 맞는지 확인 - 사용자 메서드
	 * 
	 * @author 조유진
	 * @return 아이디의 규칙이 맞는지 확인하고 입력받은 값 변환
	 */
	//DB필요 - checkUser_id
	//
	//
//	private String scanId(){
//		String input;
//		String message = "";
//		while(true){
//			System.out.println("아이디 입력");
//			System.out.println("8 ~ 20자리의 영문 또는 숫자 조합이 가능합니다");
//			if(!"".equals(message)){
//				System.out.println();
//				System.out.println(message);
//			}
//			input = sInput();
//			if (RegEx.checkUser_id(input)){
//				break;
//			}
//			message = "올바르지 않은 아이디 형식입니다";
//		}
//		return input;
//	}
	/**
	 * 이름 받아오는 메서드 - 사용자 메서드
	 * 
	 * @author 조유진
	 * @return 이름이 규칙에 맞는지 확인 후 String 반환
	 */
//	private String scanName(){
//		String input;
//		String message = "";
//		while(true){
//			System.out.println();
//			System.out.println("이름 입력");
//			System.out.println("2 ~ 17자의 한글만 입력해주세요. (※특수기호, 공백 사용 불가※ )");
//			System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
//			if(!"".equals(message)){
//				System.out.println();
//				System.out.println(message);
//			}
//			input = sInput();
////			if (RegEx.checkUser_name(input)){
////				break;
////			}
//			message = "올바르지 않은 이름 형식입니다.";
//		}
//		return input;
//	}
	/**
	 * 비밀번호 받아오는 메서드 - 사용자 메서드
	 * 
	 * @author 이학재
	 * @return 비밀번호 규칙확인을 위해 String 반환
	 */
//	private String scanPw(){
//		String message = "";
//		String input;
//		while(true){
//			System.out.println();
//			System.out.println("비밀번호 입력");
//			System.out.println("******정규식※8~20자의 숫자 또는 문자를 입력해주세요※");
//			System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
//			if(!"".equals(message)){
//				System.out.println();
//				System.out.println(message);
//			}
//			input = sInput();
//			if (RegEx.checkUser_pw(input)){
//				break;
//			}
//			message = "올바르지 않은 비밀번호 형식입니다";
//		}
//		return input;
//	}
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
				searchRentList();
				break;
			case 2:
				
				modifyUserInfo();
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
	 * 내 정보 조회 - 유저 메서드
	 * 
	 * @author 조유진
	 */
	private void modifyUserInfo(){
		String message = "";
		while(true){
//			if (user == null){
//				return;
//			}
			System.out.println("[ 1 ] 이름 변경");
			System.out.println("[ 2 ] 비밀번호 변경");
			System.out.println("[ 3 ] 회원 탈퇴");
			System.out.println("[ 0 ] 뒤로 가기");
			
			switch (iInput()){
			case 0 :
				//이전 페이지로 돌아가기
				return;
			case 1 :
				//이름 변경
				modifyName();
				break;
			case 2 :
				//비밀번호 변경
				modifyPassword();
				break;
			case 3 :
				//회원 탈퇴
				deleteUser();
				break;
			default :
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
		}
	}
	/**
	 * 사용자 이름 변경 - 사용자 메서드
	 * 
	 * @author 조유진
	 */
	private void modifyName(){
		String message = "";
		while(true){
			System.out.println("[ 1 ] 변경하실 이름을 입력해주세요");
			System.out.println("[ 0 ] 뒤로 가기");
			
			switch (iInput()){
			case 0 :
				return;
			case 1 :
				System.out.println("이름이 변경되었습니다.");
				break;
			default :
				System.out.println("잘못 입력하셨습니다.");
			}
	    }
	}
	
	/**
	 * 사용자 비밀번호 변경 - 사용자 메서드
	 * 
	 * @author 조유진
	 */
	private void modifyPassword(){
		String message = "";
		while(true){
		
		System.out.println("[ 1 ] 새로운 비밀번호를 입력해주세요. ");
		System.out.println("[ 0 ] 뒤로 가기");
		
			switch (iInput()){
			case 0 :
				return;
			case 1 :
				System.out.println("비밀번호가 변경되었습니다.");
				break;
			default :
				System.out.println("잘못 입력하셨습니다.");
			}	
		}
	}
	
	/**
	 * 회원 탈퇴 - 사용자 메서드
	 * 
	 *  @author 조유진
	 */
	private void deleteUser(){
		String message = "";
		while(true){
		System.out.println("정말로 탈퇴하시겠습니까?");
		System.out.println("[ 1 ] 회원 탈퇴");
		System.out.println("[ 0 ] 뒤로 가기");
		
			switch (iInput()){
			case 0 :
				return;
			case 1 :
				System.out.println("회원 탈퇴가 정상적으로 처리되었습니다.");
				break;
			default :
				System.out.println("잘못 입력하셨습니다.");
			}
		}	
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
//			showBanner("관리자 페이지");
			System.out.println("[ 1 ] 대출 목록 조회");
			System.out.println("[ 2 ] 보유도서 조회");
			System.out.println("[ 3 ] 회원 목록 조회");
			System.out.println("[ 4 ] 공지 목록 조회 ");
			System.out.println("[ 5 ] 이용권 조회 조회");
			System.out.println("[ 6 ] 매출 조회");
			System.out.println("[ 0 ] 로그아웃");
			System.out.println();
			System.out.println("메뉴를 선택하세요.");
			if (!"".equals(message)) {
				System.out.println();
				System.out.println(message);
				message = "";
			}
			
			switch (iInput()) {
			case 0:
				// 뒤로가기
				return;
			case 1:
				// 대출 목록 조회 메서드 호출
				searchRentList();
				break;
			case 2:
				// 보유 도서 조회 메서드 호출
				searchBook();
				break;
			case 3:
				// 회원 목록 조회 메서드 호출
				searchUserList();
				break;
			case 4:
				// 공지 사항 조회 메서드 호출
				searchNotifyList();
				break;
			case 5:
				// 이용권 조회 메서드 호출
				searchVoucher();
				break;
			case 6:
				// 매출 조회 메서드 호출
				searchSales();
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
	private void searchRentList(){
		String message = "";
		while(true){
				
			System.out.println("대출 목록 조회 메서드 호출");
			
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
	private void searchBook(){
		while(true){
			
			System.out.println("보유 도서 조회 메서드 호출");
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
				bookDetailView();
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
		while(true){
			
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
	 * 도서 세부 정보 - 관리자 메서드
	 * 
	 * @author 김대호
	 */
	private void bookDetailView(){
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
				modifyBook();
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
	private void modifyBook(){
		while(true){
			
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
	private void searchUserList(){
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
				userDetailView();
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
		}
	}
	
	
	/**
	 * 회원 상세 목록 조회 - 관리자 메서드
	 * 
	 * @author 김대호
	 */
	private void userDetailView(){
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
	 * 공지 목록 조회 - 관리자 메서드
	 * 
	 * @author 김대호
	 */
	private void searchNotifyList(){
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
				notifyDetailView();
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
	 * 공지 상세 정보 조회 - 관리자 메서드
	 * 
	 * @author 김대호
	 */
	private void notifyDetailView(){
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
		while(true){
			
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
	 * 이용권 조회 - 관리자 메서드
	 * 
	 * @author 김대호
	 */
	private void searchVoucher(){
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
				voucherDetailView();
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
	 * 이용권 상세 보기 - 관리자 메서드
	 * 
	 * @author 김대호
	 */
	private void voucherDetailView(){
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
	 * 
	 * @author 김대호
	 */
	private void deleteVoucher(){
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
	private void searchSales(){
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
		while(true){
			
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
		while(true){
			
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
