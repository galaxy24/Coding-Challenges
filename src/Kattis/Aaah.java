package Kattis;

import java.util.Scanner;

class Aaah {

	/**
	 * https://open.kattis.com/problems/aaah
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int produced = scanner.nextLine().length();
		int required = scanner.nextLine().length();

		if (produced < required){
			System.out.println("no");
		} else {
			System.out.println("go");
		}
		scanner.close();
	}
}