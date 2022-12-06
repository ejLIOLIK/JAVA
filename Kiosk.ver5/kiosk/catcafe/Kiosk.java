package kiosk.catcafe;
import java.util.ArrayList;

import Util.Command;
import Util.DP;

public class Kiosk {
	
	void run() {

		KioskObj.productInit(); //상품 리스트 등록
		procMenu menu = new procMenu(); //메뉴 선택 받는 프로세스
						
		DP.title();

		menuPrint("식사", KioskObj.food); // 메뉴판 출력
		menuPrint("음료", KioskObj.drink);
		menuPrint("디저트", KioskObj.desert);
		menuPrint("고양이간식", KioskObj.catfood);
		
		DP.line();
		
		loop_a: while (true) { // 주문 받는 루프
			
			Command.Wn("");
			Command.Wn("[1.식사 / 2.음료 / 3.디저트 / 4.고양이간식]");
			Command.Wn("[x.주문완료 / c.주문취소 / v.장바구니]");

			KioskObj.cmd = KioskObj.sc.next(); //키 입력

			switch (KioskObj.cmd) {
			case "1":
				Command.Wn("[1.식사]");
				menu.Run(KioskObj.food);			
				break;
			case "2":
				Command.Wn("[2.음료]");
				menu.Run(KioskObj.drink);			
				break;
			case "3":
				Command.Wn("[3.디저트]");
				menu.Run(KioskObj.desert);			
				break;
			case "4":
				Command.Wn("[4.고양이간식]");
				menu.Run(KioskObj.catfood);			
				break;
			case "c":
				KioskObj.basket.clear();
				Command.Wn("주문이 취소됩니다.");
				DP.line();
				break;
			case "x":
				break loop_a;
			case "v":
				cartList(KioskObj.basket);
				break;
			default:
			}
		}

		orderList(KioskObj.basket);
		Command.Wn("주문이 완료되었습니다.");

		KioskObj.sc.close();
	}

	// 메뉴판 출력
	public static void menuPrint(String str, ArrayList<Product> p) {

		Command.Wn("* "+str+" *");
		for(Product tmp :p) {
			tmp.info();
		}
	}

	//str의 제품이 CountArray에 총 몇 개 있는지 출력
	static void findPro(ArrayList<Product> p, String str) {
		for(Product tmp:p) {
			if(tmp.name.equals(str)) { //이용자가 입력한 제품명을 상품 리스트에서 찾아냄
				KioskObj.basket.add(tmp); // 장바구니 리스트에 해당 상품 추가
				System.out.println(tmp.name + " 선택 (총 " + CountArray(KioskObj.basket, str) + "개)");
			}
		}
	}

	//주문 완료
	static void orderList(ArrayList<Product> basket) {

		int sum = 0;

		DP.line();
		Command.pr("주문 내역 : \n");
		
		for (int i = 0; i < basket.size(); i++) {
			Command.Wn(
					basket.get(i).name + "(" + basket.get(i).price + "원) " + CountArray(basket, basket.get(i).name)
					+ "개 / 총액 : " + basket.get(i).price * CountArray(basket, basket.get(i).name)+"원 \n");
			
			sum = sum + basket.get(i).price * CountArray(basket, basket.get(i).name);
			
			for (int j = i + 1; j < basket.size(); j++) { // 뒤에 남은 같은 제품 정보 삭제
				if (basket.get(i).name.equals(basket.get(j).name)) {
					basket.remove(j);
					j--; // 당겨진 제품 리스트에 맞춰서 한 자리 당김
				}
			}
		}

		Command.Wn("\n ** 합계 : " + sum + "원");
		DP.line();
	}

	//장바구니 조회
	static void cartList(ArrayList<Product> basket) {

		int sum = 0;

		ArrayList<String> str = new ArrayList<>(); //주문된 제품명만 입력
		boolean strTF = true; //이미 출력한 제품명인지 
		int count; //수량 저장

		DP.line();
		Command.Wn("장바구니 내역 : ");

		for (Product bas : basket) {
			for (String s : str) {
				if (bas.name.equals(s)) {
					strTF = false;
					break;
				}
			}

			if (strTF) {
				count = CountArray(basket, bas.name); //주문 수량 확인

				Command.Wn(bas.name + "(" + bas.price + "원) " + count + "개 / 총액 : " + count * bas.price + "원");
				sum = sum + bas.price * count; // 합계 계산
				
				str.add(bas.name);
			} 
			else {
				strTF = true;
			}
		}
		Command.Wn("\n ** 합계 : " + sum + "원");
		DP.line();
	}

	// str 상품이 장바구니에 든 수량을 리턴
	static int CountArray(ArrayList<Product> basket, String str) {
		
		int order = 0;
		for(Product bas:basket) {
			if(bas.name.equals(str)) {
				order++;
			}
		}
		
		return order;
	}
}
