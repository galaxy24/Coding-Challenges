package Kattis;

import java.util.Scanner;

public class Tarifa {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int allowance = scanner.nextInt();
		int months = 0;
		int spenditure = 0;
		while (scanner.hasNext()){
			spenditure = spenditure + scanner.nextInt();
			months++;
			System.out.println(spenditure);
		}
		int remainder = (allowance*months) - spenditure;
		System.out.println(remainder);
	}
}