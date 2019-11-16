package LeetCode;

public class ReverseInteger {
	//	https://leetcode.com/problems/reverse-integer/

	//	Given a 32-bit signed integer, reverse digits of an integer.
	//
	//	Example 1:
	//	Input: 123
	//	Output: 321


	//	Example 2:
	//	Input: -123
	//	Output: -321


	//	Example 3:
	//
	//	Input: 120
	//	Output: 21
	//	Note:
	//	Assume we are dealing with an environment which could only store integers within the 32-bit signed integer
	//	range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed
	//	integer overflows.

	/* Solving code goes here: */
	private static int work(int x){
		StringBuilder aux = new StringBuilder("" + x).reverse();
		if (x < 0) aux = new StringBuilder("-").append(aux).deleteCharAt(aux.length());
		int res = 0;
		try {
			res = Integer.parseInt(aux.toString());
			return res;
		} catch (NumberFormatException e) { return res; }
	}

	/* Debugging code: */
	public static int solution(int A){
		System.err.println(A);
		int solution = work(A);
		System.err.println(solution);
		return solution;
	}

	public static void main(String[] args) {
		int A = -1999999999;
		System.out.println(solution(A));

		// works
	}

}
