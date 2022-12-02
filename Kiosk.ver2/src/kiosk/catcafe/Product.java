package kiosk.catcafe;

public class Product {

	String name;
	int price;
//	int order=0;
	
	Product(String name, int price){
		this.name = name;
		this.price = price;
	}
	
	public void info() {
		System.out.println(name + " " + price +"원");
	}
}
