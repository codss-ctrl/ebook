package package_Main;

import java.util.List;
import java.util.Map;

import package_Database.Database;
import package_VO.BookKindVO;
import package_VO.BookVO;
import package_VO.NotifyVO;
import package_VO.RentVO;
import package_VO.UserInfoVO;
import package_VO.UserVO;
import package_VO.VoucherVO;

public class IServiseImpl implements IService{
	Database database = new Database();

	@Override
	public boolean insertUser(UserVO user) {
		// TODO Auto-generated method stub
		return database.insertUser(user);
	}

	@Override
	public boolean checkId(String id) {
		return database.checkId(id);
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

////////////////////////////////////////////////////////////////////////
//고객
////////////////////////////////////////////////////////////////////////
@Override
public List<RentVO> rentListView(UserVO user_id) {
// TODO Auto-generated method stub
return null;
}

@Override
public List<RentVO> rentBookDetail(RentVO rent_seq) {
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
public List<BookVO> newBookView() {
return database.newBookView();

}

@Override
public List<RentVO> popularBookView(BookVO book_seq) {
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
public List<BookVO> searchBookAuthor(Map<String, Object> searchAuthor){
// TODO Auto-generated method stub
return null;
}

@Override
public List<BookVO> searchBookGenre(Map<String, Object> searchGenre) {
// TODO Auto-generated method stub
return null;
}



@Override
public boolean rentBook(BookVO book_seq){
return false;
}

@Override
public int chargePoint(Map<String, Integer> userobj) {
// TODO Auto-generated method stub
return 0;
}

@Override
public List<UserInfoVO> userVoucher(UserVO user_id) {

return null;
}

@Override
public List<VoucherVO> userVoucherDetail(VoucherVO v_seq) {
// TODO Auto-generated method stub
return null;
}

@Override
public List<BookKindVO> readAllKind() {
// TODO Auto-generated method stub
return null;
}

@Override
public int pointAfterBuy(Map<String, Object> point) {
// TODO Auto-generated method stub
return 0;
}

@Override
public List<NotifyVO> userNotifyView() {
return database.userNotifyView();

}

@Override
public List<NotifyVO> userNotifyDetail(int notify_seq) {

return database.userNotifyDetail(notify_seq);
}

public List<VoucherVO> userVoucherDetail(int v_seq) {
return database.userVoucherDetail(v_seq);
}

@Override
public List<UserInfoVO> userInfoView(UserVO user_id) {

return null;
}
	
	
	
/////////////////////////////////////////////////////////////////////
//관리자
/////////////////////////////////////////////////////////////////////


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
return database.addBook(book);
}

@Override
public BookVO bookSelector(int book_seq) {
return database.bookSelector(book_seq);
}

@Override
public boolean modifyBook(Map<String, Object> bookInfo) {
return database.modifyBook(bookInfo);
}

@Override
public boolean deleteBook(BookVO selBook) {
return database.deleteBook(selBook);
}

@Override
public List<UserVO> readAllUser() {
return database.readAllUser();
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
public int dailySalesView() {
// TODO Auto-generated method stub
return 0;
}

@Override
public List<Map<String, Integer>> monthlySalesView() {
// TODO Auto-generated method stub
return null;
}

@Override
public List<Map<String, Integer>> annualSalesView() {
// TODO Auto-generated method stub
return null;
}

/////////////////////////////////////////////////////////////////////
//관리자 끝
/////////////////////////////////////////////////////////////////////	


}
