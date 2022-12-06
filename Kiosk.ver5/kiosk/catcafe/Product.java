package kiosk.catcafe;

public class Product {

	String name;
	int price;
	
	Product(String name, int price){
		this.name = name;
		this.price = price;
	}
	
	public void info() {
		System.out.println(name + " " + price +"원");
	}
}
