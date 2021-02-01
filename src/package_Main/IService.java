package package_Main;

import java.util.List;
import java.util.Map;

import package_VO.BookKindVO;
import package_VO.BookVO;
import package_VO.NotifyVO;
import package_VO.RentVO;
import package_VO.UserInfoVO;
import package_VO.UserVO;
import package_VO.VoucherVO;

public interface IService {
	
	/**
	 * 
	 * 회원가입 - 유저 정보 DB에 입력
	 * 
	 * @param user 유저한명의 정보
	 * @return 성공 시 true, 실패 시 false 반환
	 * @author 조유진
	 */
	boolean addUser(UserVO user);
	
	/**
	 * 
	 * id 중복 여부와 조건을 만족하는지 확인
	 * 
	 * @param user_id
	 * @return 만족하면 true, 불만족하면 false 반환
	 * @author 조유진
	 * 
	 */
	boolean checkId(String id);
	
	/**
	 * 
	 * 관리자 계정 로그인
	 * 
	 * @param loginInfo - admin_id 아이디, admin_pw 비밀번호
	 * @return 로그인 성공 시 true, 실패 시 false 반환
	 * @author 조유진
	 */
	boolean adminLogin(Map<String, String> loginInfo);
	
	/**
	 * 회원 계정 로그인
	 * 
	 * @param loginInfo - user_id 유저의 아이디, user_pw 유저의 비밀번호
	 * @return 로그인 성공 시 true, 실패 시 false 반환
	 * @author
	 */
	UserVO userLogin(Map<String, String> loginInfo); //반환타입
	
	
	
	
////////////////////////////////////////////////////////////////////////
//고객
////////////////////////////////////////////////////////////////////////


	/**
	 * 고객 업데이트 - 이름, 비밀번호, 포인트 수정
	 * @param userInfo
	 * @return 성공 시 1, 실패 시 0
	 */
	public int userUpdate(Map<String, Object> userInfo);
	

	/**
	 * 회원 탈퇴 - 사용자 메서드
	 * @param actInfo
	 * @return
	 * @author 홍유리
	 */
	boolean deleteUser(String user_Id);
	
	
	
	
	/**
	* 대여 목록 조회 - 사용자 메서드
	* @param user_id
	* @return 대여한 책 목록을 반환.
	* 			
	* @author 홍유리
	*/
	List<RentVO> rentListView(String user_id); //매개변수 user_id
	
	/**
	* 대여 목록 상세 조회 - 사용자 메서드
	* @param rent_seq
	* rent_seq에 담겨있는 book_seq를 통해 책의 정보를 읽을 수 있음
	* @return 
	* @author 홍유리
	*/
	List<RentVO> rentBookDetail(RentVO rent_seq);
	
	/**
	* 평점 달기 - 사용자 메서드
	* (평점을 입력하면 bookList와 userInfoList의 grade, user_grade에 저장되어야한다)
	* @param rent_grade
	* @return 성공  시 true, 실패시 false
	* @author 홍유리
	*/
	
	int giveGrade(int grade); //매개변수
	
	/**
	* 
	* 평점 수정 - 사용자 메서드
	* 
	* @param rentInfo
	* @return 성공 시 true, 실패 시 false
	* @author 홍유리
	*/
	
	boolean modifyGrade(Map<String, Object> rentInfo);
	
	/**
	* 평점 삭제 - 사용자 메서드
	* @param rentInfo
	* @return 성공 시 true, 실패 시 false
	* @author 홍유리
	*/
	boolean removeGrade(Map<String, Object> rentInfo);
	
	/**
	* 금액 충전- 사용자 메서드
	* @param point 기존 금액과 충전한 금액의 합
	* @return
	* @author 홍유리
	*/
	int chargePoint(Map<String, Object> userobj); // 누구의 얼마만큼(매개변수), 반환타입
	/**
	* 모든 공지 조회
	* @return 공지사항 전체 리스트를 반환
	* @author 홍유리
	*/
	List<NotifyVO> userNotifyView();
	
	/**
	* 유저 공지 상세 조회
	* @param notify_seq
	* @return 선택한 공지 내용을 반환
	* @author 홍유리
	*/
	List<NotifyVO> userNotifyDetail(int notify_seq);
	
	/**
	* 신간도서 보기 - 사용자 메서드
	* bookList의 end index로부터 3~5개의 seq를 추출하여 보여줌
	* 읽기 기능 외 기능 없음
	* @param book_seq
	* @return
	* @author 홍유리
	*/
	List<BookVO> newBookView();
	
