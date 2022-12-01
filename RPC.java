package pack00;

import java.util.Scanner;

public class RPC {
	public static void main(String[] args) {
		
		Scanner user; 
		
		String pc="";
		String userStr ="";
		int r;
		String WLD="";
		int w=0, l=0, d=0;
		
		System.out.println("가위 / 바위 / 보 / 끝");
		
		while(true) {
			
			user = new Scanner(System.in);
			userStr = user.next();
			
			r = (int) (Math.random() * 3);

			switch (r) {
			case 0:
				pc = "가위";
				break;
			case 1:
				pc = "바위";
				break;
			case 2:
				pc = "보";
				break;
			default:
				pc = "Error pc random";
			}

			if (userStr.equals("가위") || userStr.equals("바위") || userStr.equals("보")) {
				
				System.out.println("user : " + userStr);
				System.out.println("pc : " + pc);
				System.out.println("");
				
				if (userStr.equals(pc)) {
					WLD="무승부"; 
				} 
				else if (userStr.equals("가위") && pc.equals("바위")) {
					WLD="패배"; 
				} 
				else if (userStr.equals("가위") && pc.equals("보")) {
					WLD="승리";
				} 
				else if (userStr.equals("바위") && pc.equals("가위")) {
					WLD="승리"; 
				} 
				else if (userStr.equals("바위") && pc.equals("보")) {
					WLD="패배"; 
				} 
				else if (userStr.equals("보") && pc.equals("가위")) {
					WLD="패배"; 
				} 
				else if (userStr.equals("보") && pc.equals("바위")) {
					WLD="승리"; 
				}
			} else if(userStr.equals("끝")){
				System.out.println("종료");
				System.out.println("전적 승 :"+ w + " 패:" + l + " 무:" + d);
				user.close();
				break;
			}
			else{
				System.out.println("ERROR user input");
			}
			
			System.out.println(WLD);
			
			if(WLD.equals("승리")){w++;}
			else if(WLD.equals("패배")){l++;}
			else if(WLD.equals("무승부")){d++;}
		}				
	}
}
