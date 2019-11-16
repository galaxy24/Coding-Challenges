package Kattis;

import java.util.Scanner;

class TakeTwoStones {
	private int remainingStones;
	private String winner;

	public TakeTwoStones (int numberOfStones){
		if (1<= numberOfStones && numberOfStones <= 10000000){
			remainingStones = numberOfStones;
			while (remainingStones - 2 > 0){
				remainingStones = remainingStones - 2;
			}
			if (remainingStones % 2 == 1){
				winner = "Alice";
			}
			else {
				winner = "Bob";
			}
		}
		System.out.println(winner);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TakeTwoStones t = new TakeTwoStones(sc.nextInt());
	}
}