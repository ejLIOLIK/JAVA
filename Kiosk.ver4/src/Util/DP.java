package Util;

public class DP {
	
	final static String DOT = "=";
	
	public static void line() {
		for(int i=0;i<40;i++) {
			Command.pr(DOT);
		}
	}
	
	public static void title() {
		line();
		Command.pr(" \n*** Cat Cafe Kiosk ***\n");
	}
	
}
