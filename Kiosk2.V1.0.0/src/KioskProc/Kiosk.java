package KioskProc;

//import ProductPcg.Product;
import ProductPcg.prdBook;
import ProductPcg.prdDrink;
import ProductPcg.prdOrder;

public class Kiosk {

	int run() {

		while (true) {

			Display.MenuDP();

			System.out.println("");

			loop_a: while (true) { // 주문 받는 루프

				System.out.println("메뉴 번호 또는 메뉴 이름을 입력하세요.");
				System.out.println("x.주문완료 / c.주문취소 / v.장바구니");
				Setting.cmd = Setting.sc.next(); // 키 입력

				switch (Setting.cmd) {
				case "admin":
					return 1;
				case "c":
					Setting.basket.clear();
					System.out.println("주문이 취소됩니다.");
					Display.Line();
					break;
				case "x":
					Display.VasketList();
					OrderList();
					System.out.println("주문이 등록되었습니다.");
					System.out.println("		주문 번호 : " + Setting.orderlist.size());
					Display.Line();
					break loop_a;
				case "v":
					Display.VasketList();
					break;
				default:
					getBasket();
					
				}
			}
		}
	}

	void getBasket() { // 주문서에 추가하기

		int nOrder;

		try { // 숫자임
			nOrder = Integer.parseInt(Setting.cmd);
			getBasketAmount(nOrder - 1);
			Setting.basketSort(); //장바구니 정리 (기존 주문제품과 동일한 제품 주문입력 시 수량 합치고 삭제)

			return;

		} catch (NumberFormatException e) {

			for (int i = 0; i < Setting.prdlist.size(); i++) {

				if (Setting.prdlist.get(i).name.equals(Setting.cmd)) {
					getBasketAmount(i);
					Setting.basketSort(); //장바구니 정리 (기존 주문제품과 동일한 제품 주문입력 시 수량 합치고 삭제)
					
					return;
				}
			}

			Display.erMsg();
//			System.out.println("다시 입력해주세요.");
		}

	}

	void getBasketAmount(int n) {

		int Amount;
		prdOrder tmp = new prdOrder();

		// 음료 (커피 옵션 고려) //////////////////////////////
		if (Setting.prdlist.get(n) instanceof prdDrink) {
			
			System.out.println("주문 수량을 입력하세요.");
			Amount = Setting.sc.nextInt(); // 키 입력
			tmp.amount = Amount;

			prdDrink tmpD = new prdDrink(Setting.prdlist.get(n).name, Setting.prdlist.get(n).price);

			tmpD.icehotPick();

			if (((prdDrink) Setting.prdlist.get(n)).blsylup) { //시럽 true일 때만 (밀크티 같은 건 시럽 불가)
				tmpD.sylPick();
			}

			tmpD.coffeeOption(); // 옵션에 따른 가격변동
//			tmp.p = ((Product) tmpD);
			tmp.p = tmpD;

		}
		else if (Setting.prdlist.get(n) instanceof prdBook) {

			System.out.println("대여 도서 코드를 입력하세요.");

			Loop_bookQ : while (true) {
				Amount = Setting.sc.nextInt(); // 키 입력

				for (int i = 0; i < Setting.novel.size(); i++) {
					if (Setting.novel.get(i).bookCode == Amount) {
						System.out.println(Setting.novel.get(i).bookCode + " " + Setting.novel.get(i).name + " 대여 확인");
						
						tmp.p = new prdBook(Setting.novel.get(i).name, Setting.novel.get(i).bookNewOld(), Setting.novel.get(i).bookCode);
						tmp.amount = 1;
						
						break Loop_bookQ;
					}
					if (i == Setting.novel.size() - 1) {
						Display.erMsg();
					}
				}
			}
		}
		else {
			// 일반제품군 ///////////////////////////////////////
			System.out.println("주문 수량을 입력하세요.");
			Amount = Setting.sc.nextInt(); // 키 입력
			tmp.amount = Amount;
			
			tmp.p = Setting.prdlist.get(n);

		}
		Setting.basket.add(tmp);
	}

	void OrderList() {

		String strTmp = "";
		int sum = 0;

		for (prdOrder o : Setting.basket) {

			strTmp+= o.p.name + " ";
			strTmp+= "(" + o.p.price + "원) ";
			
			if(o.p instanceof prdDrink) {
				
				switch(((prdDrink)o.p).icehot) { // 아이스 핫
				case 0 : 
					strTmp+= "\n ice (+500원)\n";
					break;
				case 1 :
					strTmp+= "\n hot (+0원)\n";					
					break;
					default:
				}
				
				switch(((prdDrink)o.p).sylup) { // 시럽 종류
				case -1 :
					strTmp+= " 시럽 없음 (+0원)";
					break;
				case 0 :
					strTmp+= " 바닐라시럽 (+500원)";
					break;
				case 1 :
					strTmp+= " 헤이즐넛시럽 (+500원)";
					break;
					default:
				}
				
				strTmp+= "	-- " + (((prdDrink)o.p).optPrice) + "원 " + o.amount + "개	" + (((prdDrink)o.p).optPrice * o.amount) +"원 \n";
				//
				sum = sum + (((prdDrink)o.p).optPrice * o.amount); // 옵션가격 포함
			}
			else{
				strTmp+= "		-- " + o.amount + "개	" + (o.p.price * o.amount) +"원 \n";
				//
				sum = sum + (o.p.price * o.amount);
			}
		}

		strTmp = strTmp + "\n 		**총 " + sum + "원\n";
		
		Setting.sumOrderlist +=sum;
		Setting.orderlist.add(strTmp);
		Setting.basket.clear();
	}
}
