package Kattis;

import java.util.Scanner;

class ADifferentProblem {

	/**
	 * https://open.kattis.com/problems/different
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			long first = scanner.nextLong();
			long second = scanner.nextLong();
			System.out.println(Math.abs(first - second));
		}
	}

}