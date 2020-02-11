package Kattis;

import java.util.HashSet;
import java.util.Scanner;

class IveBeenEverywhereMan {
	/**
	 * https://open.kattis.com/problems/everywhere
	 */

	public IveBeenEverywhereMan (Scanner sc){
		int testCases = Integer.parseInt(sc.nextLine());
		for (int a = 0; a < testCases; a++) {
			int numberOfCities = Integer.parseInt(sc.nextLine());
			HashSet<String> citiesVisited = new HashSet<>();
			for (int i = 0; i < numberOfCities; i++) {
				citiesVisited.add(sc.nextLine());
			}
			System.out.println(citiesVisited.size());
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		IveBeenEverywhereMan iv = new IveBeenEverywhereMan(scanner);
		scanner.close();
	}
}