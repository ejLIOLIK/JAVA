package Admin;

import KioskProc.Display;
import KioskProc.Setting;

public class Admin {

	public boolean run() {

		while (true) {
			System.out.println("l.주문서 내역조회 k.키오스크로");
			Setting.cmd = Setting.sc.next();

			switch (Setting.cmd) {
			case "l":
				adminOrderListAll();
				break;
			case "k":
				return false;
			default:
			}
		}
	}
	
	void adminOrderListAll(){ //전체 주문서 조회
		
		for(int i =0; i< Setting.orderlist.size();i++) {
			System.out.println("주문서 번호: " +(i+1));
			System.out.println(Setting.orderlist.get(i));
			Display.Line();
		}
		System.out.println("	 ** 총액 : "+Setting.sumOrderlist +"원");
		Display.Line();
		
	}
	
}
