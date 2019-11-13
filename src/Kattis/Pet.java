package Kattis;

import java.util.Scanner;

/**
 * https://open.kattis.com/problems/pet
 */

public class Pet {
	public static void main(String[] args) {
		int[] winner = {0, 0};
		int contestant = 1;
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()){
			String points = scanner.nextLine();

			String[] arrayOfPoints = points.split(" ");
			int result = 0;
			for (int i = 0; i < 4; i++){
				result = result + Integer.parseInt(arrayOfPoints[i]);
			}
			if (winner[1] < result){
				winner[0] = contestant;
				winner[1] = result;
			}
			contestant++;
		}
		System.out.println(winner[0] + " " + winner[1]);
	}
}