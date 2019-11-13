package Kattis;

import java.util.Scanner;

public class Oddities {

	/**
	 * https://open.kattis.com/problems/oddities
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numCases = scanner.nextInt();
		for (int i = 0; i < numCases; i++){
			int numToEvaluate = scanner.nextInt();
			if (numToEvaluate % 2 == 0){
				System.out.println(numToEvaluate + " is even");
			} else {
				System.out.println(numToEvaluate + " is odd");
			}
		}
	}
}