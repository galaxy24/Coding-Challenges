package Kattis;

import java.util.Scanner;

public class Pot {

	/**
	 * https://open.kattis.com/problems/pot
	 * @param args
	 */

	public static void main(String[] args) {
		int result = 0;
		Scanner scanner = new Scanner(System.in);
		int iterations = scanner.nextInt();
		for(int i = 0 ; i < iterations; i++){
			int number = scanner.nextInt();
			result = result + ((int) Math.pow((double) (number / 10), (double) (number % 10)));
		}
		System.out.println(result);
	}
}