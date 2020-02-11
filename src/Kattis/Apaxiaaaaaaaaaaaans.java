package Kattis;

import java.util.ArrayList;
import java.util.Scanner;

class Apaxiaaaaaaaaaaaans {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] array = scanner.next().toCharArray();
		ArrayList<Character> result = new ArrayList<>();
		result.add(array[0]);
		for (char c : array){
			if (c != result.get(result.size()-1)){
				result.add(c);
			}
		}
		for (int i = 0; i < result.size(); i++){
			System.out.print(result.get(i));
		}
		scanner.close();
	}
}