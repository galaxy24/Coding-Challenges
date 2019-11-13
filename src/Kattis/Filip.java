package Kattis;

import java.util.Scanner;

/**
 * https://open.kattis.com/problems/filip
 */

public class Filip {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		StringBuffer buffer = new StringBuffer(line);
		buffer = buffer.reverse();
		int number1 = Integer.parseInt(buffer.substring(0,3));
		int number2 = Integer.parseInt(buffer.substring(4,7));
		if (number1 > number2){
			System.out.println(number1);
		} else {
			System.out.println(number2);
		}
	}
}