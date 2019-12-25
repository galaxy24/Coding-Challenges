package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class IntToRoman {

	/**
	 * https://leetcode.com/problems/roman-to-integer/
	 */

	/* Solving code goes here: */
	private static String work(int number){

		Map<Integer, String> roman = new HashMap<Integer, String>() {{
			put(1,"I");
			put(4,"IV");
			put(5,"V");
			put(9,"IX");
			put(10,"X");
			put(40,"XL");
			put(50,"L");
			put(90,"XC");
			put(100,"C");
			put(400,"CD");
			put(500,"D");
			put(900,"CM");
			put(1000,"M");
		}};

		StringBuilder res = new StringBuilder();

		int length = (int) (Math.log10(number) + 1);

		for (int i = 1; i <= length; i++) {
			int curr = ((number/(pow10(length-i))) % 10);
			if (roman.containsKey(curr)) res.append(roman.get(curr * pow10(length-i)));
			else {
				int lookup = 1;
				while (!roman.containsKey(curr)) {
					curr--;
					lookup++;
				}
				res.append(roman.get(curr * pow10(length-i)));
				for (int j = 1; j < lookup; j++) res.append(roman.get(pow10(length-i)));
			}
		}

		return res.toString();
	}

	private static int pow10(int powerRaised) {
		if (powerRaised > 0)
			return (10 * pow10(powerRaised - 1));
		else
			return 1;
	}

	/* Debugging code: */
	public static String solution(int str){
		System.err.println(str);
		String solution = work(str);
		System.err.println(solution);
		return solution;
	}

	public static void main(String[] args) {
		int str = 1996;
		System.out.println(solution(str));

		// works but exceeds execution time
	}
}