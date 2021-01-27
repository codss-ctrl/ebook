package package_VO;

public class NotifyVO {
	private int seq;
	private String title;
	private String date;
	private int readCount;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getReadView() {
		return readCount;
	}
	public void setReadView(int readView) {
		this.readCount = readView;
	}
	
	@Override
	public String toString() {
		return "";
	}
	
}
