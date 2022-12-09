package KioskProc;

import Admin.Admin;

public class Main {
	
	final static String KIOSK_VER = "## 키오스크2 V1.0.0 ##";

	public static void main(String[] args) {

		boolean blAdmin = true; //관리자모드로 시작
		
		System.out.println(KIOSK_VER);
		System.out.println("");
		
		// 관리자모드
		Admin admin = new Admin();
		// 키오스크모드
		Kiosk kio = new Kiosk();

		// 제품리스트 기본 세팅
		Setting.productInit();

		while(true) {
			if (blAdmin) {
				System.out.println("관리자 모드입니다.");
				blAdmin = admin.run();
			} else {
				// 키오스트에 자동진입
				System.out.println("키오스크 모드입니다.");
				blAdmin = kio.run();
			}
		}
	}

}
