package Kattis;

import java.util.Scanner;

public class Carrots {
	/**
	 * https://open.kattis.com/problems/carrots
	 */
	private int n;
	private int p;

	public Carrots(int p){
		System.out.println(p);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.nextInt();
		Carrots c = new Carrots(sc.nextInt());
	}
}