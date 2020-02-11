package Kattis;

import java.util.Scanner;

class R2 {

	/**
	 * https://open.kattis.com/problems/r2
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int r1 = scanner.nextInt();
		int s = scanner.nextInt();
		System.out.println(2*s - r1);
		scanner.close();
	}
}