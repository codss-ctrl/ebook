package package_VO;

import package_Database.Database;

public class NotifyVO {
	private int notify_seq; // 공지 PK
	private String notify_title; // 공지 타이틀
	private String notify_date; // 공지 날짜
	private int readCount; // 조회수
	private String contents; // 공지 내용

	
	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	
	public int getNotify_seq() {
		return notify_seq;
	}

	public void setNotify_seq() {
		notify_seq = ++Database.notify_cur_seq;
	}

	public String getNotify_title() {
		return notify_title;
	}

	public void setNotify_title(String notify_title) {
		this.notify_title = notify_title;
	}

	public String getNotify_date() {
		return notify_date;
	}

	public void setNotify_date(String notify_date) {
		this.notify_date = notify_date;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	@Override
	public String toString() {
		return "";
	}
	
}
