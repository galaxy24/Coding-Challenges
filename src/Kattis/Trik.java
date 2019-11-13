package Kattis;

import java.util.Scanner;

public class Trik {

	/**
	 * https://open.kattis.com/problems/trik
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String moves = scanner.nextLine();
		int position = 1;
		for (int i = 0; i < moves.length(); i++){
			String evaluate = moves.substring(i,i+1);
			if (position == 1) {
				if (evaluate.equals("A")) {
					position = 2;
					break;
				}
				if (evaluate.equals("C")) {
					position = 3;
					break;
				}
			}
			if (position == 2) {
				if (evaluate.equals("A")) {
					position = 1;
					break;
				}
				if (evaluate.equals("B")) {
					position = 3;
					break;
				}
			}
			if (position == 3) {
				if (evaluate.equals("B")){
					position = 2;
					break;
				}
				if (evaluate.equals("C")){
					position = 1;
					break;
				}
			}
		}
		System.out.println(position);
	}
}