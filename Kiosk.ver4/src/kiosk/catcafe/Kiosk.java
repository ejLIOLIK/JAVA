package kiosk.catcafe;


import java.util.ArrayList;
import java.util.Scanner;

import Util.Command;
import Util.DP;

public class Kiosk {
	
	procMenu menu = new procMenu();
	// ArrayList 를 이용해서 주문 수량을 수집하는 형식으로 수정함
	public static ArrayList<Product> basket = new ArrayList<Product>();

	// 컨트롤 시프트 오 자동임포트
	public static Scanner sc = new Scanner(System.in);
	public static String cmd;
	
	Product food[] = new Product[] { new Product("라면", 3500), new Product("김밥", 3000)};
	Product drink[] = new Product[] { new Product("아이스아메리카노", 2500), new Product("콜라", 2000)};
	Product desert[] = new Product[] { new Product("마카롱", 2500), new Product("샌드위치", 4500)};
	Product catfood[] = new Product[] { new Product("츄르", 2000), new Product("참치캔", 4000)};

	void run() {
				
		//menuPrint(p);	
		DP.title();
		menuPrint("식사", food);
		menuPrint("음료", drink);
		menuPrint("디저트", desert);
		menuPrint("고양이간식", catfood);
		DP.line();
		
		Command.pr("\n");

		loop_a: while (true) {
			Command.pr("[1.식사 / 2.음료 / 3.디저트 / 4.고양이간식]");
			Command.pr("\n[x.주문완료 / c.주문취소 / v.장바구니]");

			cmd = sc.next();

			switch (cmd) {
			case "1":
				System.out.println("[1.식사]");
				menu.Run(food);			
				break;
			case "2":
				System.out.println("[2.음료]");
				menu.Run(drink);			
				break;
			case "3":
				System.out.println("[3.디저트]");
				menu.Run(desert);			
				break;
			case "4":
				System.out.println("[4.고양이간식]");
				menu.Run(catfood);			
				break;
			case "c":
				basket.clear();
				Command.pr("주문이 취소됩니다.");
				break;
			case "x":
				break loop_a;
			case "v":
				cartList(basket);
				break;
			}
		}

		orderList(basket);
		Command.pr("\n주문이 완료되었습니다.\n");

		sc.close();
	}

	// 메뉴판 출력
	static void menuPrint(String str, Product p[]) {
//		DP.title();

		Command.pr("*"+str+"*\n");
		
		for (int i = 0; i < p.length; i++) {
			p[i].info();
		}
		
//		DP.line();
	}

	//str과 이름이 같은 메뉴를 찾아내서 주문수량을 추가함
//	static void findPro(Product p[], String str, ArrayList<Product> basket) {
	static void findPro(Product p[], String str) {

		for (int i = 0; i < p.length; i++) {
			if (p[i].name.equals(str)) {
				basket.add(p[i]);
				System.out.println(p[i].name + " 선택 (총 " + CountArray(basket, str) + "개)");
			}
		}
	}

	//주문 완료
	static void orderList(ArrayList<Product> basket) {

		int sum = 0;

		DP.line();
		Command.pr("\n주문 내역 : \n");

		for (int i = 0; i < basket.size(); i++) {
			Command.pr(
					basket.get(i).name + "(" + basket.get(i).price + "원) " + CountArray(basket, basket.get(i).name)
							+ "개 / 총액 : " + basket.get(i).price * CountArray(basket, basket.get(i).name)+"원 \n");

			sum = sum + basket.get(i).price * CountArray(basket, basket.get(i).name);

			for (int j = i + 1; j < basket.size(); j++) {
				if (basket.get(i).name.equals(basket.get(j).name)) {
					basket.remove(j);
					j--;
				}
			}
		}

		Command.pr("\n ** 합계 : " + sum + "원\n");
		DP.line();
	}

	//장바구니 조회
	static void cartList(ArrayList<Product> basket) {

		int sum = 0;

		ArrayList<String> str = new ArrayList<>();
		boolean strTF = true;
		int count; // 수량 저장

		DP.line();
		Command.pr("\n장바구니 내역 : \n");

		for (int i = 0; i < basket.size(); i++) {

			for (int j = 0; j < str.size(); j++) {
				if (basket.get(i).name.equals(str.get(j))) {
					strTF = false;
					break;
				}
			}

			if (strTF) {
				count = CountArray(basket, basket.get(i).name);

				Command.pr(basket.get(i).name + "(" + basket.get(i).price + "원) " + count + "개 / 총액 : " + count * basket.get(i).price + "원 \n");
				sum = sum + basket.get(i).price * count;
				str.add(basket.get(i).name);
			} 
			else {
				strTF = true;
			}
		}

		Command.pr("\n ** 합계 : " + sum + "원\n");
		DP.line();
		System.out.println("");
	}

	// str 상품이 장바구니에 몇 개 들어있는지를 리턴 
	static int CountArray(ArrayList<Product> basket, String str) {
		int order = 0;

		for (int i = 0; i < basket.size(); i++) {
			if (str.equals(basket.get(i).name)) {
				order++;
			}
		}
		return order;
	}
}
