package Kattis;

import java.util.Scanner;

/**
 * https://open.kattis.com/problems/timeloop
 */
class StuckInATimeLoop {


	private int number;

	public StuckInATimeLoop(int number) {
		this.number = number;
		if (1 <= number && number <= 100) {
			for (int i = 1; i <= number; i++) {
				System.out.println(i + " Abracadabra");
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StuckInATimeLoop s = new StuckInATimeLoop(sc.nextInt());
	}
}