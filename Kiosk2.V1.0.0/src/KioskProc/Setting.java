package KioskProc;

import java.util.ArrayList;
import java.util.Scanner;

import ProductPcg.Product;
import ProductPcg.prdBook;
import ProductPcg.prdCatfood;
import ProductPcg.prdDesert;
import ProductPcg.prdDrink;
import ProductPcg.prdFood;
import ProductPcg.prdOrder;

public class Setting {
	
	public static ArrayList<Product> prdlist = new ArrayList<>(); // 제품목록
	public static ArrayList<prdOrder> basket = new ArrayList<>(); // 장바구니
	
	public static ArrayList<String> orderlist = new ArrayList<>(); // 주문서목록
	public static int sumOrderlist = 0;
	

	// 컨트롤 시프트 오 자동임포트
	public static Scanner sc = new Scanner(System.in);
	public static String cmd;

	public static void productInit() {

		prdlist.add(new prdFood("라면", 3500)); 
		prdlist.add(new prdFood("야채김밥", 3000));

		prdlist.add(new prdDrink("아메리카노", 2500, true)); //true = 시럽 옵션 가능
		prdlist.add(new prdDrink("라떼", 2000, true));
		prdlist.add(new prdDrink("밀크티", 2000, false)); //false = 시럽 옵션 불가능

		prdlist.add(new prdDesert("마카롱", 2500));
		prdlist.add(new prdDesert("샌드위치", 4500));
		prdlist.add(new prdDesert("와플", 3000));

		prdlist.add(new prdCatfood("츄르", 1000));
		prdlist.add(new prdCatfood("참치캔", 4000));
		prdlist.add(new prdCatfood("북어펠릿", 2000));

		prdlist.add(new prdBook("신간", 700));
		prdlist.add(new prdBook("일반", 500));

	}
	
	public static void basketSort() { //추가입력된 같은 제품을 정리
		
		for(int i = 0;i<basket.size();i++) {
			
			if(i==(basket.size()-1)) {	// 같은 거 서로 비교 X
				break;
			}
			
			if(basket.get(i).p instanceof prdDrink) { // 음료수는 옵션 비교
				if(((prdDrink)basket.get(i).p).blsylup) { // 시럽 옵션 있는 경우
					if(((prdDrink)basket.get(i).p).sylup==((prdDrink)basket.get(basket.size() - 1).p).sylup
							&& ((prdDrink)basket.get(i).p).icehot==((prdDrink)basket.get(basket.size() - 1).p).icehot)
					{	// 아이스핫, 시럽종까지 동일해야 수량 합침
						basket.get(i).amount += basket.get(basket.size() - 1).amount;
						basket.remove(basket.size() - 1);
						break;
					}
				}
			}
			else {
				// 동일한 제품명인 경우 거기에 amount 더해주고 해당 주문 삭제
				if (basket.get(basket.size() - 1).p.name.equals(basket.get(i).p.name)) {
					basket.get(i).amount += basket.get(basket.size() - 1).amount;
					basket.remove(basket.size() - 1);
					break;
				}
			}
			
		}
	}

}


