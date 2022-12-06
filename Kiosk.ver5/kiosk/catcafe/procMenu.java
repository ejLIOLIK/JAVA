package kiosk.catcafe;

import java.util.ArrayList;

import Util.Command;

public class procMenu {
	
	void Run(ArrayList<Product> p) {	
		
		while(true) {
			
			// 출력 ex) [1.라면 / 2.김밥 / x.이전메뉴]
			Command.pr("[");
			for (int i = 0; i < p.size(); i++) {
				Command.pr((i + 1) + "." + p.get(i).name + " / ");
			}
			Command.pr("x.이전메뉴]");

			KioskObj.cmd = KioskObj.sc.next();

			if (KioskObj.cmd.equals("x")) {
				break;
			}
			
			try { //Integer.parseInt > String 을 int로 변경
				Kiosk.findPro(p, p.get(Integer.parseInt(KioskObj.cmd) - 1).name);
			} catch (NumberFormatException e) {
				Command.Wn("다시 입력해주세요.");
			}
		}	
	}
}
