package kiosk.catcafe;

import java.util.ArrayList;

import Util.Command;

public class procMenu {
	
	void Run(ArrayList<Product> p) {	
		
		while(true) {
			
			Command.pr("[");
			for (int i = 0; i < p.size(); i++) {
				Command.pr((i + 1) + "." + p.get(i).name + " / ");
			}
			Command.pr("x.이전메뉴]");

			KioskObj.cmd = KioskObj.sc.next();

			if (KioskObj.cmd.equals("x")) {
				break;
			}
			
			try {
				Kiosk.findPro(p, p.get(Integer.parseInt(KioskObj.cmd) - 1).name);
			} catch (NumberFormatException e) {
				System.out.println("다시 입력해주세요.");
			}
		}	
	}
}
