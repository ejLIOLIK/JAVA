package kiosk.catcafe;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		// 컨트롤 시프트 오 자동임포트
		Scanner sc = new Scanner(System.in);
		String cmd;

		Product p[]  = new Product[]{new Product("라면", 3500),
				new Product("김밥", 3500),
				new Product("아이스아메리카노", 2500),
				new Product("콜라", 2000),
				new Product("마카롱", 2500),
				new Product("샌드위치", 4500),
				new Product("츄르", 2000),
				new Product("참치캔", 4000)};
		
		menuPrint(p);
		
		loop_a:
		while(true) {
			System.out.print("[1.식사 / 2.음료 / 3.디저트 / 4.고양이간식 / x.주문종료]");
			cmd = sc.next();
			
			switch(cmd) {
			case "1":
				System.out.println("[1.식사 선택]");
				
				loop_b:
				while (true) {
					System.out.print("식사 [1.라면 / 2.김밥] / x.이전메뉴");
					cmd = sc.next();
					switch (cmd) {
					case "1":
						findPro(p,"라면");
						break;
					case "2":
						findPro(p,"김밥");
						break;
					case "x":
						break loop_b;
					}
				}
				
				break;
			case "2":
				System.out.println("[2.음료 선택]");
								
				loop_c:
					while (true) {
						System.out.print("음료 [1.아이스아메리카노 / 2.콜라] / x.이전메뉴");
						cmd = sc.next();
						switch (cmd) {
						case "1":
							findPro(p,"아이스아메리카노");
							break;
						case "2":
							findPro(p,"콜라");
							break;
						case "x":
							break loop_c;
						}
					}
				break;
			case "3":
				System.out.println("[3.디저트 선택]");
				
				loop_d:
					while (true) {
						System.out.print("디저트 [1.마카롱 / 2.샌드위치] / x.이전메뉴");
						cmd = sc.next();
						switch (cmd) {
						case "1":
							findPro(p,"마카롱");
							break;
						case "2":
							findPro(p,"샌드위치");
							break;
						case "x":
							break loop_d;
						}
					}
				break;
			case "4":
				System.out.println("[4.고양이간식 선택]");
				
				loop_e:
					while (true) {
						System.out.print("고양이 간식 [1.츄르 / 2.참치캔] / x.이전메뉴");
						cmd = sc.next();
						switch (cmd) {
						case "1":
							findPro(p,"츄르");
							break;
						case "2":
							findPro(p,"참치캔");
							break;
						case "x":
							break loop_e;
						}
					}
				break;
			case "x":
				break loop_a;
			}			
		}
		System.out.println("프로그램 종료");
		orderList(p);
		
		sc.close();
	}
	
	
	static void menuPrint(Product p[]) {
		System.out.println("=======================================");
		System.out.println(" *** Cat Cafe Kiosk ***");
		
		for(int i=0;i<p.length;i++) {
			p[i].info();
		}
		System.out.println("=======================================");
	}
	
	static void findPro(Product p[], String str) {
		
		for(int i=0;i<p.length;i++) {

			if(p[i].name.equals(str)) {
				p[i].order++;
				System.out.println(p[i].name + " 선택 (총"+p[i].order+"개)");
			}
			
			if(i==p.length) {
			System.out.println("Error : find Product");
			}
		}
	}
	
	static void orderList(Product p[]) {
		
		int sum=0;
		
		System.out.println("=======================================");
		System.out.println("주문내역 : ");
		
		for(int i=0;i<p.length;i++) {
			
			if(p[i].order>0) {
				System.out.println(p[i].name + "(" + p[i].price + "원) " + p[i].order + "개 /" + p[i].price*p[i].order);
				sum = sum + p[i].price*p[i].order;
			}
			
		}
		
		System.out.println(" ** 총액 : "+sum+"원");
		System.out.println("=======================================");
	}
}

