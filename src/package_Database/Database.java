package package_Database;

import java.util.ArrayList;
import java.util.List;

import package_VO.AdminVO;
import package_VO.BookKindVO;
import package_VO.BookVO;
import package_VO.NotifyVO;
import package_VO.RentVO;
import package_VO.UserInfoVO;
import package_VO.UserVO;
import package_VO.VoucherVO;
//hi00

public class Database {
	//admin 계정
	private final AdminVO admin = new AdminVO();
	
	//책 분류 리스트
	private final List<BookKindVO> kindList = new ArrayList<>();
	
	//책목록 리스트
	private final List<BookVO> bookList = new ArrayList<>();
	
	//게시판 리스트
	private final List<NotifyVO> notifyList = new ArrayList<>();
	
	//이용권 리스트
	private final List<VoucherVO> voucherList = new ArrayList<>();
	
	//회원정보 리스트
	private final List<UserInfoVO> userInfoList = new ArrayList<>();
	
	//회원 리스트
	private final List<UserVO> userList = new ArrayList<>();
	
	//대여 리스트
	private final List<RentVO> rentList = new ArrayList<>();
	
	
	/**
	 * <code>selectAllNotify</code> 메서드는 모든 공지사항을 불러오기 위한 메서드입니다.
	 * @return List : 모든 게시판 내용을 담은 List
	 * @author 홍유리
	 */
	public List<NotifyVO> selectAllNotify(){
		return notifyList;
	}
	/**
	 * <code>selectNotify</code> 메서드는 게시판의 내용 중 하나를 선택하여 불러오기 위한 메서드입니다.
	 * 
	 * @param seq 
	 * 			 : 원하는 게시판 내용을 판별할 수 있는 숫자
	 * @return 해당 게시판 내용을 반환
	 * @author 홍유리
	 */
	
	public NotifyVO selectNotify(int seq){
		for(NotifyVO notify : notifyList){
			if (notify.getNotify_seq()== seq) {
				return notify;
			}
		}
		return null;
	}
	/**
	 * <code>insertNotify</code> 메서드는 공지사항을 추가하기 위한 메서드입니다.
	 * 
	 * @param 새로운 공지사항의 정보를 담고있는 NotifyVO 객체
	 * 
	 * @return 공지사항 등록 성공 시 true, 실패 시 false 반환
	 * 
	 */
	
	/**
	 * <code>updateNotify</code> 메서드는 게시판을 수정하기 위한 메서드입니다.
	 * 
	 * @param notifyObj : notify_seq,topRent,newBook
	 * @return 갱신에 성공한다면 1, 실패한다면 0 반환
	 * @author 홍유리
	 */
//	public int updateNotify(Map<String, Object> notifyObj){
//		if (notifyObj.get("notify_seq")==null) {
//			return 0;
//		}
//		return 0;
//	}
	
	/**
	 * <code>deleteNotify</code> 메서드는 게시판의 내용을 삭제하기 위한 메서드입니다.
	 * 
	 * @param seq
	 *            : 게시판의 내용을 판별할 수 있는 숫자
	 * @return 삭제에 성공한다면 1, 실패한다면 0 반환
	 * @author 홍유리
	 */
	public int deleteNotify(int seq){
		if (notifyList.remove(selectNotify(seq))) {
			return 1;
		}
		return 0;
	}
	
	
	
	/**
	 * 대출 목록 조회
	 * 
	 * @param 
	 * @return 모든 대여 리스트 반환
	 * @author 김대호
	 */	
	public List<RentVO> readRentList() {
		return rentList;
	}
	
	
	/**
	 * 
	 * 보유 도서 조회
	 * 
	 * @param 
	 * @return 보유 책 리스트
	 * @author 김대호
	 */
	public List<BookVO> readAllBook() {
		return bookList;
	}
	
	
	
	/**
	 * 
	 * id 중복 여부와 조건을 만족하는지 확인
	 * 
	 * @param id
	 * @return 만족하면 true, 불만족하면 false 반환
	 * @author
	 * 
	 */
	public boolean checkId(String id) {
		for(UserVO user : userList){
			if(!(user.getUser_id().equals(id))){
				return false;
			}
		}
		return true;
	}
	
	
	
