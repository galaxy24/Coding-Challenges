package Kattis;

import java.util.HashSet;
import java.util.Scanner;

public class Modulo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Modulo m = new Modulo(scanner);
	}

	public Modulo(Scanner sc){
		HashSet<Integer> modulos = new HashSet<>();
		while (sc.hasNext()){
			modulos.add(sc.nextInt() % 42);
		}
		System.out.println(modulos.size());
	}
}