	/**
	* 인기도서 보기 - 사용자 메서드
	* rentList에 중복된 book_seq의 개수를 합산하여 가장 높은 순서대로 3위까지 추출함
	* 읽기 기능 외 기능 없음
	* @param book_seq
	* @return
	* @author 홍유리
	*/
	List<RentVO> popularBookView(BookVO book_seq);
	
	/**
	* 유저가 소유한 이용권 보기 - 사용자 메서드
	* 보기만 가능
	* 사용자가 소유한 이용권 내역 확인- 
	* userInfoList에서 buyDate별로 지정된 v-seq를 이용 + activate 여부 확인 가능하게
	* @param user_id
	* @return
	* @author 홍유리
	*/
	
	List<UserInfoVO> userVoucher(String user_id);
	
	/**
	* 유저의 이용권 상세보기 - 사용자 메서드
	* 보기만 가능
	* @param v_seq
	* @return
	* @author 홍유리
	*/
	List<VoucherVO> userVoucherDetail(VoucherVO v_seq);
	
	
	/**
	* 이용권 구매 - 사용자 메서드
	* voucherList에서 price 이용해서 구매
	* @author 홍유리
	* @param v_seq
	* @return 성공 시 true, 실패시 false 반환
	*/
	
	boolean buyVoucher(int v_seq);
	
	
/////////////////////////////////////////////////////////////////////////////
//kdh
//////////////////////////////////////////////////////////////////////////////	
	
	/**
	* 책 제목으로 책 검색 - 사용자 메서드 
	* @param searchName
	* @return 입력받은 String 으로 필터링한 책목록
	* @author  김대호
	*/
	
	List<BookVO> searchBookName(String searchName);
	
	/**
	* 작가로 책 검색 - 사용자 메서드
	* 
	* @param searchAuthor
	* @return 입력받은 String 으로 필터링한 책목록 
	* @author  김대호
	*/
	
	List<BookVO> searchBookAuthor(String searchAuthor);
	
	/**
	* 장르로 책 검색 - 사용자 메서드
	* @param searchGenre
	* @return 입력받은 String 으로 필터링한 책목록
	* @author  김대호
	*/
	
	List<BookVO> searchBookGenre(int genre_seq);
	
	/**
	* 장르로 책 검색 - 사용자 메서드
	* @param searchGenre
	* @return 입력받은 String 으로 필터링한 책목록
	* @author  김대호
	*/
	boolean checkUserInfo(String user_id);
	
	
	/**
	*  대여하기 - 사용자 메서드
	* @param book_seq
	* 	
	*  rentList에 저장하여 유저가 확인할 수 있어야함
	* @return 성공 시  true, 실패 시 false
	* @author 김대호
	*/
	boolean rentBook(Map<String, Object> infoList);
	
	
	////////////////////////////////////////////////////////////////////////
	//관리자
	////////////////////////////////////////////////////////////////////////
	
	/**
	* 대출 목록 조회
	* 
	* @return 모든 대여 리스트 반환
	* @author 김대호
	*/	
	List<RentVO> readRentList();
	
	
	/**
	* 
	* 모든 보유 도서 조회
	* 
	* @return 보유 책 리스트
	* @author 김대호
	*/
	List<BookVO> readAllBook();
	
	
	/**
	* 
	* 도서 추가
	* 
	* @param 추가할 책 객체 -> get메소드 활용 책속성 설정 
	* @return 책 추가 성공시 true, 실패 시 false반환
	* @author 김대호
	*/
	boolean addBook(BookVO book);
	
	
	/**
	* 
	* 선택한 책 상세 정보
	* 
	* @param 선택한 책  seq
	* @return 선택한 책 객체
	* @author 김대호
	*/
	BookVO bookSelector(int book_seq);
	
