package Kattis;

import java.util.Scanner;

public class Autori {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		String[] result = line.split("[a-z\\-]+");
		int size = result.length;
		for(int i = 0; i < size; i++){
			System.out.print(result[i]);
		}
	}

}