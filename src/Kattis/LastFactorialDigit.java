package Kattis;

import java.util.Scanner;

public class LastFactorialDigit {
	/**
	 * https://open.kattis.com/problems/lastfactorialdigit
	 */
	public static void calculate(Scanner scanner){
		scanner.nextLine();
		while (scanner.hasNext()){
			int number = Integer.parseInt(scanner.nextLine());
			int result = 1;
			for (int i = 1; i <= number; i++){
				result = result * i;
			}
			System.out.println(result % 10);
//            scanner.nextLine();
		}
//        System.out.println("My factorial was: " + result);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LastFactorialDigit.calculate(sc);
	}
}