	/**
	 * 
	 * 모든 장르 조회
	 * 
	 * @param 
	 * @return 모든 이용권 리스트 
	 * @author 김대호
	 */
	public List<BookKindVO> readAllKind() {
		return kindList;
	}
	
	
	
	
	
	
	//회원정보 생성자
	{
		UserInfoVO i1 = new UserInfoVO();
		i1.setInfo_seq(1);//1일권
		i1.setV_seq(1);
		i1.setUser_id("abc123");
		i1.setBuy_date("2021-01-10");
		i1.setInfo_isActivate(true);
		
		UserInfoVO i2 = new UserInfoVO();
		i1.setInfo_seq(2);
		i1.setV_seq(1);//7일권
		i1.setUser_id("ab123");
		i1.setBuy_date("2021-01-11");
		i1.setInfo_isActivate(true);
		
		UserInfoVO i3 = new UserInfoVO();
		i1.setInfo_seq(2);//7일권
		i1.setUser_id("des123");
		i1.setBuy_date("2021-01-12");
		i1.setInfo_isActivate(true);
		
		UserInfoVO i4 = new UserInfoVO();
		i1.setInfo_seq(3);//7일권
		i1.setUser_id("bdc123");
		i1.setBuy_date("2021-01-13");
		i1.setInfo_isActivate(true);
		
		UserInfoVO i5 = new UserInfoVO();
		i1.setInfo_seq(3);//30일권
		i1.setUser_id("abcd123");
		i1.setBuy_date("2021-01-01");
		i1.setInfo_isActivate(true);
		
		UserInfoVO i6 = new UserInfoVO();
		i1.setInfo_seq(1);//90일권
		i1.setUser_id("agd123");
		i1.setBuy_date("2021-01-25");
		i1.setInfo_isActivate(true);
		
		UserInfoVO i7 = new UserInfoVO();
		i1.setInfo_seq(4);//1일권
		i1.setUser_id("dd1232");
		i1.setBuy_date("2021-01-23");
		i1.setInfo_isActivate(true);
		
		UserInfoVO i8 = new UserInfoVO();
		i1.setInfo_seq(6);//365일권
		i1.setUser_id("des123");
		i1.setBuy_date("2019-01-25");
		i1.setInfo_isActivate(true);
		
		UserInfoVO i9 = new UserInfoVO();
		i1.setInfo_seq(5);//180일권
		i1.setUser_id("bbb123");
		i1.setBuy_date("2020-10-25");
		i1.setInfo_isActivate(true);
		
		UserInfoVO i10 = new UserInfoVO();
		i1.setInfo_seq(6);//365일권
		i1.setUser_id("cbb123");
		i1.setBuy_date("2020-01-25");
		i1.setInfo_isActivate(true);
		
		
	}
	
	
	//공지목록
	{
		NotifyVO n1 = new NotifyVO();
		n1.setNotify_seq(1);
		n1.setNotify_date("2015-01-25");
		n1.setNotify_title("안녕하세요");
//		n1.setTopRent(topRent);
//		n1.setPopularBook(popularBook);
	}
	
	
	// 책 리스트 생성자
	{
		BookVO b1 = new BookVO();
		b1.setBook_seq(1);
		b1.setBook_name("하백의 신부 1");
		b1.setAuthor("윤미경");
		b1.setRegDate("2021-01-25");
		b1.setG_seq(6);
		bookList.add(b1);
		
		BookVO b2 = new BookVO();
		b2.setBook_seq(2);
		b2.setBook_name("티아라 7");
		b2.setAuthor("이윤희");
		b2.setRegDate("2021-01-25");
		b2.setG_seq(6);
		bookList.add(b2);
		
		BookVO b3 = new BookVO();
		b3.setBook_seq(3);
		b3.setBook_name("나의 짐승남 1");
		b3.setAuthor("차경희");
		b3.setRegDate("2021-01-25");
		b3.setG_seq(6);
		bookList.add(b3);
		
		BookVO b4 = new BookVO();
		b4.setBook_seq(4);
		b4.setBook_name("지나치게 낭만적인 1");
		b4.setAuthor("김설희");
		b4.setRegDate("2021-01-25");
		b4.setG_seq(6);
		bookList.add(b4);
		
		BookVO b5 = new BookVO();
		b5.setBook_seq(5);
		b5.setBook_name("열혈강호 82 ");
		b5.setAuthor("전극진");
		b5.setRegDate("2021-01-25");
		b5.setG_seq(4);
		bookList.add(b5);
		
		BookVO b6 = new BookVO();
		b6.setBook_seq(6);
		b6.setBook_name("원피스 97");
		b6.setAuthor("오다 에이치로");
		b6.setRegDate("2021-01-25");
		b6.setG_seq(4);
		bookList.add(b6);
		
		BookVO b7 = new BookVO();
		b7.setBook_seq(7);
		b7.setBook_name("다이아몬드 에이스 21");
		b7.setAuthor("테라지마 유지");
		b7.setRegDate("2021-01-25");
		b7.setG_seq(10);
		bookList.add(b7);
		
		BookVO b8 = new BookVO();
		b8.setBook_seq(8);
		b8.setBook_name("하이큐!! 45");
		b8.setAuthor("후루다테 하루이치");
		b8.setRegDate("2021-01-25");
		b8.setG_seq(10);
		bookList.add(b8);
		
		BookVO b9 = new BookVO();
		b9.setBook_seq(9);
		b9.setBook_name("신테니스의왕자 30");
		b9.setAuthor("코노미 다케시");
		b9.setRegDate("2021-01-25");
		b9.setG_seq(10);
		bookList.add(b9);
		
		BookVO b10 = new BookVO();
		b10.setBook_seq(10);
		b10.setBook_name("날씨의아이 2");
		b10.setAuthor("신카이 마코토");
		b10.setRegDate("2021-01-25");
		b10.setG_seq(6);
		bookList.add(b10);
	}
	
	
	
	
		//대여목록 생성자
	{
		RentVO r1 = new RentVO();
		r1.setBook_seq(1);
		r1.setBook_seq(1);
		r1.setUser_Id("abc123");
		r1.setRent_date("2021-01-25");
		rentList.add(r1);
		
		RentVO r2 = new RentVO();
		r2.setBook_seq(2);
		r2.setBook_seq(2);
		r2.setUser_Id("des123");
		r2.setRent_date("2021-01-25");
		rentList.add(r2);
		
		RentVO r3 = new RentVO();
		r3.setBook_seq(3);
		r3.setBook_seq(3);
		r3.setUser_Id("bbb123");
		r3.setRent_date("2021-01-25");
		rentList.add(r3);
		
		RentVO r4 = new RentVO();
		r4.setBook_seq(4);
		r4.setBook_seq(4);
		r4.setUser_Id("aaa233");
		r4.setRent_date("2021-01-25");
		rentList.add(r4);
		
		RentVO r5 = new RentVO();
		r5.setBook_seq(5);
		r5.setBook_seq(5);
		r5.setUser_Id("dd1232");
		r5.setRent_date("2021-01-25");
		rentList.add(r5);
		
		RentVO r6 = new RentVO();
		r6.setBook_seq(6);
		r6.setBook_seq(6);
		r6.setUser_Id("zzz654");
		r6.setRent_date("2021-01-25");
		rentList.add(r6);
		
		RentVO r7 = new RentVO();
		r7.setBook_seq(7);
		r7.setBook_seq(7);
		r7.setUser_Id("asdf321");
		r7.setRent_date("2021-01-25");
		rentList.add(r7);
		
		RentVO r8 = new RentVO();
		r8.setBook_seq(8);
		r8.setBook_seq(8);
		r8.setUser_Id("qwer1234");
		r8.setRent_date("2021-01-25");
		rentList.add(r8);
		
		RentVO r9 = new RentVO();
		r9.setBook_seq(9);
		r9.setBook_seq(9);
		r9.setUser_Id("zxcv123");
		r9.setRent_date("2021-01-25");
		rentList.add(r9);
		
		RentVO r10 = new RentVO();
		r10.setBook_seq(10);
		r10.setBook_seq(10);
		r10.setUser_Id("fdsa098");
		r10.setRent_date("2021-01-25");
		rentList.add(r10);
	}
	
