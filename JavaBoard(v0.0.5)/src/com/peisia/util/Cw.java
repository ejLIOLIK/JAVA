package com.peisia.util;

public class Cw {
	private static final String DOT = "πβ";
	private static final int LINE_LENGTH = 32;
	public static void w(String s) {
		System.out.print(s);
	}
	public static void wn(String s) {
		System.out.println(s);
	}
	// wn ν¨μ - μ€λ²λ‘λ©
	// κ·Έλ₯ μν°νλ λ£μ΄μ£Όλ ν¨μ.
	public static void wn() {
		System.out.println();
	}
	/* 
	 * μ  κΈλ ν¨μ
	 * */
	public static void line() {
		for(int i=0;i<LINE_LENGTH;i++) {
			w(DOT);
		}
		wn();
	}
	public static void dot() {
		w(DOT);
	}
	public static void space(int c) {
		for(int i=0;i<c;i++) {
			w(" ");
		}
	}
}
