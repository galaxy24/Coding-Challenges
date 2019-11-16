package Kattis;

import java.util.Scanner;

class HelpaPhDcandidateOut {

	/**
	 * https://open.kattis.com/problems/helpaphd
	 **/

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for (int i = 1; i <= testCases; i++){
			if (scanner.nextLine().startsWith("P")){
				System.out.println("skipped");
			}
			else {
				String[] numbers = scanner.nextLine().split("+");
				System.out.println(Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]));
			}
		}
	}
}