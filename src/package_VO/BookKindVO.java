package package_VO;

import package_Database.Database;

public class BookKindVO {
	private int genre_seq; //장르 PK
	private String genre_name; //장르 이름
	
	
	
	public int getGenre_seq() {
		return genre_seq;
	}



	public void setGenre_seq() {
		this.genre_seq = ++Database.genre_cur_seq;
	}



	public String getGenre_name() {
		return genre_name;
	}



	public void setGenre_name(String genre_name) {
		this.genre_name = genre_name;
	}



	@Override
	public String toString() {
		return "";
	}
}
