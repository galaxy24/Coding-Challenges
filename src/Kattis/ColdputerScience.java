package Kattis;

import java.util.Scanner;

class ColdputerScience {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int occurrences = scanner.nextInt();
		int result = 0;
		for (int i = 1; i <= occurrences; i++){
			if (scanner.nextInt() < 0){
				result++;
			}
		}
		System.out.println(result);
	}
}