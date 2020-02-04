package LeetCode;

class DivideTwoIntegers {
	/*
		https://leetcode.com/problems/divide-two-integers/

		Given two integers dividend and divisor, divide two integers without using multiplication, division and mod
		operator.

		Return the quotient after dividing dividend by divisor.

		The integer division should truncate toward zero.

		Example 1:

		Input: dividend = 10, divisor = 3
		Output: 3
		Example 2:

		Input: dividend = 7, divisor = -3
		Output: -2
		Note:

		Both dividend and divisor will be 32-bit signed integers.
		The divisor will never be 0.
		Assume we are dealing with an environment which could only store integers within the 32-bit signed integer
		range: [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function returns 2^31 − 1 when the
		division result overflows.
	 */

	/* Solving code goes here: */
	private static int work(int dividend, int divisor){
		// 905 / 989 test cases passed.
		if (dividend == 0) return 0;

		boolean negativeDividend = false;
		boolean negativeDivisor = false;

		if (dividend < 0) {
			dividend = dividend * (-1);
			negativeDividend = true;
		}
		if (divisor < 0) {
			divisor = divisor * (-1);
			negativeDivisor = true;
		}

		if (dividend < divisor) return 0;
		if (dividend == divisor){
			if (negativeDividend ^ negativeDivisor) return -1;
			else return 1;
		}


		long res = 0;
		while (dividend - divisor > 0) {
			dividend -= divisor;
			res++;
		}

		if (negativeDividend ^ negativeDivisor) {
			res = res * (-1);
		}
		return (int) res;
	}


	/* Debugging code: */
	public static int solution(int dividend, int divisor){
		System.err.println(dividend);
		System.err.println(divisor);
		int solution = work(dividend, divisor);
		System.err.println(solution);
		return solution;
	}

	public static void main(String[] args) {
		int dividend = Integer.MIN_VALUE;
		int divisor = -1;
		System.out.println(solution(dividend, divisor));

	//      Problem:

	//		Input:
	//		-2147483648
	//				-1
	//		Output:
	//		0
	//		Expected:
	//		2147483647
	}
}
