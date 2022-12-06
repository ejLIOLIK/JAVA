package kiosk.catcafe;
import java.util.ArrayList;
import java.util.Scanner;

public class KioskObj {

	// ArrayList 를 이용해서 주문 수량을 수집하는 형식으로 수정함
	public static ArrayList<Product> basket = new ArrayList<>();

	// 컨트롤 시프트 오 자동임포트
	public static Scanner sc = new Scanner(System.in);
	public static String cmd;
		
	//상품 분류별로 ArrayList 각각
	public static ArrayList<Product> food = new ArrayList<>(); 
	public static ArrayList<Product> drink = new ArrayList<>();
	public static ArrayList<Product> desert = new ArrayList<>();
	public static ArrayList<Product> catfood = new ArrayList<>();

	public static void productInit() { //상품 리스트 등록
		food.add(new Product("라면", 3500)); food.add(new Product("김밥", 3000));

		drink.add(new Product("아이스아메리카노", 2500)); drink.add(new Product("콜라", 2000));
		drink.add(new Product("아이스티",2000));	

		desert.add(new Product("마카롱", 2500));	desert.add(new Product("샌드위치", 4500));
		desert.add(new Product("와플",3000));
		
		catfood.add(new Product("츄르", 2000)); catfood.add(new Product("참치캔", 4000));
		catfood.add(new Product("캣닢", 1000)); catfood.add(new Product("북어펠릿", 2000));
	}
} 
