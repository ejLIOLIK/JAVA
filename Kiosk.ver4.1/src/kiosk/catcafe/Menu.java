package kiosk.catcafe;

import java.util.ArrayList;

// 사용X

public class Menu {
	
	ArrayList<Product> menulist = new ArrayList<>();
	String name;
	int seq;
	
	Menu(Product p[], String name, int seq) {
		
		for(int i=0;i<p.length;i++)
		{
			this.menulist.add(p[i]);
		}
		
		this.name = name;
		this.seq = seq;
	}
} 
