package pack00;

import java.util.Scanner;

public class Lottery {
	public static void main(String[] args) {

		int[] ran = new int[6];
		int score = 0;
		int ranBonus = (int)(Math.random()*45+1);
		
		// 랜덤 번호 6개
		for(int i=0;i<6;i++)
		{
			ran[i] = (int)(Math.random()*45+1);
			
			for(int j=0;j<i;j++) {
				if(ran[i]==ran[j]) {
					i=0;
				}
			}
		}
		
		// 보너스 번호 1개
		for(int i=0;i<6;i++) {
			if(ranBonus==ran[i]) {
				ranBonus = (int)(Math.random()*45+1);
				i=0;
			}
		}

		// 유저 번호 6개
		int[] pickNum = new int[6];
		Scanner sc1 = new Scanner(System.in);
		
		for(int i=0;i<6;i++) {
			pickNum[i] = sc1.nextInt();
		}

		for(int i=0;i<6;i++) {
			for(int j=0;j<6;j++) {
				if(ran[j]==pickNum[i]) {
					score++;
				}
			}
		}
		
		switch(score) {
		case 0:
		case 1:
		case 2:
			System.out.println("꽝");
			break;
		case 3:
			System.out.println("5등");
			break;
		case 4:
			System.out.println("4등");
			break;
		case 5:
			for(int i=0;i<6;i++){
				if(pickNum[i]==ranBonus){
					System.out.println("2등");
					break;
				}
				
				if(i==5) {
					System.out.println("3등");
				}
			}
			break;
		case 6:
			System.out.println("1등");
			break;
		}
				
		sc1.close();
			
	}
}


