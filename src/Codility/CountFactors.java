package Codility;

public class CountFactors {
//	A positive integer D is a factor of a positive integer N if there exists an integer M such that N = D * M.
//
//			For example, 6 is a factor of 24, because M = 4 satisfies the above condition (24 = 6 * 4).
//
//	Write a function:
//
//	class Solution { public int solution(int N); }
//
//	that, given a positive integer N, returns the number of its factors.
//
//	For example, given N = 24, the function should return 8, because 24 has 8 factors, namely 1, 2, 3, 4, 6, 8, 12, 24.
//	There are no other factors of 24.
//
//	Write an efficient algorithm for the following assumptions:
//
//	N is an integer within the range [1..2,147,483,647].

	/* Solving code goes here: */
	private static int work(int A){
		if (A == 1) return 1;
		int factors = 2; // because A is always divisible by 1 and itself

		for (int i = 2; i <= A/2; i++) if (A % i == 0) factors++;
		return factors;
	}

	/* Debugging code: */
	public static int solution(int A){
		System.err.println(A);
		int solution = work(A);
		System.err.println(solution);
		return solution;
	}

	public static void main(String[] args) {
		int N = 39992976;
		System.out.println(solution(N));
		// correct but exceeds time limit
	}

}
