package Codility;

class DaysOfTheWeek {

	/*
		Days of the week are represented as three-letter strings ("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun").

		Write a function solution that, given a String S representing the day of the week and an integer K (between 0
		and 500, inclusive), returns the day of the week that is K days later.

		For example, given S = "Wed" and K = 2, the function should return "Fri".

		given S = "Sat" and K = 23, the function should return "Mon".
	 */

	private static String solution(String S, int K){
		String[] week = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
		int start = 0;
		for (int i = 0; i < week.length; i++) if (S == week[i]) {
		// I had a big mistake here!                ^^
		// It should have been:
		// for (int i = 0; i < week.length; i++) if (S.equals(week[i])) {
		// that was the reason why it didn't pass on the website. But I guess my version of Java was able to solve it.
		// I can argue that version 11 of Java has that new feature.
			start = i;
			break;
		}
		int rot = (K + start) % 7;
		return week[rot];
	}


	public static void main(String[] args) {
		System.out.println(solution("Wed", 2));
		System.out.println(solution("Mon", 2));
		System.out.println(solution("Mon", 7));
	}
}