	/**
	* 
	* 선택한 도서 수정
	* 
	* @param 수정할 정보 Map으로 전달(매개변수에 있는 정보 DB에서 수정)
	* @return 수정 성공시 true, 실패 시 false반환
	* @author 김대호
	*/
	boolean modifyBook(Map<String, Object> bookInfo); 
	
	
	/**
	* 
	* 선택 도서 제거
	* 
	* @param 선택한 책 전달
	* @return 보유 책 삭제는 비활성화로 성공시 true, 실패 시 false반환
	* @author 김대호
	*/
	boolean deleteBook(BookVO selBook);
	
	
	/**
	* 
	* 회원 목록 조회
	* 
	* @return 모든 유저 리스트
	* @author 김대호
	*/
	List<UserVO> readAllUser();
	
		
	/**
	* 
	* 선택한 회원 상세 조회
	* 
	* @param 선택한 유저 id
	* @return 선택한 유저 정보
	* @author 김대호
	*/
	UserVO userDetailView(String user_id);
	
	
	/**
	* 
	* 모든 공지 조회 
	* 
	* @return 모든 공지 리스트 조회
	* @author 김대호
	*/
	List<NotifyVO> readAllNotify();
	
	
	/**
	* 
	* 공지 추가
	* 
	* @param 추가할 공지 객체 전달
	* @return 공지 추가 성공시 true, 실패 시 false반환
	* @author 김대호
	*/
	boolean addNotify(NotifyVO notify);
	
	
	/**
	* 
	* 선택한 공지 상세 조회
	* 
	* @param 선택한 공지사항 seq 전달
	* @return 선택한 공지 객체 가져오기 
	* @author 김대호
	*/
	NotifyVO notifyDetailView(int notify_seq);
	
	
	/**
	* 
	* 공지 수정
	* 
	* @param 수정할 정보 Map으로 전달(수정할 정보에 따라  DB에서 확인 후 수정)
	* @return 수정 성공시 true, 실패 시 false반환
	* @author 김대호
	*/
	boolean modifyNotify(Map<String, Object> notifyInfo);	
	
	/**
	* 
	* 공지 삭제
	* 
	* @param 선택한 공지 객체 전달
	* @return 삭제 성공시 true, 실패 시 false반환
	* @author 김대호
	*/
	boolean deleteNotify(NotifyVO notify);
	
	
	/**
	 * 
	 * 선택한 공지 가져오기
	 * 
	 * @param 선택한 공지 seq
	 * @return 성공시 Notify객체 반환, 없을 시 null반환
	 * @author 김대호
	 */
	NotifyVO notifySelector(int selNum);
	
	
	
	/**
	* 
	* 모든 이용권 조회
	* 
	* @return 모든 이용권 리스트 
	* @author 김대호
	*/
	List<VoucherVO> readAllVoucher();
	
	
	/**
	* 
	* 이용권 추가
	* 
	* @param 추가할 이용권 객체 전달 
	* @return 추가 성공시 true, 실패 시 false반환
	* @author 김대호
	*/
	boolean addVoucher(VoucherVO voucher);
	
	
	/**
	* 
	* 선택한 이용권 상세 보기 
	* 
	* @param 선택한 이용권 seq 전달 
	* @return 선택한 이용권 객체 
	* @author 김대호
	*/
	VoucherVO voucherDetailView(int voucher_seq);
	
	
	/**
	* 
	* 선택한 이용권 수정
	* 
	* @param 수정할 이용권 정보 Map으로 전달(수정할 정보 전달하여 DB에서 확인하고 수정)
	* @return 수정 성공시 true, 실패 시 false반환
	* @author 김대호
	*/
	boolean modifyVoucher(Map<String, Object> voucherInfo);
	
	/**
	 * 선택한 이용권 가져오기
	 * @param selVoucher
	 * @return
	 */
	VoucherVO voucherSelector(int selVoucher);
	
	/**
	* 
	* 선택한 이용권 삭제
	* 
	* @param 삭제할 이용권 seq 전달 
	* @return 비활성화 성공시 true, 실패 시 false 반환
	* @author 김대호
	*/
	boolean deleteVoucher(VoucherVO selVoucher);
	
	
	/**
	* 
	* 일매출 조회(일 이용권 내역 및 일매출 출력)
	* 
	* @return 일매출 리스트(유저정보)	
	* @author 김대호
	*/
	List<UserInfoVO> dailySalesView();
	
	
	/**
	* 
	* 매월매출 조회(12개월 월매출 출력)
	* 
	* @param 
	* @return 월매출 리스트(유저정보)
	* @author 김대호
	*/
	Map<Integer, Integer> monthlySalesView();
	
	/**
	* 
	* 월 상세 매출 조회
	* 
	* @param 선택한 월 int
	* @return 선택한 월의 일별 매출 리스트(UserInfo)
	* @author 김대호
	*/
	List<UserInfoVO> readMonthDetail(int month);
	
	
	/**
	* 
	* 모든 장르 조회
	* 
	* @param 
	* @return 모든 이용권 리스트 
	* @author 김대호
	*/
	List<BookKindVO> readAllKind();
	
////////////////////////////////////////////////////////////////////////
//			관리자
////////////////////////////////////////////////////////////////////////
	
	
	
}
