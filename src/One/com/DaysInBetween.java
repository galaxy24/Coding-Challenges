package One.com;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class DaysInBetween {

	/*
	One.com's coding challenge.
	Write a program that can calculate the number of days in-between two dates.
	You are not allowed to use java util date/calendar classes.
	*/

	private static final Pattern DATEPATTERN = Pattern.compile("^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$");

	private final boolean inclusive;
	private int[] firstDate;
	private int[] secondDate;


	public DaysInBetween(String date1, String date2, boolean inclusive){
		this.inclusive = inclusive;
		checkDates(date1, date2);
		System.out.print("There are " + diff() + " day(s) between " + Arrays.toString(firstDate) + " and " + Arrays.toString(secondDate));
		if (inclusive) System.out.println(" (inclusive).");
		else System.out.println(" (exclusive).");
	}

	private void checkDates(String date1, String date2){
		String[] firstDate = date1.split("-");
		String[] secondDate = date2.split("-");

		this.firstDate = new int[] {Integer.parseInt(firstDate[0]), Integer.parseInt(firstDate[1]), Integer.parseInt(firstDate[2])};
		this.secondDate = new int[] {Integer.parseInt(secondDate[0]), Integer.parseInt(secondDate[1]), Integer.parseInt(secondDate[2])};

		if (compareDates(this.firstDate, this.secondDate) < 0) {
			int[] aux = this.firstDate;
			this.firstDate = this.secondDate;
			this.secondDate = aux;
			aux = null;
		}
	}

	private int compareDates(int[] date1, int[] date2) {
		/* Same dates */
		if (Arrays.equals(date1,date2)) return 0;

		/* Different years */
		if (date1[0] < date2[0]) return 1;
		if (date2[0] < date1[0]) return -1;

		/* Same year */
		if (date1[1] < date2[1]) return 1;
		if (date1[1] > date2[1]) return -1;

		/* Same year, same month */
		if (date1[2] < date2[2]) return 1;
		else return -1;
	}

	public int diff(){
		int res = 0;

		if (secondDate[0] - firstDate[0] == 0) { // The dates are in the same year
			if (firstDate[1] == secondDate[1]) { // The dates are in the same month
				res += secondDate[2] - firstDate[2];
			} else { // There is some month difference
				res += daysInMonth(firstDate[1],firstDate[0]) - firstDate[2];
				for (int i = firstDate[1] + 1; i < secondDate[1]; i++) {
					res += daysInMonth(i, firstDate[0]);
				}
				res += secondDate[2];
			}
		}

		else if (secondDate[0] - firstDate[0] == 1){
			res += daysUntilNextJan1st(firstDate[2],firstDate[1],firstDate[0]);
			res += daysSinceJan1st(secondDate[2],secondDate[1],secondDate[0]);
		}

		else {
			res += daysUntilNextJan1st(firstDate[2],firstDate[1],firstDate[0]);
			for (int i = firstDate[0]+1; i < secondDate[0]; i++) {
				if (isLeapYear(i)) res += 366;
				else res += 365;
			}
			res += daysSinceJan1st(secondDate[2],secondDate[1],secondDate[0]);
		}

		if (inclusive) return res + 1;
		else return res;
	}

	private boolean isLeapYear(int year){
		if (year % 4 != 0) return false;
		else if (year % 400 == 0) return true;
		else return year % 100 != 0;
	}

	private int daysUntilNextJan1st (int dd, int mm, int yyyy) {
		int res = 0;
		res += daysInMonth(mm,yyyy) - dd;
		for (int i = mm+1; i < 13; i++) {
			res += daysInMonth(i,yyyy);
		}
		return res;
	}

	private int daysSinceJan1st (int dd, int mm, int yyyy){
		int res = 0;
		for (int i = 1; i < mm; i++) {
			res += daysInMonth(i,yyyy);
		}
		res += dd;
		return res;
	}

	private int daysInMonth (int mm, int yyyy) {
		if (mm == 4 || mm == 6 || mm == 9 || mm == 11) return 30;
		else if (mm == 2) return isLeapYear(yyyy) ? 29 : 28;
		else return 31;
	}

	/**
	 * Driver method.
	 * @param args
	 */
	public static void main(String[] args) {

//		DaysInBetween diff = new DaysInBetween("2018-06-16", "2004-06-17", true);

		System.out.println("Date 1 (yyyy-mm-dd):");
		try {
			String date1 = new Scanner(System.in).next(DATEPATTERN);
			System.out.println("Date 2 (yyyy-mm-dd):");

			try {
				String date2 = new Scanner(System.in).next(DATEPATTERN);
				boolean inclusive = false;
				System.out.println("Include the end date? (Y/n)");
				Scanner inc = new Scanner(System.in);
				if (inc.nextLine().toLowerCase().startsWith("y")) {
					inclusive = true;
				}
				DaysInBetween diff = new DaysInBetween(date1, date2, inclusive);

			} catch (InputMismatchException ex) {
				System.err.println("Failed to parse the given date. Be sure to follow the format yyyy-mm-dd.");
				System.exit(0);
			}

		} catch (InputMismatchException ex) {
			System.err.println("Failed to parse the given date. Be sure to follow the format yyyy-mm-dd.");
			System.exit(0);
		}

	}
}
