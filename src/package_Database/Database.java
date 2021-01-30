package package_Database;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import package_VO.AdminVO;
import package_VO.BookKindVO;
import package_VO.BookVO;
import package_VO.NotifyVO;
import package_VO.RentVO;
import package_VO.UserInfoVO;
import package_VO.UserVO;
import package_VO.VoucherVO;

public class Database {
	public static int book_cur_seq;
	public static int genre_cur_seq;
	public static int notify_cur_seq;
	public static int rent_cur_seq;
	public static int userInfo_cur_seq; 
	public static int v_cur_seq;
	
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
	 * 
	 * 회원가입
	 * 
	 * @param 
	 * @return 
	 * @author 
	 */
	public boolean insertUser(UserVO user) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	/**
	 * 
	 * 관리자 계정 로그인
	 * 
	 * @param loginInfo - admin_id 아이디, admin_pw 비밀번호
	 * @return 로그인 성공 시 true, 실패 시 false 반환
	 * @author 조유진
	 */
	public boolean adminLogin(Map<String, String> loginInfo) {
		return admin.getId().equals(loginInfo.get("user_id")) && admin.getPw().equals(loginInfo.get("user_pw"));
	}
	
	/**
	 * 
	 * id 중복 여부와 조건을 만족하는지 확인
	 * 
	 * @param user_id
	 * @return 만족하면 true, 불만족하면 false 반환
	 * @author
	 * 
	 */
	public boolean checkId(String user_id) {
		for(UserVO user : userList){
			if(!(user.getUser_id().equals(user_id))){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 회원 계정 로그인
	 * 
	 * @param loginInfo - user_id 유저의 아이디, user_pw 유저의 비밀번호
	 * @author
	 * @return 
	 */
	public UserVO userLogin(Map<String, String> loginInfo) {
		for(UserVO user : userList){
			if(user.getUser_id().equals(loginInfo.get("user_id"))){
				return user;
			}
		}
		return null;
		 
	}
	
	
	
	
	
////////////////////////////////////////////////////////////////////////
//고객
////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * 사용자 이름 변경 - 사용자 메서드
	 * @param userInfo
	 * @return 성공시 true, 실패시 false
	 * @author 홍유리
	 */
	public boolean modifyName(Map<String, Object> nameInfo) {
		UserVO user = new UserVO();
		
		if (nameInfo.containsKey("user")) {//user라는 키 가지고 있으면
			user.setUser_name((String)nameInfo.get("user"));
		}else{
			return false;
		}
		return true;
	}
	
	/**
	 * 사용자 비밀번호 변경 - 사용자 메서드
	 * @param pwInfo
	 * @return
	 * @author 홍유리
	 */
	public boolean modifyPassword(Map<String, Object> pwInfo){
		UserVO user = new UserVO();
		
		if (pwInfo.containsKey("user")) {//user라는 키 가지고 있다면
			user.setUser_pw((String)pwInfo.get("user"));
			//user키 이용해서 value값 빼옴 - string으로 변환해서 user객체 pw로 저장
		}else{
			
			return false;
		}
		return true;
		
	}
	/**
	 * 회원 탈퇴 - 사용자 메서드
	 * @param actInfo
	 * @author 홍유리
	 */
	public boolean deleteUser(Map<String, Object> actInfo){
		UserVO user = new UserVO();
		
		if (actInfo.containsKey("user")) {
			user.setUser_isActivate(false);
		}else{
			return false;
		}
		return true;
	}
	/**
	 * 유저 내 정보 조회 - 사용자 메서드
	 * @param user_id
	 * @return 유저의 정보를 담은 리스트
	 */
	public UserInfoVO userInfo(String user_id) {
		for(UserInfoVO userInfoDetail : userInfoList){
			if (userInfoDetail.getUser_id()==user_id) {
				return userInfoDetail;
			}
		}
		return null;
	}
	
	
	/**
	 * 신간보기 - 사용자 메서드
	 * @return
	 * @author 홍유리
	 */
	public List<BookVO> newBookView() {
		return bookList;
	}
	
	/**
	 * 사용자 공지 보기 - 사용자 메서드
	 * @return
	 * @author 홍유리
	 */
	public List<NotifyVO> userNotifyView() {
	return notifyList;
	}
	
	/**
	 * 사용자 공지 상세 보기 - 사용자 메서드
	 * @param notify_seq
	 * @return
	 * @author 홍유리
	 */
	public List<NotifyVO> userNotifyDetail(int notify_seq) {
	return notifyList;
	}
	
	/**
	 * 사용자 이용권 내역보기 - 사용자 메서드
	 * @param v_seq
	 * @return
	 * @author 홍유리
	 */
	public List<VoucherVO> userVoucherDetail(int user_seq) {
		 userInfoList.get(user_seq).getV_seq();
		return null;
	}
	
	/**
	 * 금액 충전- 사용자 메서드
	 * @param userobj - 충전한 user_point를 담은 Map
	 * @return  기존 금액과 충전한 금액의 합
	 * @author 홍유리
	 */
	public int chargePoint(Map<String, Object> userobj){
		UserVO user = new UserVO();
		int finalPoint = user.getUser_point()+(int)userobj.get("user_point");
		userobj.put("user_point",(Integer)finalPoint);
		
		return finalPoint;
		
	}
	

	/**
	* 이용권 구매 - 사용자 메서드
	* voucherList에서 price 이용해서 구매
	* @author 홍유리
	* @param v_seq
	* @return 성공 시 true, 실패시 false 반환
	*/
	public boolean buyVoucher(int v_seq,UserVO user) {
		
		if (userList.contains(user) && user.getUser_point()>voucherList.get(v_seq).getV_price()) {
			int point = user.getUser_point()-voucherList.get(v_seq).getV_price();
			user.setUser_point(point);
			
		}
		
		return false;
	}
	
	
	
//////////////////////////////////////////////////////////////////////
//	                                            관리자            								//
//////////////////////////////////////////////////////////////////////	
	
	
	/**
	 * 대출 목록 조회
	 * 
	 * @return 모든 대여 리스트 반환
	 * @author 김대호
	 */	
	public List<RentVO> readRentList() {
		return rentList;
	}
	
	
	/**
	* 
	* 모든 보유 도서 조회
	* 
	* @return 보유 책 리스트
	* @author 김대호
	*/
	public List<BookVO> readAllBook() {
		return bookList;
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
	
	
	
	public boolean addBook(BookVO book) {
		return bookList.add(book);
	}

	
	
	public BookVO bookSelector(int book_seq) {
	
		for(BookVO book : bookList){
			if(book.getBook_seq() == book_seq){
				return book;
			}
		}
		return null;
	}

	public boolean modifyBook(Map<String, Object> bookInfo) {
		BookVO book;
		if(bookInfo.containsKey("book")){
			book = (BookVO)bookInfo.get("book");
		}else{
			return false;
		}
		
		if(bookInfo.containsKey("name")){
			book.setBook_name((String)bookInfo.get("name"));
		}else if(bookInfo.containsKey("auther")){
			book.setAuthor((String)bookInfo.get("auther"));
		}else if(bookInfo.containsKey("genre")){
			book.setG_seq((Integer)bookInfo.get("genre"));
		}
		
		return true;
	}
	
	
	/**
	 * 
	 * @param selBook
	 * @return
	 */
	public boolean deleteBook(BookVO selBook) {
		if(bookList.remove(selBook)){
			return true;
		}
		return false;
	}

	
	public List<UserVO> readAllUser() {
		return userList;
	}
	

	public List<NotifyVO> readAllNotify() {
		return notifyList;
	}
	
	public boolean addNotify(NotifyVO notify) {
		return notifyList.add(notify);
	}
	
	public boolean modifyNotify(Map<String, Object> notifyInfo) {
		NotifyVO notify = (NotifyVO)notifyInfo.get("notify");
		
		if(notify == null){
			return false;
		}
		
		if(notifyInfo.containsKey("title")){
			notify.setNotify_title((String)notifyInfo.get("title"));
			return true;
		}else if(notifyInfo.containsKey("content")){
			notify.setContents((String)notifyInfo.get("content"));
			return true;
		}
		return false;
	}
	

	public NotifyVO notifySelector(int selNum) {
		for(NotifyVO notify : notifyList){
			if(notify.getNotify_seq() == selNum){
				return notify;
			}
		}
		return null;
	}
	
	public boolean deleteNotify(NotifyVO notify) {
		if(notifyList.remove(notify)){
			return true;
		}
		return false;
	}
	
	
	public List<UserInfoVO> dailySalesView() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
		Calendar cal = Calendar.getInstance();
		String date = simpleDateFormat.format(cal.getTime());
		
		List<UserInfoVO> dailySaleList = new ArrayList<>();
		for(UserInfoVO info : userInfoList){
			if(date.equals(info.getBuy_date())){
				dailySaleList.add(info);
			}
		}
		return userInfoList;
	}

	
	///////////////////////////////////////////////////
	// 이용권 조회, 추가, 상세보기, 수정, 삭제
	///////////////////////////////////////////////////
	
	/**
	 * <code>readAllVoucher</code> 메서드는 모든 이용권 정보를 불러오기 위한 메서드입니다.
	 * 
	 * @return 모든 이용권 정보를 담고 있는 List
	 * @author
	 */
	public List<VoucherVO> readAllVoucher(){
		List<VoucherVO> voucherList = new ArrayList<>();
		for(VoucherVO allVoucher : this.voucherList){
			if(allVoucher.isActivate()){
				voucherList.add(allVoucher);
			}
		}
		return voucherList;
	}
	
	/**
	 * 
	 * @param voucher
	 * @return
	 */
	public boolean addVoucher(VoucherVO voucher){
		return voucherList.add(voucher);
	}
	
	/**
	 * 
	 * @param voucher_seq
	 * @return
	 */
	public VoucherVO voucherDetailView(int voucher_seq){
		for(VoucherVO voucherSelect : voucherList){
			if(voucherSelect.getV_seq() == voucher_seq){
				return voucherSelect;
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param voucherInfo
	 * @return
	 */
	public boolean modifyVoucher(Map<String, Object> voucherInfo){
		if(voucherInfo.get("v_seq")==null){
			return false;	
		}
		VoucherVO modVoucher = voucherDetailView((Integer) voucherInfo.get("v_seq"));
		
		if(voucherInfo.get("v_period")!=null){
			modVoucher.setV_period((Integer)voucherInfo.get("v_period"));
			return true;
		}else if (voucherInfo.get("v_name")!=null){
			modVoucher.setV_name((String)voucherInfo.get("v_name"));
			return true;
		}else if (voucherInfo.get("v_price")!=null){
			modVoucher.setV_price((Integer)voucherInfo.get("v_price"));
		}
		return false;
	}
	
	/**
	 * 
	 * @param voucher_seq
	 * @return
	 */
	public boolean deleteVoucher(int voucher_seq){
		VoucherVO delVoucher = voucherDetailView(voucher_seq);
		if(delVoucher==null){
			return false;	
		}
		delVoucher.setActivate(false);
		return true;
	}
	
	
//////////////////////////////////////////////////////////////////////
//관리자      끝						       								//
//////////////////////////////////////////////////////////////////////
	
	
	
	
	//회원정보 생성자
	{
		UserInfoVO i1 = new UserInfoVO();
		i1.setInfo_seq();//1일권
		i1.setV_seq(1);
		i1.setUser_id("abc123");
		i1.setBuy_date("2021-01-10");
		i1.setInfo_isActivate(true);
		
		UserInfoVO i2 = new UserInfoVO();
		i2.setInfo_seq();
		i2.setV_seq(1);//7일권
		i2.setUser_id("ab123");
		i2.setBuy_date("2021-01-11");
		i2.setInfo_isActivate(true);
		
		UserInfoVO i3 = new UserInfoVO();
		i3.setInfo_seq();//7일권
		i3.setUser_id("des123");
		i3.setBuy_date("2021-01-12");
		i3.setInfo_isActivate(true);
		
		UserInfoVO i4 = new UserInfoVO();
		i4.setInfo_seq();//7일권
		i4.setUser_id("bdc123");
		i4.setBuy_date("2021-01-13");
		i4.setInfo_isActivate(true);
		
		UserInfoVO i5 = new UserInfoVO();
		i5.setInfo_seq();//30일권
		i5.setUser_id("abcd123");
		i5.setBuy_date("2021-01-01");
		i5.setInfo_isActivate(true);
		
		UserInfoVO i6 = new UserInfoVO();
		i6.setInfo_seq();//90일권
		i6.setUser_id("agd123");
		i6.setBuy_date("2021-01-25");
		i6.setInfo_isActivate(true);
		
		UserInfoVO i7 = new UserInfoVO();
		i7.setInfo_seq();//1일권
		i7.setUser_id("dd1232");
		i7.setBuy_date("2021-01-23");
		i7.setInfo_isActivate(true);
		
		UserInfoVO i8 = new UserInfoVO();
		i8.setInfo_seq();//365일권
		i8.setUser_id("des123");
		i8.setBuy_date("2019-01-25");
		i8.setInfo_isActivate(true);
		
		UserInfoVO i9 = new UserInfoVO();
		i9.setInfo_seq();//180일권
		i9.setUser_id("bbb123");
		i9.setBuy_date("2020-10-25");
		i9.setInfo_isActivate(true);
		
		UserInfoVO i10 = new UserInfoVO();
		i10.setInfo_seq();//365일권
		i10.setUser_id("cbb123");
		i10.setBuy_date("2020-01-25");
		i10.setInfo_isActivate(true);
		
		
	}
	
	
	//공지목록
	{
		NotifyVO n1 = new NotifyVO();
		n1.setNotify_seq();
		n1.setNotify_date("2015-01-25");
		n1.setContents("글사랑닷컴에서는 고객님들의 독서 생활을 응원합니다.");
		n1.setNotify_title("글사랑닷컴 오픈");
		n1.setReadCount(1100);
		notifyList.add(n1);
		
		NotifyVO n2 = new NotifyVO();
		n2.setNotify_seq();
		n2.setNotify_date("2015-02-25");
		n2.setContents("매주 셋째주 수요일은 문화의 날입니다. 매달 다양한 이벤트를 즐겨보세요");
		n2.setNotify_title("문화의 날 ");
		n2.setReadCount(2100);
		notifyList.add(n2);
		
		NotifyVO n3 = new NotifyVO();
		n3.setNotify_seq();
		n3.setNotify_date("2018-01-01");
		n3.setContents("모든 고객님들 새해 복 많이 받으세요~~");
		n3.setNotify_title("새해 복 많이 받으세요");
		n3.setReadCount(1500);
		notifyList.add(n3);
		
		NotifyVO n4 = new NotifyVO();
		n4.setNotify_seq();
		n4.setNotify_date("2019-01-28");
		n4.setContents("민음사에서 진행하는 설문조사 이벤트에 참여하시면 추첨하여 민음사의 굿즈를 드립니다 ");
		n4.setNotify_title("출판사 이벤트");
		n4.setReadCount(4556);
		notifyList.add(n4);
		
		NotifyVO n5 = new NotifyVO();
		n5.setNotify_seq();
		n5.setNotify_date("2020-01-25");
		n5.setContents("시스템 오류로 일주일간 글사랑닷컴과 무관한 광고창 팝업이 발생하였습니다.이용에 불편을 드려 죄송합니다. ");
		n5.setNotify_title("광고 팝업 오류");
		n5.setReadCount(1523);
		notifyList.add(n5);
		
		NotifyVO n6 = new NotifyVO();
		n6.setNotify_seq();
		n6.setNotify_date("2021-01-25");
		n6.setContents("1월 26일 오전 9시부터 11시까지 점검이 있을예정입니다. 이용에 불편을 드려 죄송합니다.");
		n6.setNotify_title("정기점검 안내");
		n6.setReadCount(5625);
		notifyList.add(n6);
		
	}
	
	
	// 책 리스트 생성자
	{
		BookVO b1 = new BookVO();
		b1.setBook_seq();
		b1.setBook_name("하백의 신부 1");
		b1.setAuthor("윤미경");
		b1.setRegDate("2021-01-25");
		b1.setG_seq(6);
		bookList.add(b1);
		
		BookVO b2 = new BookVO();
		b2.setBook_seq();
		b2.setBook_name("티아라 7");
		b2.setAuthor("이윤희");
		b2.setRegDate("2021-01-25");
		b2.setG_seq(6);
		bookList.add(b2);
		
		BookVO b3 = new BookVO();
		b3.setBook_seq();
		b3.setBook_name("나의 짐승남 1");
		b3.setAuthor("차경희");
		b3.setRegDate("2021-01-25");
		b3.setG_seq(6);
		b3.setBook_isActivate(false);
		bookList.add(b3);
		
		BookVO b4 = new BookVO();
		b4.setBook_seq();
		b4.setBook_name("지나치게 낭만적인 1");
		b4.setAuthor("김설희");
		b4.setRegDate("2021-01-25");
		b4.setG_seq(6);
		bookList.add(b4);
		
		BookVO b5 = new BookVO();
		b5.setBook_seq();
		b5.setBook_name("열혈강호 82 ");
		b5.setAuthor("전극진");
		b5.setRegDate("2021-01-25");
		b5.setG_seq(4);
		bookList.add(b5);
		
		BookVO b6 = new BookVO();
		b6.setBook_seq();
		b6.setBook_name("원피스 97");
		b6.setAuthor("오다 에이치로");
		b6.setRegDate("2021-01-25");
		b6.setG_seq(4);
		bookList.add(b6);
		
		BookVO b7 = new BookVO();
		b7.setBook_seq();
		b7.setBook_name("다이아몬드 에이스 21");
		b7.setAuthor("테라지마 유지");
		b7.setRegDate("2021-01-25");
		b7.setG_seq(10);
		bookList.add(b7);
		
		BookVO b8 = new BookVO();
		b8.setBook_seq();
		b8.setBook_name("하이큐!! 45");
		b8.setAuthor("후루다테 하루이치");
		b8.setRegDate("2021-01-25");
		b8.setG_seq(10);
		bookList.add(b8);
		
		BookVO b9 = new BookVO();
		b9.setBook_seq();
		b9.setBook_name("신테니스의왕자 30");
		b9.setAuthor("코노미 다케시");
		b9.setRegDate("2021-01-25");
		b9.setG_seq(10);
		b9.setBook_isActivate(false);
		bookList.add(b9);
		
		BookVO b10 = new BookVO();
		b10.setBook_seq();
		b10.setBook_name("날씨의아이 2");
		b10.setAuthor("신카이 마코토");
		b10.setRegDate("2021-01-25");
		b10.setG_seq(6);
		bookList.add(b10);
	}
	
	
	
		//대여목록 생성자
	{
		RentVO r1 = new RentVO();
		r1.setRent_seq();
		r1.setBook_seq(1);
		r1.setUser_Id("abc123");
		r1.setRent_date("2021-01-25");
		rentList.add(r1);
		
		RentVO r2 = new RentVO();
		r2.setRent_seq();
		r2.setBook_seq(5);
		r2.setUser_Id("des123");
		r2.setRent_date("2021-01-25");
		rentList.add(r2);
		
		RentVO r3 = new RentVO();
		r3.setRent_seq();
		r3.setBook_seq(5);
		r3.setUser_Id("bbb123");
		r3.setRent_date("2021-01-25");
		rentList.add(r3);
		
		RentVO r4 = new RentVO();
		r4.setRent_seq();
		r4.setBook_seq(7);
		r4.setUser_Id("aaa233");
		r4.setRent_date("2021-01-25");
		rentList.add(r4);
		
		RentVO r5 = new RentVO();
		r5.setRent_seq();
		r5.setBook_seq(2);
		r5.setUser_Id("dd1232");
		r5.setRent_date("2021-01-25");
		rentList.add(r5);
		
		RentVO r6 = new RentVO();
		r6.setRent_seq();
		r6.setBook_seq(4);
		r6.setUser_Id("zzz654");
		r6.setRent_date("2021-01-25");
		rentList.add(r6);
		
		RentVO r7 = new RentVO();
		r7.setRent_seq();
		r7.setBook_seq(6);
		r7.setUser_Id("asdf321");
		r7.setRent_date("2021-01-25");
		rentList.add(r7);
		
		RentVO r8 = new RentVO();
		r8.setRent_seq();
		r8.setBook_seq(8);
		r8.setUser_Id("qwer1234");
		r8.setRent_date("2021-01-25");
		rentList.add(r8);
		
		RentVO r9 = new RentVO();
		r9.setRent_seq();
		r9.setBook_seq(1);
		r9.setUser_Id("zxcv123");
		r9.setRent_date("2021-01-25");
		rentList.add(r9);
		
		RentVO r10 = new RentVO();
		r10.setRent_seq();
		r10.setBook_seq(2);
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
		b1.setGenre_seq();
		b1.setGenre_name("일상");
		kindList.add(b1);
		
		BookKindVO b2 = new BookKindVO();
		b2.setGenre_seq();
		b2.setGenre_name("개그");
		kindList.add(b2);
		
		BookKindVO b3 = new BookKindVO();
		b3.setGenre_seq();
		b3.setGenre_name("판타지");
		kindList.add(b3);
		
		BookKindVO b4 = new BookKindVO();
		b4.setGenre_seq();
		b4.setGenre_name("액션");
		kindList.add(b4);
		
		BookKindVO b5 = new BookKindVO();
		b5.setGenre_seq();
		b5.setGenre_name("드라마");
		kindList.add(b5);
		
		BookKindVO b6 = new BookKindVO();
		b6.setGenre_seq();
		b6.setGenre_name("순정");
		kindList.add(b6);
		
		BookKindVO b7 = new BookKindVO();
		b7.setGenre_seq();
		b7.setGenre_name("감성");
		kindList.add(b7);
		
		BookKindVO b8 = new BookKindVO();
		b8.setGenre_seq();
		b8.setGenre_name("스릴러");
		kindList.add(b8);
		
		BookKindVO b9 = new BookKindVO();
		b9.setGenre_seq();
		b9.setGenre_name("시대극");
		kindList.add(b9);
		
		BookKindVO b10 = new BookKindVO();
		b10.setGenre_seq();
		b10.setGenre_name("스포츠");
		kindList.add(b10);
	}
	
	//이용권 목록 초기화 블럭
	{
		VoucherVO v1 = new VoucherVO();
		v1.setV_seq();
		v1.setV_period(7);
		v1.setV_name("1일권");
		v1.setV_price(500);			
		voucherList.add(v1);
		
		VoucherVO v2 = new VoucherVO();
		v2.setV_seq();
		v2.setV_period(7);
		v2.setV_name("7일권");
		v2.setV_price(3000);
		voucherList.add(v2);
			
		VoucherVO v3 = new VoucherVO();
		v3.setV_seq();
		v3.setV_period(30);
		v3.setV_name("30일권");
		v3.setV_price(9900);
		voucherList.add(v3);
			
		VoucherVO v4 = new VoucherVO();
		v4.setV_seq();
		v4.setV_period(90);
		v4.setV_name("90일권");
		v4.setV_price(26000);
		voucherList.add(v4);
			
		VoucherVO v5 = new VoucherVO();
		v5.setV_seq();
		v5.setV_period(180);
		v5.setV_name("180일권");
		v5.setV_price(33000);
		v5.setActivate(false);
		voucherList.add(v5);
			
		VoucherVO v6 = new VoucherVO();
		v6.setV_seq();
		v6.setV_period(365);
		v6.setV_name("365일권");
		v6.setV_price(59500);
		voucherList.add(v6);
		
		
	}

	

	
	

	
	

	

	


	

	

	
	
	
}

