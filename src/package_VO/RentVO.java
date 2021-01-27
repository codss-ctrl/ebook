package package_VO;

public class RentVO {
	private int seq;
	private String user_Id;
	private int book_seq;
	private String rentDate;
<<<<<<< Updated upstream
=======
	private String book_grade;
>>>>>>> Stashed changes
	private boolean isActivate;
	
	public String getRentDate() {
		return rentDate;
	}
	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}
	public boolean isActivate() {
		return isActivate;
	}
	public void setActivate(boolean isActivate) {
		this.isActivate = isActivate;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}
	public int getBook_seq() {
		return book_seq;
	}
	public void setBook_seq(int book_seq) {
		this.book_seq = book_seq;
	}
	
	@Override
	public String toString() {
		return "";
	}
<<<<<<< Updated upstream
=======
	public String getBook_Grade() {
		return book_grade;
	}
	public void setBook_Grade(String book_Grade) {
		this.book_grade = book_Grade;
	}
>>>>>>> Stashed changes
}
