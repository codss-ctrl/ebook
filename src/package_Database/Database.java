package package_Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import package_VO.AdminVO;
import package_VO.BookKindVO;
import package_VO.BookVO;
import package_VO.NotifyVO;
import package_VO.RentVO;
import package_VO.UserInfoVO;
import package_VO.UserVO;
import package_VO.VoucherVO;
//hi

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
			if (notify.getSeq()== seq) {
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
	 * <code>searchBook</code> 메서드는 도서를 검색하기 위한 메서드입니다.
	 * 
	 * @param book_seq
	 * @return 
	 * @author 홍유리
	 */
	
//	public String searchBook_Notify(int seq ){
//		return 
//	}
	
	//회원정보 생성자
	{
		UserInfoVO i1 = new UserInfoVO();
		i1.setSeq(1);//1일권
		i1.setV_seq(1);
		i1.setUser_id("abc123");
		i1.setBuyDate("2021-01-10");
		i1.setActivate(true);
		
		UserInfoVO i2 = new UserInfoVO();
		i1.setSeq(2);
		i1.setV_seq(1);//7일권
		i1.setUser_id("abc123");
		i1.setBuyDate("2021-01-11");
		i1.setActivate(true);
		
		UserInfoVO i3 = new UserInfoVO();
		i1.setSeq(2);//7일권
		i1.setUser_id("des123");
		i1.setBuyDate("2021-01-12");
		i1.setActivate(true);
		
		UserInfoVO i4 = new UserInfoVO();
		i1.setSeq(3);//7일권
		i1.setUser_id("abc123");
		i1.setBuyDate("2021-01-13");
		i1.setActivate(true);
		
		UserInfoVO i5 = new UserInfoVO();
		i1.setSeq(3);//30일권
		i1.setUser_id("abc123");
		i1.setBuyDate("2021-01-01");
		i1.setActivate(true);
		
		UserInfoVO i6 = new UserInfoVO();
		i1.setSeq(1);//90일권
		i1.setUser_id("abc123");
		i1.setBuyDate("2021-01-25");
		i1.setActivate(true);
		
		UserInfoVO i7 = new UserInfoVO();
		i1.setSeq(4);//1일권
		i1.setUser_id("dd1232");
		i1.setBuyDate("2021-01-23");
		i1.setActivate(true);
		
		UserInfoVO i8 = new UserInfoVO();
		i1.setSeq(6);//365일권
		i1.setUser_id("des123");
		i1.setBuyDate("2019-01-25");
		i1.setActivate(true);
		
		UserInfoVO i9 = new UserInfoVO();
		i1.setSeq(5);//180일권
		i1.setUser_id("bbb123");
		i1.setBuyDate("2020-10-25");
		i1.setActivate(true);
		
		UserInfoVO i10 = new UserInfoVO();
		i1.setSeq(6);//365일권
		i1.setUser_id("bbb123");
		i1.setBuyDate("2020-01-25");
		i1.setActivate(true);
		
		
	}
	
	
	
	
	
	//공지목록
	{
		NotifyVO n1 = new NotifyVO();
		n1.setSeq(1);
		n1.setDate("2015-01-25");
		n1.setTitle("안녕하세요");
//		n1.setTopRent(topRent);
//		n1.setPopularBook(popularBook);
	}
	
	
	// 책 리스트 생성자
	{
		BookVO b1 = new BookVO();
		b1.setSeq(1);
		b1.setBookName("하백의 신부 1");
		b1.setAuthor("윤미경");
		b1.setRegDate("2021-01-25");
		bookList.add(b1);
		
		BookVO b2 = new BookVO();
		b2.setSeq(2);
		b2.setBookName("티아라 7");
		b2.setAuthor("이윤희");
		b2.setRegDate("2021-01-25");
		bookList.add(b2);
		
		BookVO b3 = new BookVO();
		b3.setSeq(3);
		b3.setBookName("나의 짐승남 1");
		b3.setAuthor("차경희");
		b3.setRegDate("2021-01-25");
		bookList.add(b3);
		
		BookVO b4 = new BookVO();
		b4.setSeq(4);
		b4.setBookName("지나치게 낭만적인 1");
		b4.setAuthor("김설희");
		b4.setRegDate("2021-01-25");
		bookList.add(b4);
		
		BookVO b5 = new BookVO();
		b5.setSeq(5);
		b5.setBookName("열혈강호 82 ");
		b5.setAuthor("전극진");
		b5.setRegDate("2021-01-25");
		bookList.add(b5);
	}
	//대여목록 생성자
	{
		RentVO r1 = new RentVO();
		r1.setSeq(1);
		r1.setBook_seq(1);
		r1.setUser_Id("abc123");
		rentList.add(r1);
		
		RentVO r2 = new RentVO();
		r1.setSeq(2);
		r1.setBook_seq(2);
		r1.setUser_Id("abc123");
		rentList.add(r2);
		
		RentVO r3 = new RentVO();
		r1.setSeq(3);
		r1.setBook_seq(3);
		r1.setUser_Id("des123");
		rentList.add(r3);
		
		RentVO r4 = new RentVO();
		r1.setSeq(4);
		r1.setBook_seq(4);
		r1.setUser_Id("des123");
		rentList.add(r4);
		
		RentVO r5 = new RentVO();
		r1.setSeq(5);
		r1.setBook_seq(5);
		r1.setUser_Id("des123");
		rentList.add(r5);
		
		RentVO r6 = new RentVO();
		r1.setSeq(6);
		r1.setBook_seq(6);
		r1.setUser_Id("bbb123");
		rentList.add(r6);
		
		RentVO r7 = new RentVO();
		r1.setSeq(7);
		r1.setBook_seq(7);
		r1.setUser_Id("bbb123");
		rentList.add(r7);
		
		RentVO r8 = new RentVO();
		r1.setSeq(8);
		r1.setBook_seq(8);
		r1.setUser_Id("bbb123");
		rentList.add(r8);
		
		RentVO r9 = new RentVO();
		r1.setSeq(9);
		r1.setBook_seq(9);
		r1.setUser_Id("aaa233");
		rentList.add(r9);
		
		RentVO r10 = new RentVO();
		r1.setSeq(10);
		r1.setBook_seq(10);
		r1.setUser_Id("aaa233");
		rentList.add(r10);
	}
	
	//유저 초기화
	{
		UserVO u1 = new UserVO();
		u1.setUserName("김대호");
		u1.setId("abc123");
		u1.setPw("abc123");
		u1.setPoint(2000);
		userList.add(u1);

		UserVO u2 = new UserVO();
		u2.setUserName("홍유리");
		u2.setId("des123");
		u2.setPw("des123");
		u2.setPoint(20000);
		userList.add(u2);
		
		UserVO u3 = new UserVO();
		u3.setUserName("조유진");
		u3.setId("bbb123");
		u3.setPw("bbb123");
		u3.setPoint(10000);
		userList.add(u3);
		
		UserVO u4 = new UserVO();
		u4.setUserName("김대순");
		u4.setId("aaa233");
		u4.setPw("aaa233");
		u4.setPoint(100);
		userList.add(u4);
		
		UserVO u5 = new UserVO();
		u5.setUserName("강남훈");
		u5.setId("dd1232");
		u5.setPw("dd1232");
		u5.setPoint(10000);
		userList.add(u5);
		
		UserVO u6 = new UserVO();
		u6.setUserName("하윤주");
		u6.setId("zzz654");
		u6.setPw("zzz654");
		u6.setPoint(1000);
		userList.add(u6);
		
		UserVO u7 = new UserVO();
		u7.setUserName("이학재");
		u7.setId("asdf321");
		u7.setPw("asdf321");
		u7.setPoint(2000);
		userList.add(u7);
		
		UserVO u8 = new UserVO();
		u8.setUserName("권민정");
		u8.setId("qwer1234");
		u8.setPw("qwer1234");
		u8.setPoint(100);
		userList.add(u8);
		
		UserVO u9 = new UserVO();
		u9.setUserName("이규방");
		u9.setId("zxcv123");
		u9.setPw("zxcv123");
		u9.setPoint(7000);
		userList.add(u9);
		
		UserVO u10 = new UserVO();
		u10.setUserName("유은서");
		u10.setId("fdsa098");
		u10.setPw("fdsa098");
		u10.setPoint(5000);
		userList.add(u10);
		
	}
	
	//책 분류 초기화 블럭
	{
		BookKindVO b1 = new BookKindVO();
		b1.setSeq(1);
		b1.setGenre("일상");
		kindList.add(b1);
		
		BookKindVO b2 = new BookKindVO();
		b1.setSeq(2);
		b1.setGenre("개그");
		kindList.add(b2);
		
		BookKindVO b3 = new BookKindVO();
		b1.setSeq(3);
		b1.setGenre("판타지");
		kindList.add(b3);
		
		BookKindVO b4 = new BookKindVO();
		b1.setSeq(4);
		b1.setGenre("액션");
		kindList.add(b4);
		
		BookKindVO b5 = new BookKindVO();
		b1.setSeq(5);
		b1.setGenre("드라마");
		kindList.add(b5);
		
		BookKindVO b6 = new BookKindVO();
		b1.setSeq(6);
		b1.setGenre("순정");
		kindList.add(b6);
		
		BookKindVO b7 = new BookKindVO();
		b1.setSeq(7);
		b1.setGenre("감성");
		kindList.add(b7);
		
		BookKindVO b8 = new BookKindVO();
		b1.setSeq(8);
		b1.setGenre("스릴러");
		kindList.add(b8);
		
		BookKindVO b9 = new BookKindVO();
		b1.setSeq(9);
		b1.setGenre("시대극");
		kindList.add(b9);
		
		BookKindVO b10 = new BookKindVO();
		b1.setSeq(10);
		b1.setGenre("스포츠");
		kindList.add(b10);
	}
	
	//이용권 목록 초기화 블럭
	{
		VoucherVO v1 = new VoucherVO();
		v1.setSeq(1);
		v1.setPeriod(7);
		v1.setKindOfVou("1일권");
		v1.setPrice(500);
		voucherList.add(v1);
		
		VoucherVO v2 = new VoucherVO();
		v1.setSeq(2);
		v1.setPeriod(7);
		v1.setKindOfVou("7일권");
		v1.setPrice(3000);
		voucherList.add(v2);
		
		VoucherVO v3 = new VoucherVO();
		v1.setSeq(3);
		v1.setPeriod(30);
		v1.setKindOfVou("30일권");
		v1.setPrice(9900);
		voucherList.add(v3);
		
		VoucherVO v4 = new VoucherVO();
		v1.setSeq(4);
		v1.setPeriod(90);
		v1.setKindOfVou("90일권");
		v1.setPrice(26000);
		voucherList.add(v4);
		
		VoucherVO v5 = new VoucherVO();
		v1.setSeq(5);
		v1.setPeriod(180);
		v1.setKindOfVou("180일권");
		v1.setPrice(33000);
		voucherList.add(v5);
		
		VoucherVO v6 = new VoucherVO();
		v1.setSeq(6);
		v1.setPeriod(365);
		v1.setKindOfVou("365일권");
		v1.setPrice(59500);
		voucherList.add(v6);
	}
	
	//대여목록 생성자
	{
		RentVO r1 = new RentVO();
		r1.setSeq(1);
		r1.setBook_seq(1);
		r1.setUser_Id("abc123");
		rentList.add(r1);
		
		RentVO r2 = new RentVO();
		r1.setSeq(2);
		r1.setBook_seq(2);
		r1.setUser_Id("des123");
		rentList.add(r2);
		
		RentVO r3 = new RentVO();
		r1.setSeq(3);
		r1.setBook_seq(3);
		r1.setUser_Id("bbb123");
		rentList.add(r3);
		
		RentVO r4 = new RentVO();
		r1.setSeq(4);
		r1.setBook_seq(4);
		r1.setUser_Id("aaa233");
		rentList.add(r4);
		
		RentVO r5 = new RentVO();
		r1.setSeq(5);
		r1.setBook_seq(5);
		r1.setUser_Id("dd1232");
		rentList.add(r5);
		
		RentVO r6 = new RentVO();
		r1.setSeq(6);
		r1.setBook_seq(6);
		r1.setUser_Id("zzz654");
		rentList.add(r6);
		
		RentVO r7 = new RentVO();
		r1.setSeq(7);
		r1.setBook_seq(7);
		r1.setUser_Id("asdf321");
		rentList.add(r7);
		
		RentVO r8 = new RentVO();
		r1.setSeq(8);
		r1.setBook_seq(8);
		r1.setUser_Id("qwer1234");
		rentList.add(r8);
		
		RentVO r9 = new RentVO();
		r1.setSeq(9);
		r1.setBook_seq(9);
		r1.setUser_Id("zxcv123");
		rentList.add(r9);
		
		RentVO r10 = new RentVO();
		r1.setSeq(10);
		r1.setBook_seq(10);
		r1.setUser_Id("fdsa098");
		rentList.add(r10);
	}
}

