package kiosk.catcafe;

import Util.Command;

public class procMenu {
	
	void Run(Product p[]) {	
		
		while(true) {
			
		Command.pr("[");
		for(int i=0;i<p.length;i++) {
			Command.pr((i+1)+"."+p[i].name+" / ");
		}
		Command.pr("x.이전메뉴]");
		
		Kiosk.cmd = Kiosk.sc.next();
		
		if(Kiosk.cmd.equals("x")) {
			break;
		}
		
		Kiosk.findPro(p, p[Integer.parseInt(Kiosk.cmd)-1].name);
		
		}	
	}
}
