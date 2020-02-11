package Kattis;

import java.util.Scanner;

class Bijele {

	/**
	 * https://open.kattis.com/problems/bijele
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int kings = scanner.nextInt();
		int queens = scanner.nextInt();
		int rooks = scanner.nextInt();
		int bishops = scanner.nextInt();
		int knights = scanner.nextInt();
		int pawns = scanner.nextInt();
		System.out.println((1 - kings) + " " + (1 - queens) + " " + (2 - rooks) + " " + (2 - bishops) + " " + (2 - knights) + " " + (8 - pawns));
		scanner.close();
	}
}