package OneDotCom;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

class Date {
	private int day;
	private int month;
	private int year;
	private long daysSinceFirstJanOne;

	public Date(String date){
		int year = 0;
		int month = 0;
		int day = 0;
		Pattern datePattern = Pattern.compile("^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$");
		if (datePattern.matcher(date).matches()) {
			String[] parseDate = date.split("-");

			year = Integer.parseInt(parseDate[0]);
			month = Integer.parseInt(parseDate[1]);
			day = Integer.parseInt(parseDate[2]);
		} else {
			throw new InputMismatchException ("Failed to parse the given date. Be sure to follow the format yyyy-mm-dd.");
		}

		this.day = day;
		this.month = month;
		this.year = year;
		setDaysSinceFirstJanOne();

	}

	public int getDay() {return day;}

	public int getMonth() {return month;}

	public int getYear() {return year;}

	public long daysInBetween(Date that, boolean inclusive) {
		return inclusive ? daysInBetween(that) + 1 : daysInBetween(that);
	}

	public long daysInBetween(Date that) {
		return Math.abs(this.getDaysSinceFirstJanOne() - that.getDaysSinceFirstJanOne());
	}

	public long getDaysSinceFirstJanOne() {return daysSinceFirstJanOne;}

	private void setDaysSinceFirstJanOne() {

		int[] FirstJanOne = {1,1,1};

		long res = 0;

		if (this.getYear() - FirstJanOne[0] == 0) { // The dates are in the same year
			if (FirstJanOne[1] == this.getMonth()) { // The dates are in the same month
				res += this.getDay() - FirstJanOne[2];
			} else { // There is some month difference
				res += daysInMonth(FirstJanOne[1],FirstJanOne[0]) - FirstJanOne[2];
				for (int i = FirstJanOne[1] + 1; i < this.getMonth(); i++) {
					res += daysInMonth(i, FirstJanOne[0]);
				}
				res += this.getDay();
			}
		}

		else if (this.getYear() - FirstJanOne[0] == 1){
			res += daysUntilNextJan1st(FirstJanOne[2],FirstJanOne[1],FirstJanOne[0]);
			res += daysSinceJan1st(this.getDay(),this.getMonth(),this.getYear());
		}

		else {
			res += daysUntilNextJan1st(FirstJanOne[2],FirstJanOne[1],FirstJanOne[0]);
			for (int i = FirstJanOne[0] + 1; i < this.getYear(); i++) {
				if (isLeapYear(i)) res += 366;
				else res += 365;
			}
			res += daysSinceJan1st(this.getDay(),this.getMonth(),this.getYear());
		}

		this.daysSinceFirstJanOne = res;
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

	@Override
	public String toString() {
		return getYear()+"/"+getMonth()+"/"+getDay();
	}

	public static void main(String[] args) {

		System.out.println("Days in between dates calculator:");
		System.out.println("1. Date 1 (yyyy-mm-dd):");
		Date firstDate = new Date(new Scanner(System.in).nextLine());
		System.out.println("2. Date 2 (yyyy-mm-dd):");
		Date secondDate = new Date(new Scanner(System.in).nextLine());
		boolean inclusive = false;
		System.out.println("3. Include the end date? (Y/n)");
		Scanner inc = new Scanner(System.in);
		if (inc.nextLine().toLowerCase().startsWith("y")) {
			System.out.print("There are " + firstDate.daysInBetween(secondDate,true) + " day(s) between " +
					firstDate.toString() + " and " + secondDate.toString() + " (inclusive)");
		} else {
			System.out.print("There are " + firstDate.daysInBetween(secondDate,false) + " day(s) between " +
					firstDate.toString() + " and " + secondDate.toString() + " (exclusive).");
		}
	}
}