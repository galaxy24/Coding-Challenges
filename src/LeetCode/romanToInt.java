package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class romanToInt {

	/**
	 * https://leetcode.com/problems/roman-to-integer/
	 * @param srt
	 * @return
	 */

	/* Solving code goes here: */
	private static int work(String srt){


		Map<String, Integer> roman = new HashMap<>() {{
			put("I", 1);
			put("IV", 4);
			put("V", 5);
			put("IX", 9);
			put("X", 10);
			put("XL", 40);
			put("L", 50);
			put("XC", 90);
			put("C", 100);
			put("CD", 400);
			put("D", 500);
			put("CM", 900);
			put("M", 1000);
		}};

		int res = 0;

		for (int i = 0; i < srt.length(); i++) {
			if (i < srt.length()-1) {
				String curr = "" + srt.charAt(i);
				String next = "" + srt.charAt(i+1);
				if (roman.get(curr) < roman.get(next)) {
					res += roman.get(curr+next);
					i++;
					continue;
				}
			}
			res += roman.get("" + srt.charAt(i));
		}

		return res;
	}

	/* Debugging code: */
	public static int solution(String str){
		System.err.println(str);
		int solution = work(str);
		System.err.println(solution);
		return solution;
	}

	public static void main(String[] args) {
		String str = "MCMXCIV";
		System.out.println(solution(str));

		// works!!
	}
}