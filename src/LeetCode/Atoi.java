package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Atoi {

/*
	https://leetcode.com/problems/string-to-integer-atoi/

	Implement atoi which converts a string to an integer.

	The function first discards as many whitespace characters as necessary until the first non-whitespace character is
	found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical
	digits as possible, and interprets them as a numerical value.

	The string can contain additional characters after those that form the integral number, which are ignored and have
	no effect on the behavior of this function.

	If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence
	exists because either str is empty or it contains only whitespace characters, no conversion is performed.

	If no valid conversion could be performed, a zero value is returned.

	Note:

	Only the space character ' ' is considered as whitespace character.
	Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
	[−2^31,  2^31 − 1]. If the numerical value is out of the range of representable values, INT_MAX (2^31 − 1) or
	INT_MIN	(−2^31) is returned.

	Example 1:

		Input: "42"
		Output: 42
		Example 2:

		Input: "   -42"
		Output: -42
		Explanation: The first non-whitespace character is '-', which is the minus sign.
		             Then take as many numerical digits as possible, which gets 42.

	Example 3:

		Input: "4193 with words"
		Output: 4193
		Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
		Example 4:

		Input: "words and 987"
		Output: 0
		Explanation: The first non-whitespace character is 'w', which is not a numerical
		             digit or a +/- sign. Therefore no valid conversion could be performed.

	Example 5:

		Input: "-91283472332"
		Output: -2147483648
		Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
		             Thefore INT_MIN (−2^31) is returned.
	 */

	/* Solving code goes here: */
	private static int work(String srt){
		if (srt == null || srt.equals(" ")) return 0;

		long aux = 0;

		Set<Character> algs = new HashSet<>();
		for (int i = 0; i < 10 ; i++) algs.add((char) (48 + i));
		algs.add('-');
		algs.add('+');

		char[] iter = srt.replaceAll("^\\s+","").toCharArray();

		boolean changedSign = false;
		boolean isNegative = false;
		boolean sawFirstNumber = false;

		List<Character> res = new LinkedList<>();

		for (char c : iter) {
			if (!sawFirstNumber && !algs.contains(c)) return 0; // starts with non-digit character, abort
			if (sawFirstNumber && !algs.contains(c)) break; // we hit the case we saw digits but it's not digits anymore
			if ((c == '-' || c == '+') && changedSign) break;
			if ((c == '-' || c == '+') && !sawFirstNumber) {
				changedSign = true;
				if (c == '-') isNegative = true; // it's negative and we haven't seen a digit
			}
			if (sawFirstNumber && (c == '-' || c == '+')) break;
//			if (!sawFirstNumber && c == '0') continue;
			if (algs.contains(c)) {
				if (c != '-' && c != '+') {
					sawFirstNumber = true;
					res.add(c);
				}
			}
		}

		if (res.size() == 1) {
			if (isNegative) return Character.getNumericValue(res.get(0)) * (-1);
			return Character.getNumericValue(res.get(0));
		}

		if (!sawFirstNumber) return 0;

		StringBuilder stringRep = new StringBuilder();

		for (int i = 1; i <= res.size(); i++) {
			stringRep.append(res.get(i - 1));
			aux += Character.getNumericValue(res.get(i-1)) * pow10(res.size() - i);
		}

		if (aux == 0) return 0;

		if (isNegative) {
			stringRep.insert(0,'-');
			aux = aux * (-1);
		}

		if (isTooLarge(stringRep.toString())) {
			if (isNegative) return Integer.MIN_VALUE;
			return Integer.MAX_VALUE;
		}


		if (aux > 0 && aux > (long) Integer.MAX_VALUE) return Integer.MAX_VALUE;
		if (aux < (long) Integer.MIN_VALUE) return Integer.MIN_VALUE;

		return (int) aux;
	}

	private static boolean isTooLarge(String str){
		str = str.replaceFirst ("^0*", "");
		long number;
		boolean res = false;
		try { number = Long.decode(str); }
		catch (NumberFormatException e) { res = true; }
		finally { return res; }

	}

	private static long pow10(int n) {
		if (n == 0) return 1;
		return 10*pow10(n-1);
	}

	/* Debugging code: */
	public static int solution(String str){
		System.err.println(str);
		int solution = work(str);
		System.err.println(solution);
		return solution;
	}

	public static void main(String[] args) {
		String str = "+-1";
		System.out.println(solution(str));
		System.out.println(isTooLarge("0000000000012345678"));

		// works!!
	}


}
