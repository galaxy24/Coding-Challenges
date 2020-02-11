package Kattis;

import java.util.Scanner;

/**
 * https://open.kattis.com/problems/fizzbuzz
 */

class FizzBuzz {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int Fizz = scanner.nextInt();
		int Buzz = scanner.nextInt();
		int N = scanner.nextInt();
		for (int i = 1; i <= N; i++){
			if (i % Buzz == 0 && i % Fizz == 0){
				System.out.println("FizzBuzz");
			} else if (i % Buzz == 0){
				System.out.println("Buzz");

			} else if (i % Fizz == 0){
				System.out.println("Fizz");
			} else {
				System.out.println(i);
			}
		}
		scanner.close();
	}
}