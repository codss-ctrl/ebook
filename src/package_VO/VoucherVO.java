package package_VO;

public class VoucherVO {
	private int seq;
	private int period;
	private String kindVoucher;
	private int price;

	public int getSeq(){
		return seq;
	}
	public int getPeriod(){
		return period;
	}
	public String getKindVoucher(){
		return kindVoucher;
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
	public void setKindVoucher(String kindVoucher){
		this.kindVoucher = kindVoucher;
	}
	public void setPrice(int price){
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "";
	}
}