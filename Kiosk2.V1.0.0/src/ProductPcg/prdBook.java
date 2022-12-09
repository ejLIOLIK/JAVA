package ProductPcg;

public class prdBook extends Product {

	static final int NEW = 700;
	static final int OLD = 500;
	
	public prdBook(String name, int price, int code) {
		super(name, price);
		this.newold = 0;
		this.bookCode = code;
		this.blbr = true;
	}

	public int bookCode;
	int newold; // 0 new 1 old
	boolean blbr; // 대여여부
	
	@Override
	public void info() {
		if(this.newold==0) {
			System.out.println(name + " " + NEW +" 원");
		}
		else if(this.newold==1){
			System.out.println(name + " " + OLD +" 원");
		}
	}
	
	public void bookInit(int n) {
		if(this.bookCode>=n) {
			newold=1;
		}
	}
	
	public int bookNewOld() {
		if(this.newold==0) {
			return NEW;
		}
		else if(this.newold==1){
			return OLD;
		}
		
		System.out.println("Error");
		return -1;
	}
	
	// 책 번호 입력받아서 신/구
	
}
