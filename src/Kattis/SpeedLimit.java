package Kattis;

import java.util.Scanner;

public class SpeedLimit {

	/**
	 * https://open.kattis.com/problems/speedlimit
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int numCases = scanner.nextInt();
			if (numCases > -1) {
				int drovenHours = 0;
				int miles = 0;
				for (int i = 0; i < numCases; i++) {
					int speed = scanner.nextInt();
					int accumulatedHours = scanner.nextInt();
					int thisRideHours = accumulatedHours - drovenHours;
					drovenHours = accumulatedHours;
					miles = miles + (thisRideHours * speed);
				}
				System.out.println(miles + " miles");
			}
		}
	}
}