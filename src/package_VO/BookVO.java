package package_VO;

public class BookVO {
	private int seq;
	private String bookName;
	private String author;
	private String regDate;
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
	
	
}
