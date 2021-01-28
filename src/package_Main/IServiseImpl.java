package package_Main;

import java.util.Map;

import package_VO.UserVO;

public class IServiseImpl implements IService{

	@Override
	public boolean insertUser(UserVO userVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkId(String id) {
		// TODO Auto-generated method stub
		return false;
<<<<<<< Updated upstream
	}

	@Override
	public boolean adminLogin(Map<String, String> loginInfo) {
=======
	}

	@Override
	public boolean adminLogin(Map<String, String> loginInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean userLogin(Map<String, String> loginInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<RentVO> rentListView(UserVO user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean giveGrade(RentVO rent_grade) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyGrade(Map<String, Object> UserInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeGrade(Map<String, Object> UserInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int chargePoint(Map<String, Integer> User) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BookVO> newBookView(BookVO book_seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RentVO> popularBookView(BookVO book_seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfoVO> userVoucher(UserVO user_id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<VoucherVO> userVoucherDetail(VoucherVO v_seq) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean buyvoucher(int v_seq) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BookVO> searchBookName(Map<String, Object> searchName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookVO> searchBookAuthor(Map<String, Object> searchAuthor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookVO> searchBookGenre(Map<String, Object> searchGenre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean rentBook(BookVO book_seq) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<RentVO> readRentList() {
		return database.readRentList();
		
	}

	@Override
	public List<BookVO> readAllBook() {
		return database.readAllBook();
	}

	@Override
	public boolean addBook(BookVO book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BookVO bookDetailView(int book_req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifyBook(Map<String, Object> bookInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBook(int book_seq) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UserVO> readAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO userDetailView(String user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NotifyVO> readAllNotify() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addNotify(NotifyVO notify) {
>>>>>>> Stashed changes
		// TODO Auto-generated method stub
		return false;
	}

<<<<<<< Updated upstream
	@Override
	public boolean userLogin(Map<String, String> loginInfo) {
=======
	@Override
	public NotifyVO notifyDetailView(int notify_seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifyNotify(Map<String, Object> notifyInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteNotify(int notify_seq) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<VoucherVO> readAllVoucher() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addVoucher(VoucherVO voucher) {
>>>>>>> Stashed changes
		// TODO Auto-generated method stub
		return false;
	}

<<<<<<< Updated upstream
=======
	@Override
	public VoucherVO voucherDetailView(int voucher_seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifyVoucher(Map<String, Object> voucherInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteVoucher(int voucher_seq) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UserInfoVO> dailySalesView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfoVO> monthlySalesView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfoVO> annualSalesView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookKindVO> readAllKind() {
		// TODO Auto-generated method stub
		return null;
	}

	



>>>>>>> Stashed changes
}
