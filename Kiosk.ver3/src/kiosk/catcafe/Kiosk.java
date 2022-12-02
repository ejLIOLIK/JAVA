package kiosk.catcafe;

import java.util.ArrayList;
import java.util.Scanner;

public class Kiosk {

	// 컨트롤 시프트 오 자동임포트
	Scanner sc = new Scanner(System.in);
	String cmd;

	// ArrayList 를 이용해서 주문 수량을 수집하는 형식으로 수정함
	ArrayList<Product> basket = new ArrayList<Product>();

	Product p[] = new Product[] { new Product("라면", 3500), new Product("김밥", 3500), new Product("아이스아메리카노", 2500),
			new Product("콜라", 2000), new Product("마카롱", 2500), new Product("샌드위치", 4500), new Product("츄르", 2000),
			new Product("참치캔", 4000) };

	void run() {

		menuPrint(p);

		loop_a: while (true) {
			System.out.println("[1.식사 / 2.음료 / 3.디저트 / 4.고양이간식]");
			System.out.println("[x.주문완료 / c.주문취소 / v.장바구니]");

			cmd = sc.next();

			switch (cmd) {
			case "1":
				System.out.println("[1.식사 선택]");

				loop_b: while (true) {
					System.out.print("식사 [1.라면 / 2.김밥] / x.이전메뉴");
					cmd = sc.next();
					switch (cmd) {
					case "1":
						findPro(p, "라면", basket);
						break;
					case "2":
						findPro(p, "김밥", basket);
						break;
					case "x":
						break loop_b;
					}
				}

				break;
			case "2":
				System.out.println("[2.음료 선택]");

				loop_c: while (true) {
					System.out.print("음료 [1.아이스아메리카노 / 2.콜라] / x.이전메뉴");
					cmd = sc.next();
					switch (cmd) {
					case "1":
						findPro(p, "아이스아메리카노", basket);
						break;
					case "2":
						findPro(p, "콜라", basket);
						break;
					case "x":
						break loop_c;
					}
				}
				break;
			case "3":
				System.out.println("[3.디저트 선택]");

				loop_d: while (true) {
					System.out.print("디저트 [1.마카롱 / 2.샌드위치] / x.이전메뉴");
					cmd = sc.next();
					switch (cmd) {
					case "1":
						findPro(p, "마카롱", basket);
						break;
					case "2":
						findPro(p, "샌드위치", basket);
						break;
					case "x":
						break loop_d;
					}
				}
				break;
			case "4":
				System.out.println("[4.고양이간식 선택]");

				loop_e: while (true) {
					System.out.print("고양이 간식 [1.츄르 / 2.참치캔] / x.이전메뉴");
					cmd = sc.next();
					switch (cmd) {
					case "1":
						findPro(p, "츄르", basket);
						break;
					case "2":
						findPro(p, "참치캔", basket);
						break;
					case "x":
						break loop_e;
					}
				}
				break;

			case "c":
				basket.clear();
				System.out.println("주문이 취소됩니다.");
				break;
			case "x":
				break loop_a;
			case "v":
				cartList(basket);
				break;
			}
		}

		orderList(basket);
		System.out.println("주문이 완료되었습니다.");

		sc.close();
	}

	// 메뉴판 출력
	static void menuPrint(Product p[]) {
		System.out.println("=======================================");
		System.out.println(" *** Cat Cafe Kiosk ***");

		for (int i = 0; i < p.length; i++) {
			p[i].info();
		}
		System.out.println("=======================================");
	}

	//str과 이름이 같은 메뉴를 찾아내서 주문수량을 추가함
	static void findPro(Product p[], String str, ArrayList<Product> basket) {

		for (int i = 0; i < p.length; i++) {
			if (p[i].name.equals(str)) {
				basket.add(p[i]);
				System.out.println(p[i].name + " 선택 (총" + CountArray(basket, str) + "개)");
			}
		}
	}

	//주문 완료
	static void orderList(ArrayList<Product> basket) {

		int sum = 0;

		System.out.println("=======================================");
		System.out.println("주문 내역 : ");

		for (int i = 0; i < basket.size(); i++) {
			System.out.println(
					basket.get(i).name + "(" + basket.get(i).price + "원) " + CountArray(basket, basket.get(i).name)
							+ "개 /" + basket.get(i).price * CountArray(basket, basket.get(i).name));

			sum = sum + basket.get(i).price * CountArray(basket, basket.get(i).name);

			for (int j = i + 1; j < basket.size(); j++) {
				if (basket.get(i).name.equals(basket.get(j).name)) {
					basket.remove(j);
					j--;
				}
			}
		}

		System.out.println(" ** 합계 : " + sum + "원");
		System.out.println("=======================================");
	}

	//장바구니 조회
	static void cartList(ArrayList<Product> basket) {

		int sum = 0;

		ArrayList<String> str = new ArrayList<>();
		boolean strTF = true;
		int count; // 수량 저장

		System.out.println("=======================================");
		System.out.println("장바구니 내역 : ");

		for (int i = 0; i < basket.size(); i++) {

			for (int j = 0; j < str.size(); j++) {
				if (basket.get(i).name.equals(str.get(j))) {
					strTF = false;
					break;
				}
			}

			if (strTF) {
				count = CountArray(basket, basket.get(i).name);

				System.out.println(basket.get(i).name + " " + count + "개 / 총액 : " + count * basket.get(i).price + "원");
				sum = sum + basket.get(i).price * count;
				str.add(basket.get(i).name);
			} else {
				strTF = true;
			}
		}

		System.out.println(" ** 총액 : " + sum + "원");
		System.out.println("=======================================");
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
