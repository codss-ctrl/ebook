package package_Main;



import package_VO.UserVO;

public class View {
	/**
	 * 메인뷰
	 * 
	 * @author 
	 * 
	 */
	//메인
	
	
	void startMethod(){
		String message = "";
		while (true) {
			System.out.println("┌─────────────────────────────┐");
			System.out.println("| ┌──────────────────────────┐|");
			System.out.println("	   이북사이트에 오신걸 환영합니다.   ");
			System.out.println("| └──────────────────────────┘ ");
			System.out.println("└─────────────────────────────┘");
		}
	}	
	//로그인 - 관리자 main, 회원 main
	
	//회원가입 - id입력, pw 입력, name 입력, point 입력
	
	/**
	 * 관리자 메인뷰 - 관리자 메서드	
	 */
	private void adminMainView() {
		String message = "";
		while (true) {
//			showBanner("관리자 페이지");
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
		}	
//			switch () {
//			case value:
//				
//				break;
//
//			default:
//				break;
//			}
			
	}//end method
		//대출 목록 조회
		
		//보유 도서 조회-도서 추가, 상세정보 수정,삭제
		
		//회원 목록 조회- 회원 상세 조회
		
		//공지 목록 조회- 공지 추가, 상세정보 수정,삭제
		
		//이용권 조회 - 이용권 추가, 상세정보 수정, 삭제
		
		//매출 조회  -일,월,년 매출 조회
		
	/**
	 * 	회원 메인뷰 - 회원 메서드
	 */
		private void userMainView() {
			String message = "";
			while (true) {
//				showBanner("관리자 페이지");
				System.out.println("[1] 대출 목록 조회");
				System.out.println("[2] 내 정보 조회");
				System.out.println("[3] 금액 충전");
				System.out.println("[4] 공지 조회");
				System.out.println("[5] 이용권 조회");
				System.out.println("[6]         ");
				System.out.println("[7] 로그아웃");
				System.out.println();
				System.out.println("메뉴를 선택하세요");
				if (!"".equals(message)) {
					System.out.println();
					System.out.println(message);
					message = "";
				}//end if
			}//end while
		}//end method	
			
		//공지사항 확인 - 공지상세 정보 확인
		
		//돈 충전
		
		//이용권 조회 - 이용권 구매
		
		// 도서 검색 -도서 상세 정보 보기 - 대여하기
		
		// 대여목록 조회 -대여 상세 정보 조회 - 평점달기
		
		// 내정보 수정 -이름 변경, 비밀번호 변경, 회원  탈퇴
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}


	