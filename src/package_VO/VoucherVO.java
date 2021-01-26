package package_VO;

public class VoucherVO {
	private int seq;
	private int period;
	private String kindOfVou;
	private int price;

	public int getSeq(){
		return seq;
	}
	public int getPeriod(){
		return period;
	}
	public String getKindOfVou(){
		return kindOfVou;
	}
	public int getPrice(){
		return price;
	}
	public void setSeq(int seq){
		this.seq = seq;
	}
	public void setPeriod(int period){
		this.period = period;
	}
	public void setKindOfVou(String kindOfVou){
		this.kindOfVou = kindOfVou;
	}
	public void setPrice(int price){
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "";
	}
}