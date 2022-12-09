package ProductPcg;

import KioskProc.Display;
import KioskProc.Setting;

public class prdDrink extends Product {

	public prdDrink(String name, int price) {
		super(name, price);
		blsylup = true;
		sylup = -1;
	}
	
	public prdDrink(String name, int price, boolean blsylup) {
		super(name, price);
		this.blsylup = blsylup;
		sylup = -1; //시럽 없음
	}
	
	public int icehot; // 0 아이스 1 핫
	public boolean blsylup; // 시럽 가능?
	public int sylup; // 0 바닐라 1 헤이즐넛
	public int optPrice; // 0 바닐라 1 헤이즐넛
	
	public void coffeeOption() { //커피류 옵션 추가금 계산
		
		this.optPrice = this.price;
		
		if(icehot==0) {
			this.optPrice += 500; //아이스 500원 추가
		}
		
		if(sylup==0 || sylup==1)
		{
			this.optPrice += 500; //시럽 500원 추가
		}
	}
	
	public void sylPick() {
		
		int syl;
		
		while(true) {
			System.out.println("시럽을 추가하시겠습니까?");
			System.out.println("1. 추가안함 (+0원) 2. 바닐라(+500원) 3. 헤이즐넛(+500원)");
			syl = Setting.sc.nextInt(); // 키 입력

			if (syl != 1 && syl != 2 && syl != 3) {
				Display.erMsg();
			} else {
				sylup = syl - 2;
				break;
			}
		}
	}
	
	public void icehotPick() {
		
		int ice;
		
		while(true) {
			System.out.println("옵션을 선택하세요.");
			System.out.println("1. Ice(+500원) 2. Hot (+0원)");
			ice = Setting.sc.nextInt(); // 키 입력

			if (ice != 1 && ice != 2) {
				Display.erMsg();
			} else {
				icehot = ice - 1;
				break;
			}
		}
	}
	
}
