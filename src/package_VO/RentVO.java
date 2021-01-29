package package_VO;

import package_Database.Database;

public class RentVO {
	private int rent_seq; //대여 PK
	private String rent_date; // 대여일
	private String rent_grade; // 대여 책 평점
	private String user_Id; //대여 아이디 FK
	private int book_seq; // 책 FK
	
	
	public int getRent_seq() {
		return rent_seq;
	}
	public void setRent_seq() {
		rent_seq = ++Database.rent_cur_seq;
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
	public String getRent_date() {
		return rent_date;
	}
	public void setRent_date(String rent_date) {
		this.rent_date = rent_date;
	}
	public String getRent_grade() {
		return rent_grade;
	}
	public void setRent_grade(String rent_grade) {
		this.rent_grade = rent_grade;
	}
	

	@Override
	public String toString() {
		return "";
	}
	
}
