package RPGpack;

import java.util.Scanner;
import Utilpack.Util;

public class Main {
	public static void main(String[] args) {

		Character elf = new Character("레골라스", 100, 20, 1000);
		Monster orc = new Monster("오크족장", 50, 30, 100, 10, 1006);
		Scanner sc = new Scanner(System.in);
		boolean bat = false; // 전투 true 전투 종료 false
		int turn = 1; // 턴 카운트
		//int tempId = elf.id;
		
		Monster mob[] = new Monster[] {new Monster("허수아비1", 30, 0, 50, 0, 0),
				new Monster("허수아비2", 30, 0, 50, 0, 0),
				new Monster("허수아비3", 30, 0, 50, 0, 0),
				new Monster("쥐1", 50, 15, 80, 10, 0),
				new Monster("쥐3", 50, 15, 80, 10, 0),
				new Monster("왕쥐", 100, 30, 120, 50, 0),
				};
		
		Room map[] = new Room[]{new Room("연습장 입구","연습장으로 들어가는 입구다.",1000,1001,0,0,0,0,0),
				new Room("연습장 서쪽","연습장 서쪽이다.",1001,1002,1000,0,0,0,0),
				new Room("연습장 중앙","연습장 중앙이다.",1002,0,1001,1004,1003,1005,1006),
				new Room("연습장 북쪽","연습장 북쪽이다.",1003,0,0,1002,0,0,0),
				new Room("연습장 남쪽","연습장 남쪽이다.",1004,0,0,0,1002,0,0),
				new Room("연습장 누각","연습장 누각이다.",1005,0,0,0,0,0,1002),
				new Room("연습장 지하","연습장 지하다.",1006,0,0,0,0,1002,0),
				};
		
		elf.info();
		System.out.println();

		if(findRoom(map, elf.id)==-1) { System.out.println("Error : findRoom");}
				
		while(true) {
			
			map[(findRoom(map, elf.id))].infoRoom();

			if(bat) {
				battleStart();
				String key = sc.next();

				if (key.equals("go")) {
					System.out.println("턴 " + turn + " :");
					bat = battle(elf, orc);
					turn++;
				} 
				else if (key.equals("end")) {
					System.out.println(" *** 종료 *** ");
					break;
				}
//				else if (key.equals("동")||key.equals("서")||key.equals("남")||key.equals("북")||key.equals("위")||key.equals("밑")) {
//					//도망
//				}				

				if (bat == false) {
					battleEnd(elf, orc);
					break;
				}
				
			}
			else {
				moveStart();
				String key = sc.next();
				
				if (key.equals("동")||key.equals("서")||key.equals("남")||key.equals("북")||key.equals("위")||key.equals("밑")) {
					//System.out.println(key + "입력OK");
					elf.id = Move(map[(findRoom(map, elf.id))], key);
				}
				else if(key.equals("end")) {
					System.out.println(" *** 종료 *** ");
					break;
				}
				
			}
		}
		sc.close();
		
		
	}
	
	// 전투 시작
	static void battleStart() {
		
		System.out.println(" *** 전투 시작 *** ");
		System.out.println(" 진행 키 : go / 이동 방향 / end ");

	}
	static void moveStart() {
		
		System.out.println(" 진행 키 : 이동 방향 / end ");
	}
	
	static boolean battle(Character cha, Monster mon) {
		
		int pointCha, pointMon;

		pointCha = Util.random(cha.attack, 0);
		pointMon = Util.random(mon.attack, 0);

		System.out.println(mon.name + "이/가 " + cha.name + "에게 " + pointMon + "의 데미지.");
		System.out.println(cha.name + "이/가 " + mon.name + "에게 " + pointCha + "의 데미지.");

		cha.hp = cha.hp - pointMon;
		mon.hp = mon.hp - pointCha;

		infoPrint(cha, mon);

		if (mon.hp <= 0 || cha.hp <= 0) {
			return false;
		} else {
			return true;
		}
	}
	
	static void battleEnd(Character cha, Monster mon) {
		
		int winGold;

		System.out.println(" *** 전투 종료 *** ");

		if(cha.hp<=0 && mon.hp<=0) {
			System.out.println(" *** DRAW *** ");
			mon.life = false; // 몬스터 사망처리
		}
		else if(cha.hp<=0) { 
			System.out.println(" *** DEPEAT *** ");
		}
		else if(mon.hp<=0) {
			System.out.println(" *** WIN *** ");
			cha.exp = cha.exp + mon.exp;
			System.out.println(cha.name +"이/가 " +mon.exp + "경험치를 획득");
			winGold = cha.gold + Util.random(mon.gold, 0);
			System.out.println(cha.name +"이/가 " +winGold + "골드를 획득");
			cha.gold = cha.gold + winGold;
			mon.life = false; // 몬스터 사망처리
			
			cha.info();
		}
		else {
			System.out.println("Error : battleEnd");
		}
	}
	
	static void infoPrint(Character cha, Monster mon) {
		cha.info();
		mon.info();
	}
	
	static int findRoom(Room r[], int userID) {
		for(int i=0;i<r.length;i++) {
			if(userID==r[i].id) {
				return i;
			}
		}
		
		return -1;
	}
	
	static int Move(Room r, String key){

		int vec=-1;

		switch (key) {
		case "동":
			vec = r.e;
			break;
		case "서":
			vec = r.w;
			break;
		case "남":
			vec = r.s;
			break;
		case "북":
			vec = r.n;
			break;
		case "위":
			vec = r.u;
			break;
		case "밑":
			vec = r.d;
			break;
		default:
		}

		if(vec==0) {
			System.out.println("이동할 수 없습니다.");
			return r.id;
		}
			
		return vec;
		
	}
		
	

	
}
