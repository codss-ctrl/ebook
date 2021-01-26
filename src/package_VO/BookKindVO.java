package package_VO;

public class BookKindVO {
	private int seq;
	private String genre;
	
	public int getSeq(){
		return seq;
	}
	public String getGenre(){
		return genre;
	}
	public void setSeq(int seq){
		this.seq = seq;
	}
	public void setGenre(String genre){
		this.genre = genre;
	}
	
	@Override
	public String toString() {
		return "";
	}
}
