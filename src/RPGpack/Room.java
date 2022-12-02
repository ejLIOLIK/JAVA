package RPGpack;

public class Room {

	// 방 이름, 설명, ID, 동서남북위밑
	String name;
	String condition;
	int id;
	int e, w, s, n, u, d;
		
	// 생성자 룸인포 룸엔터
	Room(String name, String con, int id, int e, int w, int s, int n, int u, int d){
		
		this.name = name;
		this.condition = con;
		this.id = id;
		this.e = e;
		this.w = w;
		this.s = s;
		this.n = n;
		this.u = u;
		this.d = d;
	}
	
	void infoRoom() {
		System.out.println("["+name +"] "+ this.condition);
		enterRoom();
	}
	
	void enterRoom() {
		String str = "";
		if(this.e != 0) {
			str = str+ "동 ";}
		if(this.w != 0) {
			str = str+ "서 ";}
		if(this.s != 0) {
			str = str+ "남 ";}
		if(this.n != 0) {
			str = str+ "북 ";}
		if(this.u != 0) {
			str = str+ "위 ";}
		if(this.d != 0) {
			str = str+ "밑 ";}
		
		System.out.println(" 이동 가능 : " + str);}
	
}
