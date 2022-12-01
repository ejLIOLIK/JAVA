package RPGpack;

public class Character {
	String name;
	int hp;
	int attack;
	int fullHp;
	int exp = 0;
	int fullExp = 300;
	int gold = 0;
	int id;
	
	void info() {
		System.out.println(
				this.name + "[" + this.hp + "/" + this.fullHp + "]" + "(exp:" + this.exp + "/" + this.fullExp + ") " + this.gold + "G");
	}
	
	//생성자 함수
	Character(String n, int h, int a, int id){
		this.name = n;
		this.hp = h;
		this.fullHp = h;
		this.attack = a;
		this.id = id;
	}
}
