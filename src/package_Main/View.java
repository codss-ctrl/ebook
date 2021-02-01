package package_Main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import package_VO.BookKindVO;
import package_VO.BookVO;
import package_VO.NotifyVO;
import package_VO.RentVO;
import package_VO.UserInfoVO;
import package_VO.UserVO;
import package_VO.VoucherVO;


public class View {
	private UserVO user = null;
	private final IServiseImpl iServiceImpl = new IServiseImpl();

	
	/**
	 * 오늘 날짜 가져오기
	 * 
	 * @author 김대호
	 * @return String(오늘 날짜 : 2021-01-30)
	 */
	String getTodayDate(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
		Calendar cal = Calendar.getInstance();
		String date = simpleDateFormat.format(cal.getTime());
		return date;
	}
	
	
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
	 * 문자열 입력 메서드
	 * 
	 * @author 조유진
	 * @return String - 입력받은 문자열(공백포함)
	 */
	String sInputs(){
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine().trim();
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
				addUserView();
				break;
				default :
					message = "잘못 입력하셨습니다. 다시 입력해 주세요.";
			}
		}
	}
	
	
	/**
	 * 로그인 뷰 - 관리자/사용자 메서드 - 아이디 비밀번호 값을 받아 database에서 비교
	 * 
	 * @author 조유진
	 */
	private void loginView(){
		String user_id = null;
		String user_pw = null;
		
		while(true){
			System.out.println();
			System.out.println("아이디를 입력하세요");
			user_id = sInput();
			System.out.println("비밀번호를 입력하세요");
			user_pw = sInput();
			Map<String, String> loginInfo = new HashMap<>();
			loginInfo.put("user_id", user_id);
			loginInfo.put("user_pw", user_pw);
			
			if (iServiceImpl.adminLogin(loginInfo)) {
				adminMainView();
				break;
			}
			
			user = iServiceImpl.userLogin(loginInfo);
			if(user != null){
				userMainView();
				break;
			}else{
				System.out.println("아이디 또는 비밀번호를 다시 확인해 주세요.");
			}
			
		}//end while
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
	public void addUserView(){
		UserVO user = new UserVO();
		user.setUser_point(-1);
		while(true){
			System.out.println("========================");
			if(user.getUser_id() == null){
				System.out.println(" * 1. 아이디 설정");
				System.out.println("2. 비밀 번호 설");
				System.out.println("3. 이름 설정");
				System.out.println("4. 포인트 설정");
				System.out.println("========================");
			}else if(user.getUser_pw() == null){
				System.out.println("1. 아이디 설정");
				System.out.println(" * 2. 비밀 번호 설");
				System.out.println("3. 이름 설정");
				System.out.println("4. 포인트 설정");
				System.out.println("========================");
			}else if(user.getUser_name() == null){
				System.out.println("1. 아이디 설정");
				System.out.println("2. 비밀 번호 설");
				System.out.println(" * 3. 이름 설정");
				System.out.println("4. 포인트 설정");
				System.out.println("========================");
			}else if(user.getUser_point() == -1){
				System.out.println("1. 아이디 설정");
				System.out.println("2. 비밀 번호 설");
				System.out.println("3. 이름 설정");
				System.out.println(" * 4. 포인트 설정");
				System.out.println("========================");
			}
			if (user.getUser_id() == null) {
				user.setUser_id(checkId());
				continue;
			}else if(user.getUser_pw() == null) {
				user.setUser_pw(scanPw());
				continue;
			} else if (user.getUser_name() == null) {
				user.setUser_name(scanName());
				continue;
			} else if (user.getUser_point() == -1) {
				user.setUser_point(scanPoint());
				continue;
			}
			break;
		}
		if (iServiceImpl.addUser(user)) {
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
			System.out.println("아이디를 입력하세요");
			System.out.println("4 ~ 12자리 영문 소문자, 숫자와 특수기호 _ , - 만 사용 가능합니다.");
			
			input = sInput();
			if(RegEx.checkUser_id(input)){
				return input;
			}
			System.out.println("입력하신 아이디가 형식에 맞지 않습니다.");
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
			System.out.println("8 ~ 15자리 영문 대 소문자, 숫자, 특수문자만 사용 가능합니다.");
			System.out.println("영문자, 숫자, 특수문자가 한드시 하나씩 포함되어야 합니다");
			System.out.println("========================================================");
			
			input = sInput();
			if (RegEx.checkUser_pw(input)){
				return input;
			}
			System.out.println("입력하신 비밀번호가 형식에 맞지 않습니다.");
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
			System.out.println("2~10자 한글만 사용 가능합니다. (특수기호, 공백 사용 불가)");
			System.out.println("========================================================");
			
			input = sInput();
			if (RegEx.checkUser_name(input)){
				return input;
			}
			System.out.println("입력하신 이름이 형식에 맞지 않습니다.");
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
	
	

////////////////////////////////////////////////////////////////	
//사용자
////////////////////////////////////////////////////////////////	

	
	/**
	 * 회원 메인 뷰
	 * @홍유리
	 */
	//DB 필요 x
	
	private void userMainView() {
		String message = "";
		while (true) {
			System.out.println("-------------------");
			System.out.println("[1] 내 정보 조회");
			System.out.println("[2] 대출 목록 조회");
			System.out.println("[3] 공지 조회");
			System.out.println("[4] 이용권 조회");
			System.out.println("[5] 도서 검색");
			System.out.println("[0] 뒤로 가기");
			System.out.println();
			System.out.println("메뉴를 선택하세요");
			if (!"".equals(message)) {
				System.out.println();
				System.out.println(message);
				message = "--------------------";
			}//end if
			switch (iInput()) {
			case 1:
				userInfo();
				break;
			case 2:
				rentListView();
				break;	
			case 3:
				notifyView();
				break;	
			case 4:
				voucherView();
				break;	
			case 5:
				bookView();
				break;	
			case 0:
				return;

			default:
				break;
			}
		}//end while
	}//end method	
	
	
	/**
	 * 내 정보 조회 - 유저메서드
	 * @author 조유진
	 */
	//DB - UserVO
	//
	//
	private void userInfo(){
	
		while(true){
			System.out.println("\t 내정보 보기");
			System.out.println("아이디 : " + user.getUser_id());
			System.out.println("비밀번호 : " + user.getUser_pw());
			System.out.println("이름 : " + user.getUser_name());
			System.out.println("보유 금액 : " +user.getUser_point());

		
			
			System.out.println("[ 1 ] 이름 변경");
			System.out.println("[ 2 ] 비밀번호 변경");
			System.out.println("[ 3 ] 금액 충전");
			System.out.println("[ 4 ] 회원 탈퇴");
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
				chargePoint();
				break;
			case 4 :
				deleteUser();
				break;
			default :
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");		
				continue;
			}
		}
	}
	
	/**
	 * 유저 이름 변경 -사용자 메서드
	 * @author 조유진
	 * 
	 */
	//DB - UserVO
	//
	//
	private void modifyName(){
		
		while(true){
			System.out.println("현재 고객님의 이름은 "+user.getUser_name()+" 입니다.");
			System.out.println("이름을 변경하시겠습니까? Y/N");
			System.out.println("N을 입력하시면 이전화면으로 돌아갑니다.");
			
			Map<String, Object> userInfo = new HashMap<>();
			userInfo.put("user_id",user.getUser_id());
			
			String input = sInput();
			
			if(input.equals("Y") || input.equals("y")){
				System.out.println("이름 변경을 위해 새로운 이름을 입력해주세요");
				userInfo.put("user_name",scanName());//key : name, value : scanName()
				iServiceImpl.userUpdate(userInfo);
				return;
				
			}else if(input.equals("N") || input.equals("n")){
				return;
			 }// end else if	
		  	
		}//while end
	}//end method		

	/**
	 * 유저 비밀번호 변경 -사용자 메서드
	 * @author 조유진
	 */
	//DB - UserVO
	//
	//
	private void modifyPassword(){
		Map<String, Object> userInfo = new HashMap<>();
		userInfo.put("user_id",user.getUser_id());
		userInfo.put("user_pw",scanPw());
		iServiceImpl.userUpdate(userInfo);
		return;
	
		
	}
	
	/**
	 * 회원탈퇴 -사용자 메서드
	 * @author 조유진
	 */
	//DB - UserVO
	//
	//
	private void deleteUser(){
		while(true){
			System.out.println("정말로 탈퇴하시겠습니까?");
			System.out.println("[ 1 ] 회원 탈퇴");
			System.out.println("[ 0 ] 뒤로 가기");
			switch(iInput()){
			case 0 :
				return;
			case 1 :
				iServiceImpl.deleteUser(user.getUser_id());
				System.out.println("그 동안 글사랑닷컴을 이용해 주셔서 감사합니다.");
				startMethod();
			default :
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
				continue;
			}
		}
	}	
	
	/**
	 * 대여 목록 조회 - 사용자 메서드
	 * @param user_id
	 * @return 대여한 책 목록을 반환.
	 * 			
	 * @author 홍유리
	 */
	//DB 필요 - rentList - 사용자의 대여 목록이 떠야함
	//@param iInput - rentList의 seq를 입력 
	//return 입력받은 seq의 bookList를 통해 책 정보를 반환./ 0 을 입력받으면 전 메뉴화면으로 돌아간다.
	private void rentListView(){
		while(true){
			System.out.println("===================================================");
			System.out.println("\t\t"+user.getUser_name()+"님이 대여하신 내역입니다.");
			System.out.println("===================================================\n");
			System.out.println("\t\t|해당 도서번호를 입력하시면|\n\t\t|도서상세보기가 가능합니다.|\n");
			int seq = 0;
			List<RentVO> userRentDetail = iServiceImpl.rentListView(user.getUser_id());
			for (int i = 0; i < userRentDetail.size(); i++) {
				BookVO userBook = iServiceImpl.bookSelector(userRentDetail.get(i).getBook_seq());
				System.out.println("\t 책 이름 \t\t 작가 \t\t 대여날짜 \n");
				System.out.print("["+userRentDetail.get(i).getRent_seq()+"]\t");
				System.out.print(userBook.getBook_name()+"\t");
				System.out.print(userBook.getAuthor()+"\t\t");
				System.out.println(userRentDetail.get(i).getRent_date()+"\t\n");
				seq =userRentDetail.get(i).getRent_seq();
			}
			System.out.println("===================================================\n");
			System.out.println("총 대여 권수 : "+userRentDetail.size()+"\n");
			System.out.println(seq);
			System.out.println("[0] 뒤로 가기");
			int input = iInput();
			if (input == seq) {
				 rentBookDetail(seq);
				return;
			}else if (input == 0) {
				return;
			} else {
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
				continue;
			}
		}
	}
	/**
	 * 대여 목록 상세 조회 - 사용자 메서드
	 * @param rent_seq
	 * rent_seq에 담겨있는 book_seq를 통해 책의 정보를 읽을 수 있음
	 * @return 
	 * @author 홍유리
	 */
	//DB 필요 - 책 정보가 보이고,
	//평점을 입력,수정,삭제하면 bookList와 userInfoList의 grade, user_grade에 저장되어야한다
	//@param iInput
	//return
	private void rentBookDetail(int book_seq){
		int seq = 0;
		while(true){
			System.out.println("===================================================\n");
			List<RentVO> userRentDetail = iServiceImpl.rentListView(user.getUser_id());
			for (int i = 0; i < userRentDetail.size(); i++) {
				BookVO selbook = iServiceImpl.bookSelector(userRentDetail.get(i).getBook_seq());
				System.out.println("\t 책 이름 \t\t 작가 \t 내 평점 \n");
				System.out.print("\t"+selbook.getBook_name()+"\t");
				System.out.print(selbook.getAuthor()+"\t");
				System.out.println(selbook.getBook_grade());
				seq =userRentDetail.get(i).getRent_seq();
			}
			System.out.println("===================================================\n");
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
	 * (평점을 입력하면 bookList와 userInfoList의 grade, user_grade에 저장되어야한다)
	 * @param rent_grade
	 * @return 성공  시 true, 실패시 false
	 * @author 홍유리
	 */
	//DB 필요 - userInfoList의 user_grade에 return값이 저장되어야 함 
	//@param iInput 으로 입력받아 int로 변환
	//return int
	
	private int giveGrade(){
		String message = "";
		int grade = 0;
		while(true){
			System.out.println();
			System.out.println("10점 만점 중에 몇 점을 주시겠습니까?");
			 
			grade = iInput();
			Map<String, Object> usergrade = new HashMap<>();
			usergrade.put("grade", (Integer)grade);
//			usergrade = iServiceImpl.giveGrade(grade);
			
			if (grade > 0) {
				break;
			}
		}
		return grade;
	}
	/**
	 * 
	 * 평점 수정 - 사용자 메서드
	 * 
	 * @param rentInfo
	 * @return 성공 시 true, 실패 시 false
	 * @author 홍유리
	 */
	//DB 필요 - userInfoList의 user_grade의 값을 새로 입력받은 값으로 수정
	//@param iInput
	//return int
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
	 * @param rentInfo
	 * @return 성공 시 true, 실패 시 false
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
			System.out.println("평점을 삭제하시겠습니까?");
			System.out.println("[ 1 ] Y");
			System.out.println("[ 2 ] N");
			System.out.println(message);
			System.out.println("평점을 삭제하였습니다.");
			break;
		}
	}

	
	/**
	 * 금액 충전- 사용자 메서드
	 * @param point 기존 금액과 충전한 금액의 합
	 * @author 홍유리
	 */
	// userList의 point에 입력받은 값을 더함
	//@param iInput()
	//@return 입력받은 값을 더한 총 금액 반환 (userList의 point + iInput() = int)
	private void chargePoint(){
		
			System.out.println();
			
			System.out.println("현재 고객님이 보유하고 계신 금액은");
			System.out.println(user.getUser_point() + " 입니다.");
			System.out.println("충전하실 금액을 입력해주세요");
			int point = scanPoint();
			Map<String, Object> userInfo  = new HashMap<>();
			userInfo.put("user_id", user.getUser_id());
			userInfo.put("user_point", point);
			if (point > 0) {
				iServiceImpl.chargePoint(userInfo);
				return;
			}
	}
	
	
	/**
	 * 공지 사항 보기 - 사용자 메서드
	 * @ 홍유리
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
			List<NotifyVO> notifyList = iServiceImpl.userNotifyView();//공지 객체 생성
			
			while (true) {
				System.out.println();
				System.out.println(" ┌──────────────────────────┐ ");
				System.out.println("꧁          글사랑닷컴 공지사항            ꧂");
				System.out.println(" └────────────γ─────────────┘ ");
				System.out.println("︵‿︵‿︵‿︵‿◝(⁰▿⁰)◜︵‿︵‿︵‿︵‿︵ ");
				System.out.println();
				System.out.println("︵‿공지 번호를 입력하시면 공지 내용을 보실 수 있습니다.︵‿");
				System.out.println();
				if(notifyList.size()>0){
					System.out.println("공지번호\t\t\t조회수 \t\t 등록일");
					
					for(NotifyVO notify : notifyList ){
						System.out.print("["+notify.getNotify_seq()+"]");
						System.out.print("["+ notify.getNotify_title()+"]");
						
						System.out.print("\t" +notify.getReadCount());
						System.out.println("\t"+notify.getNotify_date());
						System.out.println();
					}
				}else{
					System.out.println("공지사항이 없습니다.");
				}
				System.out.println();
				System.out.println();
				System.out.println("[0] 뒤로가기");
				int input = iInput();
				if (input==0) {
					return;
				}else if (input >0 && input < notifyList.size()+1) {
					userNotifyDetail(input-1);
				}else{
					System.out.println("잘못 입력하셨습니다.");
				}
			}
		}
	}
	/**
	 * * 유저 공지 상세 조회
	 * @param notify_seq
	 * @return 선택한 공지 내용을 반환
	 * @author 홍유리
	 */
	public void userNotifyDetail(int notify_seq){
		System.out.println();
		
			List<NotifyVO> notifyList = iServiceImpl.userNotifyDetail(notify_seq);
				System.out.println(notifyList.get(notify_seq).getContents());
				System.out.println("[0] 뒤로 가기");
				int input=iInput();
				if (input==0) {
					return;
				}

	}
	
	/**
	 * 신간도서 보기 - 사용자 메서드
	 * bookList의 end index로부터 3~5개의 seq를 추출하여 보여줌
	 * 읽기 기능 외 기능 없음
	 * @param book_seq
	 * @return
	 * @author 홍유리
	 */
	
	//DB - bookList의 end index로부터 3~5개의 seq를 추출하여 보여줌
	//@param iInput() - 뒤로가기 0만 입력받음
	//return 0을 입력받으면 전 뷰로 넘어감
	private void newBookView(){
		System.out.println();
		while(true){
			List<BookVO> bookList = iServiceImpl.newBookView();
			System.out.println("책 제목 \t\t작가 \t\t 등록일");
			for (int i = bookList.size()-1; i > bookList.size()-4; i--) {
				System.out.print(bookList.get(i).getBook_name());
				System.out.print("\t");
				System.out.print(bookList.get(i).getAuthor());
				System.out.print("\t");
				System.out.println(bookList.get(i).getRegDate());
				
			}
			System.out.println();
			System.out.println("[0] 뒤로가기");
			
			switch (iInput()) {
			case 0:
				return;
			}
		}
	}
	/**
	 * 인기도서 보기 - 사용자 메서드
	 * rentList에 중복된 book_seq의 개수를 합산하여 가장 높은 순서대로 3위까지 추출함
	 * 읽기 기능 외 기능 없음
	 * @param book_seq
	 * @return
	 * @author 홍유리
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

//////////////////////////////////////////////////////////////////////
//	kdh
/////////////////////////////////////////////////////////////////////	
	/**
	 * 유저가 소유한 이용권 보기 - 사용자 메서드
	 * 보기만 가능
	 * 사용자가 소유한 이용권 내역 확인(현재 이용 가능한 이용권만 보이기) 
	 * userInfoList에서 buyDate별로 지정된 v-seq를 이용 + activate 여부 확인 가능하게
	 * @param user_id
	 * @return
	 * @author 홍유리
	 */
	
	//DB 필요 - 사용자가 소유한 이용권 내역 확인- userInfoList에서 buyDate별로 지정된 v-seq를 이용
	//									activate 여부 확인 가능하게
	//@param iInput() 입력받은 숫자로 뷰 이동
	//return userInfoList - 사용자가 소유한 이용권 내역  
	private void voucherView(){
		
		while(true){
			List<UserInfoVO> userInfoList = iServiceImpl.userVoucher(user.getUser_id());//로그인한 유저정보 가져오기

			System.out.println("==============================================================");
			System.out.println(" No      제목                               가격                구매일");
			System.out.println("--------------------------------------------------------------");
			for(int i = 0; i < userInfoList.size(); i++){

				System.out.print("  " + (i+1) +"\t");
								
				VoucherVO voucher = iServiceImpl.voucherSelector(userInfoList.get(i).getv_seq());
				System.out.print(voucher.getV_name() + "\t\t");
				System.out.print(voucher.getV_price() + "원\t");
				System.out.println(userInfoList.get(i).getBuy_date() +"\t");

			}			
				
			System.out.println("--------------------------------------------------------------");
			System.out.println("[ 0 ] 뒤로가기");
			System.out.println("==============================================================");
	
			int input = iInput();
			if(input == 0){
				// 이전 페이지로 돌아가기
				return;
			}else if(0 < input && input < userInfoList.size()+1){
				userVoucherDetail(userInfoList.get(input-1));
			}else{
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
			}
		}
	}
	
	
	/**
	 * 유저의 이용권 상세보기 - 사용자 메서드
	 * 보기만 가능(기간 만료된 이용권 보이지 않음
	 * @param v_seq
	 * @return
	 */
	public void userVoucherDetail(UserInfoVO info){
		while(true){
			System.out.println("=========================");
			System.out.println("\t이용권 상세보기");
			System.out.println("-------------------------");
			System.out.println("아이디 : "+ info.getUser_id());
			VoucherVO voucher = iServiceImpl.voucherSelector(info.getv_seq());
			System.out.println("이용권 : "+ voucher.getV_name());
			System.out.println("가격 : "+ voucher.getV_price() + "원");
			System.out.println("구매일 : "+ info.getBuy_date());
			
			System.out.println("-------------------------");
			System.out.println("[ 0 ] 뒤로가기");
			System.out.println("=========================");
			
			
			switch (iInput()) {
			case 0:
				return;
			default:
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
				continue;
			}
		}
	}
	
	
	/**
	 * 이용권 구매 - 사용자 메서드
	 * voucherList에서 price 이용해서 구매
	 * @author 홍유리
	 * @param v_seq
	 * @return 성공 시 true, 실패시 false 반환
	 */
	//DB 필요 - voucherList에서 price 이용해서 구매
	//@param iInput() - 입력받은 숫자
	//return 이용권 구매 후 pointAfterbuy()메서드로 이용권 구매 후 남은 포인트 출력   
	private void buyVoucher(){
		String message = "";
		while(true){
			System.out.println("이용권 구매입니다.");
			System.out.println("[1] 1일권");
			System.out.println("[2] 7일권");
			System.out.println("[3] 30일권");
			System.out.println("[4] 90일권");
			System.out.println("[5] 365일권");
			System.out.println("[0] 뒤로가기");
			
			Map<String, Object> voucherInfo = new HashMap<>();
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
				System.out.println("30일권");
				return;
			case 4:
				System.out.println("90일권");
				return;
			case 5:
				System.out.println("365일권");
				return;
			default:
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
				continue;
			}
		}
	}
	
	
	/**
	 * 도서 검색 뷰 - 사용자 메서드
	 * @author 김대호
	 */
	//도서 검색 뷰로 DB 필요x
	//@param iInput() 입력받은 숫자대로
	//return 뷰 이동
	private void bookView(){
		String message = "";
		while(true){
			System.out.println("[1] 제목 검색");
			System.out.println("[2] 작가 검색");
			System.out.println("[3] 장르 검색");
			System.out.println("[0] 뒤로가기");
			
			switch (iInput()) {
			case 0:
				return;
			case 1:
				searchBookName();
				break;
			case 2:
				searchBookAuthor();
				break;
			case 3:
				searchBookGenre();
				break;
			default:
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
				continue;
			}
		}
	}
	
	
	/**
	 * 
	 * 책 제목으로 책 검색 - 사용자 메서드
	 *  
	 * @author 김대호
	 */
	//DB -  bookList  bookName,author/ kindList genre
	//@param String - bookList  bookName,author/ kindList genre
	//@return bookList를 입력받은 String 으로 필터링한 책목록 
	private void searchBookName(){
		System.out.println("책 제목을 입력하세요");
		String searchName = sInputs();
		while(true){
			List<BookVO> bookList = iServiceImpl.searchBookName(searchName); //입력한 검색어로 불러온 책리스트
			if(bookList.size() == 0){
				System.out.println("입력하신 작가 이름과 일치하는 책이 없습니다");
				return;
			}
			bookListView(bookList);
			
			int input = iInput();
			BookVO selBook;
			
			if(input == 0){
				return;
			}else if(0 < input && input < bookList.size()+1){
				selBook = iServiceImpl.bookSelector(bookList.get(input-1).getBook_seq());
				bookDetailView(selBook);
			}else{
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
		}
	}
	

	/**
	 * 작가로 책 검색 - 사용자 메서드
	 * 
	 * @param searchAuthor
	 * @return 입력받은 String 으로 필터링한 책목록 
	 * @author 김대호
	 */
	//DB -  bookList author
	//@param String  - bookList author
	//@return bookList를 입력받은 String 으로 필터링한 책목록
	private void searchBookAuthor(){
		System.out.println("작가 이름을 입력하세요");
		String searchAuthor = sInputs();
		while(true){
			List<BookVO> bookList = iServiceImpl.searchBookAuthor(searchAuthor); //입력한 검색어로 불러온 책리스트
			if(bookList.size() == 0){
				System.out.println("입력하신 작가 이름의 책이 없습니다");
				return;
			}
			bookListView(bookList);
			
			int input = iInput();
			BookVO selBook;
			
			if(input == 0){
				return;
			}else if(0 < input && input < bookList.size()+1){
				selBook = iServiceImpl.bookSelector(bookList.get(input-1).getBook_seq());
				bookDetailView(selBook);
			}else{
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
		}
	}
	
	
	/**
	 * 장르로 책 검색 - 사용자 메서드
	 * @param searchGenre
	 * @return 입력받은 String 으로 필터링한 책목록
	 * @author 김대호
	 */
	//DB - kindList genre
	//@param String - kindList genre
	//@return bookList를 입력받은 String 으로 필터링한 책목록
	private void searchBookGenre(){
			System.out.println("장르를 선택하세요");

			List<BookVO> bookList = iServiceImpl.searchBookGenre(selectGenre()); //입력한 검색어로 불러온 책리스트
			if(bookList.size() == 0){
				System.out.println("선택한 장르의 책이 없습니다");
				System.out.println();
				return;
			}
			
		while(true){
			bookListView(bookList);
			
			int input2 = iInput();
			BookVO selBook;
			
			if(input2 == 0){
				break;
			}else if(0 < input2 && input2 < bookList.size()+1){
				selBook = iServiceImpl.bookSelector(bookList.get(input2-1).getBook_seq());
				bookDetailView(selBook);
			}else{
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
		}
	}
	
	
	/**
	 * 책 리스트 출력하기
	 * @param bookList
	 * @author  김대호
	 */
	void bookListView(List<BookVO> bookList){
		System.out.println("===========================================================");
		
		if(user == null){
			System.out.println("  번호\t\t제목\t\t 작가\t\t계약상태");
			System.out.println("-----------------------------------------------------------");
		
			for(int i=0; i<bookList.size(); i++){
				System.out.print(String.format("[%2d ]  %-20s\t%-15s\t  ", i+2, 
						bookList.get(i).getBook_name(), bookList.get(i).getAuthor()));

				if(bookList.get(i).getBook_isActivate()){
					System.out.println("정상");
				}else{
					System.out.println("만료");
				}
			}	
			System.out.println("-----------------------------------------------------------");
			if(bookList.size() == 1){

			}else{
				System.out.println("[ 2 ~ " + (bookList.size()) + " ] 상세보기 선택");
			}
			System.out.println("[ 1 ] 책 추가하기");
			System.out.println("[ 0 ] 뒤로가기");
			System.out.println("===========================================================");
			
			
		}else{
			System.out.println("  번호\t\t제목\t\t 작가");
			System.out.println("-----------------------------------------------------------");

			for(int i=0; i<bookList.size(); i++){
				System.out.println(String.format("[%2d ]  %-20s\t%-15s\t  ", i+1, 
						bookList.get(i).getBook_name(), bookList.get(i).getAuthor()));
			}
			System.out.println("-----------------------------------------------------------");
			if(bookList.size() == 1){
				
			}else{
				System.out.println("[ 1 ~ " + (bookList.size()) + " ] 상세보기 선택");
			}
			System.out.println("[ 0 ] 뒤로가기");
			System.out.println("===========================================================");
		}
	}
	
	
	/**
	 *  대여하기 - 사용자 메서드
	 * @param book_seq
	 * 	
	 *  rentList에 저장하여 유저가 확인할 수 있어야함
	 * @return 성공 시  true, 실패 시 false
	 * @author 홍유리
	 */
	//DB rentList
	//@para - bookList - book_seq를 받아 rentList에 저장하여 유저가 확인할 수 있어야함
	//@return - 성공시 true, 실패 시 false
	private void rentBook(){
		String message = "";
			System.out.println("대출 수행");
			System.out.println("대여해주셔서 감사합니다.");
		
	}	

	
/////////////////////////////////////////////////////////////////////////////
//					관리자
/////////////////////////////////////////////////////////////////////////////	
	
	
	/**
	 * 관리자 메인 뷰
	 * 
	 * @author 김대호
	 * 
	 */
	private void adminMainView(){
		String message = "";
		while (true) {
			System.out.println("=======================");
			System.out.println("[ 1 ] 대출 목록 조회");
			System.out.println("[ 2 ] 보유도서 조회");
			System.out.println("[ 3 ] 회원 목록 조회");
			System.out.println("[ 4 ] 공지 목록 조회 ");
			System.out.println("[ 5 ] 이용권 조회 조회");
			System.out.println("[ 6 ] 매출 조회");
			System.out.println("[ 0 ] 로그아웃");
			System.out.println("=======================");
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
				readAllBook();
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

		System.out.println("=====================================");
		System.out.println("                          대출 목록 조회");
		System.out.println("-------------------------------------");
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

			System.out.print(rentInfo.getRent_seq() + "   ");
			System.out.print(rentInfo.getUser_Id() + "   ");
			System.out.print(selBook.getBook_name() + "   ");
			System.out.println(rentInfo.getRent_date());
		}
		
		while(true){
			System.out.println("-------------------------------------");
			System.out.println("[ 0 ] 뒤로가기");
			System.out.println("=====================================");
			
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
	private void readAllBook(){
	//DB
	//List<BookVO> readAllBook();
	//@param
	//@return 보유 책 리스트	
		while(true){
			List<BookVO> bookList = iServiceImpl.readAllBook();
			bookListView(bookList);
			
			int input = iInput();
			BookVO selBook;
			
			if(input == 0){
				return;
			}else if(input == 1){
				addBook();
			}else if(1 < input && input < bookList.size()+2){
				selBook = iServiceImpl.bookSelector(bookList.get(input-2).getBook_seq());
				bookDetailView(selBook);
			}else{
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
		}
	}
	
	
	/**
	 * 선택한 책 상세  정보 - 관리자 메서드
	 * 관리자 모드, 사용자 모드에 따라 다른 선택문
	 * @author 김대호
	 */
	private void bookDetailView(BookVO selBook){
	//DB
	//BookVO bookDetailView(int book_req);
	//@param 선택한 책  seq
	//@return 선택한 책 객체
		while(true){
		
			System.out.println("==========================");
			System.out.println("     " + selBook.getBook_name() + " 상세정보");
			System.out.println("==========================");
			
			List<BookKindVO> kindList = iServiceImpl.readAllKind();
			System.out.println("제목 : " + selBook.getBook_name());
			System.out.println(String.format("작가 : " + selBook.getAuthor()));
			for(BookKindVO kind : kindList){
				if(kind.getGenre_seq() == selBook.getG_seq()){
					System.out.println("장르 : " + kind.getGenre_name());
					break;
				}
			}
			System.out.println("등록일 : " + selBook.getRegDate());
			
			selectView(selBook);
			return;
		}
	}
	
	
	/**
	 * 선택한 책 상세  정보 선택 메서드 - 관리자 메서드
	 * 
	 * 
	 * @author 김대호
	 */
	void selectView(BookVO selBook){
		while(true){
			
			if(user == null){
				System.out.println("--------------------------");
				System.out.println("[ 1 ] 수정");
				System.out.println("[ 2 ] 삭제");
				System.out.println("[ 0 ] 뒤로가기");
				System.out.println("==========================");
				
				switch (iInput()) {
				case 0:
					// 이전 페이지로 돌아가기
					return;
				case 1:
					// 도서 수정
					modifyBook(selBook);
					return;
				case 2:
					// 도서 삭제
					deleteBook(selBook);
					return;
				default:
					System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
				}
			}else{
				System.out.println("--------------------------");
				System.out.println("[ 1 ] 만화보기(대여)");
				System.out.println("[ 0 ] 뒤로가기");
				System.out.println("==========================");
				
				switch (iInput()) {
				case 0:
					// 이전 페이지로 돌아가기
					return;
				case 1:
					addBookRent(selBook);
					return;
				default:
					System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
				}
			}
		}
	}

	
	
	/**
	 * 선택한 책대여(RentVO 추가) - 관리자 메서드
	 * 
	 * 
	 * @author 김대호
	 */
	void addBookRent(BookVO selBook){
		Map<String, Object> infoList = new HashMap<>();
		if(!(iServiceImpl.checkUserInfo(user.getUser_id()))){
			System.out.println("유효한 이용권이 없습니다.");
			return;
		}
		
		infoList.put("selBook", selBook);
		infoList.put("user", user);
		if(iServiceImpl.rentBook(infoList)){
			System.out.println("대여가 완료 되었습니다");
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
			book.setBook_seq();
			System.out.println("추가할 책 정보를 입력하세요");
			System.out.print("책이름 : ");		
			String bookName = sInputs();
			book.setBook_name(bookName);
			
			System.out.print("저자 : ");		
			String auther = sInputs();
			book.setAuthor(auther);
			
			System.out.println("장르 번호 선택 ");
			book.setG_seq(selectGenre());
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
			Calendar cal = Calendar.getInstance();
			String date = simpleDateFormat.format(cal.getTime());
			book.setRegDate(date);

			if(iServiceImpl.addBook(book)){
				System.out.println(book.getBook_name() + "을 추가하였습니다");
			}else{
				System.out.println(book.getBook_name() + "을 추가 하지 못했습니다");
			}
			
			System.out.println();
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
	
//////////////////////////////////////////////////////////////////////////////////////////////
//	수정
//////////////////////////////////////////////////////////////////////////////////////	
	/**
	 * 책추가 장르 선택 - 관리자 메서드
	 * 
	 * @author 김대호
	 */
	int selectGenre(){
		while(true){
			List<BookKindVO> genreList = iServiceImpl.readAllKind();
			for(BookKindVO kind : genreList){
				System.out.print("[" + kind.getGenre_seq() + "] " + kind.getGenre_name() + "   ");
			}
			System.out.println();
			int genre = iInput();
			if(0 < genre && genre < 6){
				return genre;
			}
			System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
		}
	}
//////////////////////////////////////////////////////////////////////////////////////////////
//수정 끝
//////////////////////////////////////////////////////////////////////////////////////	
	
	
	/**
	 * 보유 도서 수정 - 관리자 메서드
	 * 
	 * @author 김대호
	 */
	private void modifyBook(BookVO selBook){
	//DB
	//boolean modifyBook(Map<String, Object> bookInfo)
	//@param 수정할 정보 Map으로 전달
	//@return 수정 성공시 true, 실패 시 false반환
	
		while(true){

			Map<String, Object> modifyInfo = new HashMap<>();
			modifyInfo.put("book", selBook);
			
			System.out.println("[ 1 ] 제목");
			System.out.println("[ 2 ] 작가");
			System.out.println("[ 3 ] 장르");
			System.out.println("[ 0 ] 뒤로가기");
			
			switch (iInput()) {
			case 0:
				// 이전 페이지로 돌아가기
				return;
			case 1:
				// 제목 수정
				System.out.println("수정할 제목을 입력하세요");
				modifyInfo.put("name", sInputs());
				iServiceImpl.modifyBook(modifyInfo);
				return;
			case 2:
				// 작가 수정
				System.out.println("수정할 작가명을 입력하세요");
				modifyInfo.put("auther", sInputs());
				iServiceImpl.modifyBook(modifyInfo);
				return;
			case 3:
				// 장르 수정
				System.out.println("수정할 장르명을 입력하세요");
				modifyInfo.put("genre", iInput());
				iServiceImpl.modifyBook(modifyInfo);
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
	
	private void deleteBook(BookVO selBook){
	//DB
	//boolean deleteBook(int book_seq);
	//@param 선택한 책 seq 전달
	//@return 삭제 성공시 true, 실패 시 false반환
		while(true){
			
			System.out.println("[ 1 ] 책 비활성화");
			System.out.println("[ 2 ] 책 삭제");
			System.out.println("[ 0 ] 뒤로가기");
			
			switch (iInput()) {
			case 0:
				// 이전 페이지로 돌아가기
				return;
			case 1:
				// 책 비활성화
				selBook.setBook_isActivate(false);
				System.out.println("책을 비활성화 하였습니다");
				return;
			case 2:
				// 책 삭제
				if(iServiceImpl.deleteBook(selBook)){
					System.out.println("책을 삭제하였습니다");
					return;
				}
				System.out.println("책을 삭제하지 못했습니다.");
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
			
			List<UserVO> userList;
			userList = iServiceImpl.readAllUser();
			System.out.println("=======================================");
			System.out.println("  No   이름                      아이디                  포인트");
			System.out.println("---------------------------------------");
//			for(UserVO user : userList){
			for(int i=0; i<userList.size(); i++){
				System.out.print("  " + (i+1) + "   ");
				System.out.print(String.format("%-10s           ", userList.get(i).getUser_name()));
				System.out.print(String.format("%-12s", userList.get(i).getUser_id()));
				System.out.println(String.format("%7s", userList.get(i).getUser_point()));
			}
			System.out.println("---------------------------------------");
			System.out.println("[ 0 ] 뒤로가기");
			System.out.println("=======================================");
			
			int input = iInput();
			if(input == 0){
				
				// 이전 페이지로 돌아가기
				return;
			}else if(0 < input && input < userList.size()+1){
				userDetailView(input);
			}else{
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
		}
	}
	
	
	/**
	 * 선택한 회원 상세 조회 - 관리자 메서드
	 * 
	 * @author 김대호
	 */
	private void userDetailView(int selNum){
	//DB
	//UserVO userDetailView(String user_id);
	//@param 선택한 유저 id
	//@return 선택한 유저 정보

		while(true){
			List<UserVO> userList;
			userList = iServiceImpl.readAllUser();
			System.out.println("============================");
			System.out.println("\t" + userList.get(selNum-1).getUser_name() + "님 상세 정보" );
			System.out.println("----------------------------");
				
			
			System.out.println(String.format("이름 : %-10s", userList.get(selNum-1).getUser_name()));
			System.out.println(String.format("아이디 : %-12s", userList.get(selNum-1).getUser_id()));
			System.out.println(String.format("비밀번호 : %-15s", userList.get(selNum-1).getUser_pw()));
			System.out.println(String.format("포인트 : %7d", userList.get(selNum-1).getUser_point()));
			
			System.out.println("----------------------------");
			System.out.println("[ 0 ] 뒤로가기");
			System.out.println("============================");
			
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
			
			List<NotifyVO> notifyList = iServiceImpl.readAllNotify();
			System.out.println("==============================================================");
			System.out.println(" No                   제목                                   조회수           작성일");
			System.out.println("--------------------------------------------------------------");
			for(int i=0; i<notifyList.size(); i++){
				System.out.print(notifyList.get(i).getNotify_seq() + "  ");
				System.out.print(String.format("[%2d ] \t%-30s\t\t%6d    %-10s\n", 
						i+2, notifyList.get(i).getNotify_title(), notifyList.get(i).getReadCount(), notifyList.get(i).getNotify_date()));
			}
			System.out.println("--------------------------------------------------------------");
			System.out.println("[ 1 ] 공지 추가 하기");
			System.out.println("[ 0 ] 뒤로가기");
			System.out.println("==============================================================");
	
			int input = iInput();
			if(input == 0){
				// 이전 페이지로 돌아가기
				return;
			}else if(input == 1){
				addNotify();
			}else if(1 < input && input < notifyList.size()+2){
				notifyDetailView(input-1);
			}else{
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
		}
		
	}
	
	
	/**
	 * 선택한 공지 상세 조회 - 관리자 메서드
	 * 
	 * @author 김대호
	*/
	private void notifyDetailView(int selNum){
	//DB
	//NotifyVO notifyDetailView(int notify_seq);
	//@param 선택한 공지사항 seq 전달
	//@return 선택한 공지 객체 가져오기 
		while(true){
			
			NotifyVO notify;
			notify = iServiceImpl.notifySelector(selNum);
			
			System.out.println("================================================");
			System.out.print(notify.getNotify_title() + "\t\t");
			System.out.print(notify.getReadCount() + "\t");
			System.out.println(notify.getNotify_date());
			System.out.println("------------------------------------------------\n\n");
			
			System.out.println(notify.getContents());
			
			System.out.println("\n\n------------------------------------------------");
			System.out.println("[ 1 ] 수정");
			System.out.println("[ 2 ] 삭제");
			System.out.println("[ 0 ] 뒤로가기");
			System.out.println("================================================");
			
			switch (iInput()) {
			case 0:
				// 이전 페이지로 돌아가기
				return;
			case 1:
				// 수정
				modifyNotify(notify);
				return;
			case 2:
				// 삭제
				deleteNotify(notify);
				return;
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

			NotifyVO notify = new NotifyVO();
			System.out.println("추가할 공지사항 정보를 입력하세요");
			notify.setNotify_seq();

			System.out.print("제목 : ");		
			String title = sInputs();
			notify.setNotify_title(title);
			
			System.out.print("내용 : ");		
			String contents = sInputs();
			notify.setContents(contents);
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
			Calendar cal = Calendar.getInstance();
			String date = simpleDateFormat.format(cal.getTime());
			notify.setNotify_date(date);

			if(iServiceImpl.addNotify(notify)){
				System.out.println("공지를 추가하였습니다");
			}else{
				System.out.println("공지를 추가 하지 못했습니다");
			}
			
			System.out.println();
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
	 * 공지 수정 - 관리자 메서드
	 * 
	 * @author 김대호
	 */
	private void modifyNotify(NotifyVO notify){
	//DB
	//boolean modifyNotify(Map<String, Object> modifyInfo);	
	//@param 수정할 정보 Map으로 전달
	//@return 수정 성공시 true, 실패 시 false반환
		while(true){
			
			Map<String, Object> modifyInfo = new HashMap<>();
			modifyInfo.put("notify", notify);
			
			System.out.println("[ 1 ] 제목");
			System.out.println("[ 2 ] 내용");
			System.out.println("[ 0 ] 뒤로가기");
			
			boolean isModify=false;
			switch (iInput()) {
			case 0:
				// 이전 페이지로 돌아가기
				return;
			case 1:
				// 제목 수정
				System.out.println("수정할 제목을 입력하세요");
				modifyInfo.put("title", sInputs());
				isModify = iServiceImpl.modifyNotify(modifyInfo);
				return;
			case 2:
				// 내용 수정
				System.out.println("수정할 내용을 입력하세요");
				modifyInfo.put("content", sInputs());
				isModify = iServiceImpl.modifyNotify(modifyInfo);
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
			if(isModify){
				System.out.println("공지를 수정하였습니다");
			}else{
				System.out.println("공지를 수정하지 못했습니다.");
			}
		}
	}
	
	
	/**
	 * 공지 삭제 - 관리자 메서드
	 * 
	 * @author 김대호
	 */
	private void deleteNotify(NotifyVO notify){
	//DB
	//boolean deleteNotify(Notify notify);
	//@param 선택한 공지 객체 전달
	//@return 삭제 성공시 true, 실패 시 false반환
		if(iServiceImpl.deleteNotify(notify)){
			System.out.println("공지 삭제를 완료하였습니다");
			return;
		}
			System.out.println("공지를 삭제하지 못했습니다.");
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
			List<VoucherVO> voucherList = iServiceImpl.readAllVoucher();
			System.out.println("==============================================================");
			System.out.println(" No  이용권이름      유요일수        가격");
			System.out.println("--------------------------------------------------------------");
			for(int i=0; i<voucherList.size(); i++){
				System.out.println(String.format("[%2d ]  %-8s\t%8s\t%10s  " , i+2, 
						voucherList.get(i).getV_name(), voucherList.get(i).getV_period()+"일"
												, voucherList.get(i).getV_price()+"원"));
			}
			System.out.println("--------------------------------------------------------------");
			System.out.println("[ 1 ] 이용권 추가 하기");
			if(voucherList.size() == 1){
				System.out.println("[ 2 ] 상세보기 선택");
			}else{
				System.out.println("[ 2 ~ " + (voucherList.size()+1) + " ] 상세보기 선택");
			}
			System.out.println("[ 0 ] 뒤로가기");
			System.out.println("==============================================================");
			System.out.println();
	
			int num = iInput();
			if(num == 0){
				return;
			}else if(num == 1){
				addVoucher();
			}else if(1 < num && num < voucherList.size()+2){
				VoucherVO selVoucher = iServiceImpl.voucherSelector(voucherList.get(num-2).getV_seq());
				voucherDetailView(selVoucher);
			}else{
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
			VoucherVO voucher = new VoucherVO();
			voucher.setV_seq();
			System.out.println("추가할 이용권 정보를 입력하세요");
			System.out.println("이용권 : ");
			String voucherName = sInput();
			voucher.setV_name(voucherName);
			System.out.println("기간 : ");
			int voucherPeriod = iInput();
			voucher.setV_period(voucherPeriod);
			System.out.println("가격 : ");
			int voucherPrice = iInput();
			voucher.setV_price(voucherPrice);
			
			if(iServiceImpl.addVoucher(voucher)){
				System.out.println(voucher.getV_name() + "을 추가하였습니다");
			}else{
				System.out.println(voucher.getV_name() + "을 추가 하지 못했습니다");
			}
			
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
	private void voucherDetailView(VoucherVO selVoucher){
	//DB
	//VoucherVO voucherDetailView(int voucher_seq);
	//@param 선택한 이용권 seq 전달 
	//@return 선택한 이용권 객체 
		while(true){
			
//			VoucherVO voucher;
//			voucher = iServiceImpl.voucherSelector(selVoucher);
			List<VoucherVO> voucherList = iServiceImpl.readAllVoucher();
			System.out.println("==========================");
			System.out.println("     " + selVoucher.getV_name() + " 상세정보");
			System.out.println("--------------------------");
			System.out.println("이용권 : " + selVoucher.getV_name());
			System.out.println("기간 : " + selVoucher.getV_period());
			System.out.println("가격 : " +selVoucher.getV_price());
			
			System.out.println("--------------------------");
			System.out.println("[ 0 ] 뒤로가기");
			System.out.println("[ 1 ] 이용권 수정 하기");
			System.out.println("[ 2 ] 이용권 상세 정보 조회하기");
			System.out.println("==========================");
			
			switch (iInput()) {
			case 0:
				// 이전 페이지로 돌아가기
				return;
			case 1:
				// 이용권 수정
				modifyVoucher(selVoucher);
				return;
			case 2:
				// 이용권 삭제
				deleteVoucher(selVoucher);
				return;
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
	private void modifyVoucher(VoucherVO selVoucher){
	//DB
	//boolean modifyVoucher(Map<String, Object> voucherInfo);
	//@param 수정할 이용권 정보 Map으로 전달 
	//@return 수정 성공시 true, 실패 시 false반환
		while(true){
			Map<String, Object> voucherInfo = new HashMap<>();
			voucherInfo.put("voucher", selVoucher);
			
			System.out.println("[ 1 ] 이용권 이름");
			System.out.println("[ 2 ] 기간");
			System.out.println("[ 3 ] 가격");
			System.out.println("[ 0 ] 뒤로가기");
			
			switch (iInput()) {
			case 0:
				// 이전 페이지로 돌아가기
				return;
			case 1 :
				//이용권 이름 수정
				System.out.println("수정할 이용권 이름을 입력하세요");
				voucherInfo.put("name",sInput());
				iServiceImpl.modifyVoucher(voucherInfo);
				return;
			case 2 :
				//기간 수정
				System.out.println("수정할 기간을 입력하세요");
				voucherInfo.put("period",sInput());
				iServiceImpl.modifyVoucher(voucherInfo);		
				return;
			case 3 :
				//가격 수정
				System.out.println("수정할 가격을 입력하세요");
				voucherInfo.put("price",sInput());
				iServiceImpl.modifyVoucher(voucherInfo);		
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
	private void deleteVoucher(VoucherVO selVoucher){
	//DB
	//boolean deleteVoucher(int voucher_seq); 
	//@param 삭제할 이용권 seq 전달 
	//@return 삭제 성공시 true, 실패 시 false 반환
		while(true){
			List<VoucherVO> voucherList = iServiceImpl.readAllVoucher();
			
			System.out.println("[ 1 ] 이용권 비활성화");
			System.out.println("[ 2 ] 이용권 삭제");
			System.out.println("[ 0 ] 뒤로가기");
			
			switch (iInput()) {
			case 0:
				// 이전 페이지로 돌아가기
				return;
			case 1 :
				//이용권 비활성화
				selVoucher.setActivate(false);
				System.out.println("책을 비활성화 하였습니다.");
			
				return;
			case 2 :
				//이용권 삭제
				if(iServiceImpl.deleteVoucher(selVoucher)){
					System.out.println("책을 삭제하였습니다.");
				}
				System.out.println("책을 삭제하지 못했습니다.");
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
			System.out.println("[ 0 ] 뒤로가기");
			System.out.println("[ 1 ] 일매출 보기");
			System.out.println("[ 2 ] 월매출 보기");
	
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
			
			List<UserInfoVO> dailyList = iServiceImpl.dailySalesView();
			String todayDate = getTodayDate();
			System.out.println();
			System.out.println(todayDate + "  일 매출");
			System.out.println("=============================================================");
			System.out.println(" No       사용자                       이용권                    구매일                가격");
			System.out.println("-------------------------------------------------------------");
			
			int sum = 0;
			for(int i=0; i<dailyList.size(); i++){
				
				int selVoucher = dailyList.get(i).getv_seq(); //선택한 voucher seq
				VoucherVO voucher = iServiceImpl.voucherSelector(selVoucher);
				sum += voucher.getV_price();	
				System.out.print(String.format("[%2d ] \t%-10s\t%5s\t%15s\t%8d", 
						i+1, dailyList.get(i).getUser_id(), voucher.getV_name(), 
						dailyList.get(i).getBuy_date(), voucher.getV_price()));
				System.out.println("원");
			}
			System.out.println("-------------------------------------------------------------");
			System.out.println("\t\t\t\t\t\t일매출 : " + sum + "원");
			System.out.println("=============================================================");
			System.out.println("[ 0 ] 뒤로가기");
			System.out.println("=============================================================");
			
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
	 * 월별 매출 조회 - 관리자 메서드
	 * 
	 * @author 김대호
	 */
	private void monthlySalesView(){
	//DB
	//List<UserInfoVO> monthlySalesView();
	//@param
	//@return 월별매출 리스트(유저정보)
	
		while(true){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
			Calendar cal = Calendar.getInstance();
			String date = simpleDateFormat.format(cal.getTime());
			
			System.out.println();
			System.out.println(date.substring(0,4) + "년 월별 매출");
			System.out.println("==========================");
			System.out.println("   월                                매출");
			System.out.println("--------------------------");
			
			Map<Integer, Integer> monthlyList = iServiceImpl.monthlySalesView();
			int year_sum = 0; //해당년도 매출 합계
			for(int i=0; i<monthlyList.size(); i++){
				System.out.println(String.format(" %2d\t\t%7d원", 
						i+1, monthlyList.get(i+1)));
				year_sum += monthlyList.get(i+1);
			}
			System.out.println("--------------------------");
			System.out.println("                     매출합계 : " + year_sum + "원");
			System.out.println("==========================");
			System.out.println("[ 1 ~ " + monthlyList.size() + " ] 월 상세보기");
			System.out.println("[ 0 ] 뒤로가기");
			System.out.println("==========================");
	
			int input = iInput();
			BookVO selBook;
			
			if(input == 0){
				return;
			}else if(0 < input && input < monthlyList.size()+1){
				monthDetailView(input);
			}else{
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
		}
	}

	
	/**
	 * 월 매출 상세 조회 - 관리자 메서드
	 * 
	 * @author 김대호
	 */
	private void monthDetailView(int month){
	//DB
	//List<UserInfoVO> monthDetailView();
	//@param
	//@return 
	
		while(true){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
			Calendar cal = Calendar.getInstance();
			String date = simpleDateFormat.format(cal.getTime());
			
			int month_sum = 0; //해당월 매출 합계
			List<UserInfoVO> monthList = iServiceImpl.readMonthDetail(month);
			
			System.out.println( date + "  월 상세 매출");
			System.out.println("=============================================================");
			System.out.println(" No       사용자                       이용권                    구매일                가격");
			System.out.println("-------------------------------------------------------------");
			
			for(int i=0; i<monthList.size(); i++){
				int selVoucher = monthList.get(i).getv_seq(); //선택한 voucher seq
				VoucherVO voucher = iServiceImpl.voucherSelector(selVoucher);
				month_sum += voucher.getV_price();	
				System.out.print(String.format("[%2d ] \t%-10s\t%5s\t%15s\t%8d원\n", 
						i+1, monthList.get(i).getUser_id(), voucher.getV_name(), 
						monthList.get(i).getBuy_date(), voucher.getV_price()));
			}
			System.out.println("-------------------------------------------------------------");
			System.out.println("\t\t\t\t\t\t일매출 : " + month_sum + "원");
			System.out.println("=============================================================");
			System.out.println("[ 0 ] 뒤로가기");
			System.out.println("=============================================================");
			
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
