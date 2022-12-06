package Util;

public class DP {
	
	final static String DOT = "=";
	final static int DOT_COUNT = 40;
	
	public static void line() {
		for(int i=0;i<DOT_COUNT;i++) {
			Command.pr(DOT);
		}
	}
	
	public static void title() {
		line();
		Command.pr(" \n*** Cat Cafe Kiosk ***\n");
	}
	
}
