package RPGpack;

public class Monster {
	String name;
	int hp;
	int attack;
	int fullHp;
	int exp;
	int gold;
	boolean life;
	int id;
	
	void info() {
		System.out.println(this.name + "[" +this.hp+ "/" +this.fullHp+ "]");
	}
	
	//생성자 함수
	Monster(String n, int h, int a, int e, int g, int id){
		this.name = n;
		this.hp = h;
		this.fullHp = h;
		this.attack = a;
		this.exp = e;
		this.gold = g;
		this.life=true;
		this.id=id;
	}
}
