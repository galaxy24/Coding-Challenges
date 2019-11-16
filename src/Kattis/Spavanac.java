package Kattis;

import java.util.Scanner;

class Spavanac {

	/**
	 * https://open.kattis.com/problems/spavanac
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int hour = scanner.nextInt();
//        System.out.println("Hours: " + hour);
		int minute = scanner.nextInt();
//        System.out.println("Minutes: " + minute);
		int resMinute;
		int resHour = hour;

		if (minute < 45){
			resHour = resHour - 1;
			resMinute = 60 - (45 - minute);
//            System.out.println(resMinute);
		} else {
			resMinute = minute - 45;
		}
		if (resHour < 0){
			resHour = 23;
		}
		System.out.println(resHour + " " + resMinute);
	}
}