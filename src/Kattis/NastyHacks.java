package Kattis;

import java.util.Scanner;

public class NastyHacks {

	/**
	 * https://open.kattis.com/problems/nastyhacks
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int caseNumbers = scanner.nextInt();
		for (int i = 0; i < caseNumbers; i++){
			int revIfNot = scanner.nextInt();
			int revIfYes = scanner.nextInt();
			int cost = scanner.nextInt();
			if ((revIfYes - cost) > (revIfNot)){
				System.out.println("advertise");
			} else if ((revIfYes - cost) == (revIfNot)){
				System.out.println("does not matter");
			} else {
				System.out.println("do not advertise");
			}
			scanner.nextLine();
		}
	}
}