	//유저 초기화
	{
		UserVO u1 = new UserVO();
		u1.setUser_name("김대호");
		u1.setUser_id("abc123");
		u1.setUser_pw("abc123");
		u1.setUser_point(2000);
		userList.add(u1);

		UserVO u2 = new UserVO();
		u2.setUser_name("홍유리");
		u2.setUser_id("des123");
		u2.setUser_pw("des123");
		u2.setUser_point(20000);
		userList.add(u2);
		
		UserVO u3 = new UserVO();
		u3.setUser_name("조유진");
		u3.setUser_id("bbb123");
		u3.setUser_pw("bbb123");
		u3.setUser_point(10000);
		userList.add(u3);
		
		UserVO u4 = new UserVO();
		u4.setUser_name("김대순");
		u4.setUser_id("aaa233");
		u4.setUser_pw("aaa233");
		u4.setUser_point(100);
		userList.add(u4);
		
		UserVO u5 = new UserVO();
		u5.setUser_name("강남훈");
		u5.setUser_id("dd1232");
		u5.setUser_pw("dd1232");
		u5.setUser_point(10000);
		userList.add(u5);
		
		UserVO u6 = new UserVO();
		u6.setUser_name("하윤주");
		u6.setUser_id("zzz654");
		u6.setUser_pw("zzz654");
		u6.setUser_point(1000);
		userList.add(u6);
		
		UserVO u7 = new UserVO();
		u7.setUser_name("이학재");
		u7.setUser_id("asdf321");
		u7.setUser_pw("asdf321");
		u7.setUser_point(2000);
		userList.add(u7);
		
		UserVO u8 = new UserVO();
		u8.setUser_name("권민정");
		u8.setUser_id("qwer1234");
		u8.setUser_pw("qwer1234");
		u8.setUser_point(100);
		userList.add(u8);
		
		UserVO u9 = new UserVO();
		u9.setUser_name("이규방");
		u9.setUser_id("zxcv123");
		u9.setUser_pw("zxcv123");
		u9.setUser_point(7000);
		userList.add(u9);
		
		UserVO u10 = new UserVO();
		u10.setUser_name("유은서");
		u10.setUser_id("fdsa098");
		u10.setUser_pw("fdsa098");
		u10.setUser_point(5000);
		userList.add(u10);
		
	}
	
