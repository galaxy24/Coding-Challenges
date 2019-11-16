package Kattis;

import java.util.Scanner;

class HissingMicrophone {
	/**
	 * https://open.kattis.com/problems/hissingmicrophone
	 */
	private String mic;

	public HissingMicrophone(String mic){
		this.mic = mic;
		if(mic.contains("ss")){
			System.out.println("hiss");
		}
		else {
			System.out.println("no hiss");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HissingMicrophone microphone = new HissingMicrophone(sc.nextLine());
	}
}