package package_Main;

import java.util.List;
import java.util.Map;

import package_Database.Database;
import package_VO.BookVO;
import package_VO.NotifyVO;
import package_VO.RentVO;
import package_VO.UserInfoVO;
import package_VO.UserVO;
import package_VO.VoucherVO;

public class IServiseImpl implements IService{
	Database database = new Database();

	@Override
	public boolean insertUser(UserVO userVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkId(String id) {
		// TODO Auto-generated method stub
		return false;
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
	public List<RentVO> readRentList() {
		return database.readRentList();
	}

	
	@Override
	public List<BookVO> readBook() {
		return database.readBook();
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public NotifyVO notifyDetailView(int notify_seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifyNotify(Map<String, Object> modifyInfo) {
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
		// TODO Auto-generated method stub
		return false;
	}

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
	public List<RentVO> rentListView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RentVO> rentBookDetail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean giveGrade(int grade) {
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
	public List<NotifyVO> userNotifyview() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookVO> newBookView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RentVO> popularBookView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfoVO> voucherView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean buyvoucher(int v_seq) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BookVO> bookView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookVO> searchBookName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookVO> searchBookAuthor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookVO> searchBookGenre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookVO> userBookDetail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RentVO> rentBook() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserVO> chargePoint() {
		// TODO Auto-generated method stub
		return null;
	}

}
