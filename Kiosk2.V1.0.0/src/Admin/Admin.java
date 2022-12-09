package Admin;

import KioskProc.Display;
import KioskProc.Setting;

public class Admin {

	public int run() {

		while (true) {
			System.out.println("l.주문서 내역조회 b.도서 조회 k.키오스크로 q.종료");
			Setting.cmd = Setting.sc.next();

			switch (Setting.cmd) {
			case "l":
				adminOrderListAll();
				break;
			case "b":
				
				for(int i=0;i<Setting.novel.size();i++) {
					Setting.novel.get(i).info();
				}
				
				break;
			case "k":
				return 2;
			case "q":
				return 3;
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
		System.out.println("	 ** 총 매출 : "+Setting.sumOrderlist +"원");
		Display.Line();
	}
	
	
	
}
