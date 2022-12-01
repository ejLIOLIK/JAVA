package Utilpack;

public class Util {
	
	//랜덤 리턴
	public static int random(int scale, int point) {
		int ran = (int)(Math.random()*scale + point);
		return ran;
	}

}
