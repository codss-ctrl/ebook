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
	 * @author 구현자
	 */
	boolean insertUser(UserVO user);
	
	/**
	 * 
	 * id 중복 여부와 조건을 만족하는지 확인
	 * 
	 * @param id
	 * @return 만족하면 true, 불만족하면 false 반환
	 * @author
	 * 
	 */
	boolean checkId(String id);
	
	/**
	 * 
	 * 관리자 계정 로그인
	 * 
	 * @param loginInfo ??
	 * @return 로그인 성공 시 true, 실패 시 true 반환
	 * @author
	 */
	boolean adminLogin(Map<String, String> loginInfo);
	
	/**
	 * 회원 계정 로그인
	 * 
	 * @param loginInfo user_id 유저의 아이디, user_pw 유저의 비밀번호
	 * @return 로그인 성공 시
	 * @author
	 */
	boolean userLogin(Map<String, String> loginInfo); //반환타입
	
	
	
	
////////////////////////////////////////////////////////////////////////
//							고객
////////////////////////////////////////////////////////////////////////
	/**
	 * 대여 목록 조회 - 사용자 메서드
	 * @param 
	 * @return 대여한 책 목록을 반환.
	 * 			
	 * @author 홍유리
	 */
	List<RentVO> rentListView(); //매개변수 user_id
	
	/**
	 * 대여 도서 상세 보기 - 사용자 메서드
	 * @param 
	 * @return
	 * @author 홍유리
	 */
	
	List<RentVO> rentBookDetail(); // 중복메서드
	
	/**
	 * 평점 달기 - 사용자 메서드
	 * (평점을 입력하면 bookList와 userInfoList의 grade, user_grade에 저장되어야한다)
	 * @param iInput
	 * @return 성공 시 true, 실패시 false
	 * @author 홍유리 
	 */
	
	boolean giveGrade(int grade); //매개변수
	
	/**
	 * 평점 수정 - 사용자 메서드
	 * @param iInput
	 * @author 홍유리
	 * @return 성공  시 true, 실패시 false
	 */
	
	boolean modifyGrade(Map<String, Object> UserInfo);
	
	/**
	 * 평점 삭제 - 사용자 메서드
	 * @param
	 * @return 성공시 true, 실패시 false 반환
	 * @author 홍유리
	 */
	
	boolean removeGrade(Map<String, Object> UserInfo);
	
	/**
	 * 금액 충전- 사용자 메서드
	 * 
	 * @param iInput()
	 * @return 입력받은 값을 더한 총 금액 반환 (userList의 point + iInput() = int)
	 * @author 홍유리
	 */
	
	List<UserVO> chargePoint(); // 누구의 얼마만큼(매개변수), 반환타입
	
	/**
	 * 유저용 공지사항 - 사용자 메서드
	 * @param 
	 * @return 
	 * @author 홍유리
	 * 
	 */
	
	List<NotifyVO> userNotifyview();
	
	/**
	 * 신간도서 보기 - 사용자 메서드
	 * bookList의 end index로부터 3~5개의 seq를 추출하여 보여줌
	 * @author 홍유리
	 * 읽기 기능 외 기능 없음
	 */
	
	List<BookVO> newBookView();
	
	/**
	 * 인기도서 보기 - 사용자 메서드
	 * rentList에 있는 book_seq의 개수를 합산하여 가장 높은 순서대로 3위까지 추출함
	 * @author 홍유리
	 * 읽기 기능 외 기능 없음
	 */
	List<RentVO> popularBookView();
	
	/**
	 * 이용권 보기 - 사용자 메서드
	 * 사용자가 소유한 이용권 내역 확인- 
	 * userInfoList에서 buyDate별로 지정된 v-seq를 이용
		+activate 여부 확인 가능하게
	 * @author 홍유리
	 */
	
	List<UserInfoVO> voucherView();
	
	
	/**
	 * 이용권 구매 - 사용자 메서드
	 * voucherList에서 price 이용해서 구매
	 * @param v_seq(iInput)
	 * @return 구매 성공 시 true, 실패시 false 반환
	 * @author 홍유리
	 */
	
	boolean buyvoucher(int v_seq);
	
	/**
	 * 도서 검색 - 사용자 메서드
	 * @author 홍유리
	 */
	
	List<BookVO> bookView();
	
	/**
	 * 이름으로 책 검색 - 사용자 메서드 
	 * @author  홍유리
	 * @param String - bookList  bookName 
	 * @return bookList를 입력받은 String 으로 필터링한 책목록 
	 */
	
	List<BookVO> searchBookName();
	
	/**
	 * 작가로 책 검색 - 사용자 메서드
	 * @author  홍유리
	 * @param String - bookList author
	 * @return bookList를 입력받은 String 으로 필터링한 책목록 
	 */
	
	List<BookVO> searchBookAuthor();
	
	/**
	 * 장르로 책 검색 - 사용자 메서드
	 * @author  홍유리
	 * @param String - kindList genre
	 * @return bookList를 입력받은 String 으로 필터링한 책목록
	 */
	
	List<BookVO> searchBookGenre();
	
	/**
	 * 
	 * 도서 상세 보기 - 사용자 메서드
	 * @author  홍유리
	 */
	
	List<BookVO> userBookDetail();
	
	/**
	 * 대여하기 - 사용자 메서드
	 * @param - bookList - book_seq를 받아
	 *  rentList에 저장하여 유저가 확인할 수 있어야함
	 * @return - 성공시 true, 실패 시 false
	 * @author 홍유리
	 */
	List<RentVO> rentBook();
	
	
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
	* 보유 도서 조회
	* 
	* @param 
	* @return 보유 책 리스트
	* @author 김대호
	*/
	List<BookVO> readAllBook();
	
	
	/**
	* 
	* 보유 도서 조회
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
	BookVO bookDetailView(int book_req);
	
	
	/**
	* 
	* 보유 도서 수정
	* 
	* @param 수정할 정보 Map으로 전달 
	* @return 수정 성공시 true, 실패 시 false반환
	* @author 김대호
	*/
	boolean modifyBook(Map<String, Object> bookInfo); //매개변수 도서의??
	
	
	/**
	* 
	* 보유 도서 제거
	* 
	* @param 선택한 책 seq 전달
	* @return 삭제 성공시 true, 실패 시 false반환
	* @author 김대호
	*/
	boolean deleteBook(int book_seq); // list.remoe(Object obj) 반환타입
	
	
	/**
	* 
	* 회원 목록 조회
	* 
	* @param 
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
	* @param 
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
	* @param 수정할 정보 Map으로 전달
	* @return 수정 성공시 true, 실패 시 false반환
	* @author 김대호
	*/
	boolean modifyNotify(Map<String, Object> notifyInfo);	
	
	
	/**
	* 
	* 공지 삭제
	* 
	* @param 선택한 공지 seq 전달
	* @return 삭제 성공시 true, 실패 시 false반환
	* @author 김대호
	*/
	boolean deleteNotify(int notify_seq);
	
	
	/**
	* 
	* 모든 이용권 조회
	* 
	* @param 
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
	* 이용권 수정
	* 
	* @param 수정할 이용권 정보 Map으로 전달 
	* @return 수정 성공시 true, 실패 시 false반환
	* @author 김대호
	*/
	boolean modifyVoucher(Map<String, Object> voucherInfo);
	
	
	/**
	* 
	* 이용권 삭제
	* 
	* @param 삭제할 이용권 seq 전달 
	* @return 삭제 성공시 true, 실패 시 false 반환
	* @author 김대호
	*/
	boolean deleteVoucher(int voucher_seq);
	
	
	/**
	* 
	* 일매출 조회
	* 
	* @param 
	* @return 일매출 리스트(유저정보)	
	* @author 김대호
	*/
	List<UserInfoVO> dailySalesView(); // 반환타입 int
	
	
	/**
	* 
	* 월매출 조회
	* 
	* @param 
	* @return 월매출 리스트(유저정보)
	* @author 김대호
	*/
	List<UserInfoVO> monthlySalesView(); // 반환타입 int 
	
	/**
	* 
	* 연매출 조회
	* 
	* @param 
	* @return 월매출 리스트(유저정보)
	* @author 김대호
	*/
	List<UserInfoVO> annualSalesView();
	
	
	/**
	* 
	* 모든 장르 조회
	* 
	* @param 
	* @return 모든 이용권 리스트 
	* @author 김대호
	*/
	List<BookKindVO> readAllKind();
	
	
}
