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
		return database.adminLogin(loginInfo);
	}

	@Override
	public UserVO userLogin(Map<String, String> loginInfo) {
		return database.userLogin(loginInfo);
	}
	

////////////////////////////////////////////////////////////////////////
//고객
////////////////////////////////////////////////////////////////////////
	

	/**
	 * 유저 이름 변경 - 사용자 메서드
	 * @param name
	 * @return 
	 * @author 홍유리
	 */
	@Override
	public boolean modifyName(Map<String, Object> nameInfo) {
		return database.modifyName(nameInfo);
		
	}
	/**
	 * 사용자 비밀번호 변경 - 사용자 메서드
	 * @param pwInfo
	 * @return
	 * @author 홍유리
	 */
	@Override
	public boolean modifyPassword(Map<String, Object> pwInfo) {
		return database.modifyPassword(pwInfo);
	}
	/**
	 * 회원 탈퇴 - 사용자 메서드
	 * @param actInfo
	 * @author 홍유리
	 */
	@Override
	public boolean deleteUser(Map<String, Object> actInfo) {
		return database.deleteUser(actInfo);
	}
	
	/**
	* 대여 목록 조회 - 사용자 메서드
	* @param user_id
	* @return 대여한 책 목록을 반환.
	* 			
	* @author 홍유리
	*/
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
	public boolean buyVoucher(int v_seq) {
//		return database.buyVoucher()
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
	public int chargePoint(Map<String, Object> userobj) {
		return database.chargePoint(userobj);
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
	
	
	
/////////////////////////////////////////////////////////////////////
//관리자
/////////////////////////////////////////////////////////////////////
@Override
public List<BookKindVO> readAllKind() {
	return database.readAllKind();
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
public NotifyVO notifySelector(int selNum){
	return database.notifySelector(selNum);
}



@Override
public List<NotifyVO> readAllNotify() {
	return database.readAllNotify();
}

@Override
public boolean addNotify(NotifyVO notify) {
	return database.addNotify(notify);
}

@Override
public NotifyVO notifyDetailView(int notify_seq) {
// TODO Auto-generated method stub
return null;
}

@Override
public boolean modifyNotify(Map<String, Object> modifyInfo) {
	return database.modifyNotify(modifyInfo);
}

@Override
public boolean deleteNotify(NotifyVO notify) {
	return database.deleteNotify(notify);
}



///////////////////////////////////////////////////
//>>>>>>>>>>>>>>	이용권 조회, 추가, 상세보기, 수정, 삭제
///////////////////////////////////////////////////
@Override
public List<VoucherVO> readAllVoucher() {
return database.readAllVoucher();
}

@Override
public boolean addVoucher(VoucherVO voucher) {
return database.addVoucher(voucher);
}

@Override
public VoucherVO voucherDetailView(int voucher_seq) {
return database.voucherDetailView(voucher_seq);
}

@Override
public boolean modifyVoucher(Map<String, Object> voucherInfo) {
return database.modifyVoucher(voucherInfo);
}

@Override
public boolean deleteVoucher(int voucher_seq) {
return database.deleteVoucher(voucher_seq);
}
///////////////////////////////////////////////////
//<<<<<<<<<<<<<<<<<
///////////////////////////////////////////////////



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

@Override
public List<UserInfoVO> dailySalesView() {
	return null;
}





/////////////////////////////////////////////////////////////////////
//관리자 끝
/////////////////////////////////////////////////////////////////////	


}
