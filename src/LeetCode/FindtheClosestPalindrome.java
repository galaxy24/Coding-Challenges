package LeetCode;

class FindtheClosestPalindrome {

/*	https://leetcode.com/problems/find-the-closest-palindrome/

	Given an integer n, find the closest integer (not including itself), which is a palindrome.

	The 'closest' is defined as absolute difference minimized between two integers.

	Example 1:
	Input: "123"
	Output: "121"
	Note:
	The input n is a positive integer represented by string, whose length will not exceed 18.
	If there is a tie, return the smaller one as answer. */

	/* Solving code goes here: */
	private static String nearestPalindromic(String A){
		long N = Long.decode(A);

		long upperPalindrome;
		long lowerPalindrome;

		long i = N+1;
		do {
			if (isPalindrome(i)) {
				upperPalindrome = i;
				break;
			}
			i++;

		} while (true);

		i = N-1;
		do {
			if (isPalindrome(i)) {
				lowerPalindrome = i;
				break;
			}
			i--;
		} while (true);


		if (Math.abs(N-lowerPalindrome) <= Math.abs(upperPalindrome-N)) return "" + lowerPalindrome;
		else return "" + upperPalindrome;
	}

	private static boolean isPalindrome (long N) {
		if (N < 10 && N > -10) return true; // if (num.length() == 1) return true;
		else {
			if (N < 0) N = Math.abs(N);

			String num = String.valueOf(N);
			int i = 0, j = num.length() - 1;

			// While there are characters toc compare
			while (i < j) {

				// If there is a mismatch
				if (num.charAt(i) != num.charAt(j))	return false;

				// Increment first pointer and
				// decrement the other
				i++;
				j--;
			}
		}
		return true;

	}

	// VERY SLOW!
	/* Function to check if n is Palindrome*/
	static boolean isPalindromeSlow(long n) {
		long rev_num = 0;
		while (n > 0) {
			rev_num = rev_num * 10 + n % 10;
			n = n / 10;
		}

		// Check if rev_n and n are same or not.
		return n == rev_num;
	}


	public static void main(String[] args) {
		String N = "807045053224792883";
		System.out.println(nearestPalindromic(N));
		// works but it's slow
	}
}
