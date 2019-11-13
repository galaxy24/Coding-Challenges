package Kattis;

import java.util.Scanner;
import static java.lang.StrictMath.floor;
import static java.lang.StrictMath.log10;

public class QuickEstimates {

	/**
	 * https://open.kattis.com/problems/quickestimate
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numCases = scanner.nextInt();
		for (int i = 0; i < numCases; i++){
			int numToTest = scanner.nextInt();
			if (numToTest == 0){
				System.out.println("1");
			} else {
				System.out.println(((int) floor(log10(numToTest))) + 1);
			}
			scanner.nextLine();
		}
	}
}
