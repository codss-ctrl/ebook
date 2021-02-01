package package_VO;

import package_Database.Database;

public class BookVO {
	private int book_seq; // 책 PK
	private String book_name; //책이름
	private String author; //저자
	private String regDate; //등록일
	private float book_grade; //책평점
	private boolean book_isActivate=true; //책 삭제여부 
	private int g_seq; //장르 FK

	
	
	public boolean getBook_isActivate() {
		return book_isActivate;
	}
	public void setBook_isActivate(boolean book_isActivate) {
		this.book_isActivate = book_isActivate;
	}
	
	public int getBook_seq() {
		return book_seq;
	}
	public void setBook_seq() {
		book_seq = ++Database.book_cur_seq;
	}
	public void setBook_seq(int book_seq) {
		this.book_seq = book_seq;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public float getBook_grade() {
		return book_grade;
	}
	public void setBook_grade(float book_grade) {
		this.book_grade = book_grade;
	}
	@Override
	public String toString() {
		return "";
	}
	public int getG_seq() {
		return g_seq;
	}
	public void setG_seq(int g_seq) {
		this.g_seq = g_seq;
	}
	
	
}
