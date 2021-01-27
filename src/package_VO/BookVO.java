package package_VO;

public class BookVO {
	private int seq;
	private String bookName;
	private String author;
	private String regDate;
	private int book_grade;
	private int g_seq;

	public int getSeq() {
		return seq;
	}
	public String getBookName() {
		return bookName;
	}
	public String getAuthor() {
		return author;
	}
	
	public String getRegDate() {
		return regDate;
	}
	
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setRegDate(String regDate) {
		this.regDate = regDate;
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
	public int getGrade() {
		return book_grade;
	}
	public void setGrade(int grade) {
		this.book_grade = grade;
	}
	public int getBook_grade() {
		return book_grade;
	}
	public void setBook_grade(int book_grade) {
		this.book_grade = book_grade;
	}
	
	
}