	//책 분류 초기화 블럭
	{
		BookKindVO b1 = new BookKindVO();
		b1.setGenre_seq(1);
		b1.setGenre_name("일상");
		kindList.add(b1);
		
		BookKindVO b2 = new BookKindVO();
		b2.setGenre_seq(2);
		b2.setGenre_name("개그");
		kindList.add(b2);
		
		BookKindVO b3 = new BookKindVO();
		b3.setGenre_seq(3);
		b3.setGenre_name("판타지");
		kindList.add(b3);
		
		BookKindVO b4 = new BookKindVO();
		b4.setGenre_seq(4);
		b4.setGenre_name("액션");
		kindList.add(b4);
		
		BookKindVO b5 = new BookKindVO();
		b5.setGenre_seq(5);
		b5.setGenre_name("드라마");
		kindList.add(b5);
		
		BookKindVO b6 = new BookKindVO();
		b6.setGenre_seq(6);
		b6.setGenre_name("순정");
		kindList.add(b6);
		
		BookKindVO b7 = new BookKindVO();
		b7.setGenre_seq(7);
		b7.setGenre_name("감성");
		kindList.add(b7);
		
		BookKindVO b8 = new BookKindVO();
		b8.setGenre_seq(8);
		b8.setGenre_name("스릴러");
		kindList.add(b8);
		
		BookKindVO b9 = new BookKindVO();
		b9.setGenre_seq(9);
		b9.setGenre_name("시대극");
		kindList.add(b9);
		
		BookKindVO b10 = new BookKindVO();
		b10.setGenre_seq(10);
		b10.setGenre_name("스포츠");
		kindList.add(b10);
	}
	
	//이용권 목록 초기화 블럭
	{
		VoucherVO v1 = new VoucherVO();
		v1.setV_seq(1);
		v1.setV_period(7);
		v1.setV_name("1일권");
		v1.setV_price(500);			
		voucherList.add(v1);
		
		VoucherVO v2 = new VoucherVO();
		v2.setV_seq(2);
		v2.setV_period(7);
		v2.setV_name("7일권");
		v2.setV_price(3000);
		voucherList.add(v2);
			
		VoucherVO v3 = new VoucherVO();
		v3.setV_seq(3);
		v3.setV_period(30);
		v3.setV_name("30일권");
		v3.setV_price(9900);
		voucherList.add(v3);
			
		VoucherVO v4 = new VoucherVO();
		v4.setV_seq(4);
		v4.setV_period(90);
		v4.setV_name("90일권");
		v4.setV_price(26000);
		voucherList.add(v4);
			
		VoucherVO v5 = new VoucherVO();
		v5.setV_seq(5);
		v5.setV_period(180);
		v5.setV_name("180일권");
		v5.setV_price(33000);
		voucherList.add(v5);
			
		VoucherVO v6 = new VoucherVO();
		v6.setV_seq(6);
		v6.setV_period(365);
		v6.setV_name("365일권");
		v6.setV_price(59500);
		voucherList.add(v6);
		
		
	}
	
	
}

