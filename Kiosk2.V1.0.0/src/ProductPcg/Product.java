package ProductPcg;

public class Product {

	public String name;
	public int price;
	
	public Product(String name, int price){
		this.name = name;
		this.price = price;
	}
	
	public void info() {
		System.out.println(name + " " + price +"원");
	}
}
