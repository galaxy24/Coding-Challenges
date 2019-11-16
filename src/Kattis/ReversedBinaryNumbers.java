package Kattis;

import java.util.Scanner;

class ReversedBinaryNumbers {

	/**
	 * https://open.kattis.com/problems/reversebinary
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder string = new StringBuilder(Integer.toBinaryString(scanner.nextInt())).reverse();
		System.out.println(Integer.parseInt(string.toString(), 2));
	}
}