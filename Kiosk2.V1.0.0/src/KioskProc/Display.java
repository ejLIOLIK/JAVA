package KioskProc;

import ProductPcg.Product;
import ProductPcg.prdBook;
import ProductPcg.prdCatfood;
import ProductPcg.prdDesert;
import ProductPcg.prdDrink;
import ProductPcg.prdFood;
import ProductPcg.prdOrder;

public class Display {
	
	final static String DOT = "-";
	final static int DOT_COUNT = 45;
	
	public static void MenuDP() {
		
		Display.Line();
		
		int nOrder=1;
		
		System.out.println("* 식사 메뉴 *"); ///////////////////////////
		for (Product p : Setting.prdlist) {
			if (p instanceof prdFood) {
				System.out.print(nOrder+ ". " + p.name + "(" + p.price + "원)  ");
				nOrder++;
			}
		}
		System.out.println(""); 
		System.out.println("* 음료 메뉴 *"); ///////////////////////////
		for (Product p : Setting.prdlist) {
			if (p instanceof prdDrink) {
				System.out.print(nOrder+ ". " + p.name + "(" + p.price + "원)  ");
				nOrder++;
			}
		}
		System.out.println(""); 
		System.out.println("* 디저트 메뉴 *"); ///////////////////////////
		for (Product p : Setting.prdlist) {
			if (p instanceof prdDesert) {
				System.out.print(nOrder+ ". " + p.name + "(" + p.price + "원)  ");
				nOrder++;
			}
		}
		System.out.println("");
		System.out.println("* 고양이 메뉴 *"); ///////////////////////////
		for (Product p : Setting.prdlist) {
			if (p instanceof prdCatfood) {
				System.out.print(nOrder+ ". " + p.name + "(" + p.price + "원)  ");
				nOrder++;
			}
		}
		System.out.println(""); 
		System.out.println("* 책 대여 * "); ///////////////////////////
		for (Product p : Setting.prdlist) {
			if (p instanceof prdBook) {
				System.out.print(nOrder+ ". " + p.name + "(" + p.price + "원)  ");
				nOrder++;
			}
		}	
		System.out.println(""); 
		
		Display.Line();
	}
	
	public static void Line() {
		for(int i=0;i<DOT_COUNT;i++) {
			System.out.print(DOT);
		}
		System.out.println("");
	}
	
	public static void erMsg() {
		System.out.println("다시 입력해주세요.");
	}
	
	public static void VasketList() {

		int sum = 0;
		
		Display.Line();
		
		System.out.println(" **주문 내역");

		for (prdOrder o : Setting.basket) {
			
			System.out.print(o.p.name + " ");
			System.out.print("(" + o.p.price + "원) ");
			
			if(o.p instanceof prdDrink) {
				
				switch(((prdDrink)o.p).icehot) { // 아이스 핫
				case 0 : 
					System.out.println("\n ice (+500원)");
					break;
				case 1 :
					System.out.println("\n hot (+0원)");					
					break;
					default:
				}
				//System.out.print();
				switch(((prdDrink)o.p).sylup) { // 시럽 종류
				case -1 :
					System.out.print(" 시럽 없음 (+0원)");
					break;
				case 0 :
					System.out.print(" 바닐라시럽 (+500원)");
					break;
				case 1 :
					System.out.print(" 헤이즐넛시럽 (+500원)");
					break;
					default:
				}
				
				System.out.print("	-- " + (((prdDrink)o.p).optPrice) + "원 " + o.amount + "개	" + (((prdDrink)o.p).optPrice * o.amount) +"원 \n");
				//
				sum = sum + (((prdDrink)o.p).optPrice * o.amount);
			}
			else {
				System.out.print("		-- " + o.amount + "개	" + (o.p.price * o.amount) +"원 \n");
				//
				sum = sum + (o.p.price * o.amount);
			}

		}

		System.out.println("\n	 **총 " + sum + "원");
		
		Display.Line();
	}
	
	

}
