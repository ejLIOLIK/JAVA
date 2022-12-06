package Util;

public class DP {
	
	final static String DOT = "=";
	final static int DOT_COUNT = 40;
	
	public static void line() {
		
		Command.Wn("");
		for(int i=0;i<DOT_COUNT;i++) {
			Command.pr(DOT);
		}
		Command.Wn("");
	}
	
	public static void title() {
		line();
		Command.pr(" *** Cat Cafe Kiosk ***");
		line();
	}
	
}
