package Codility;

class ConsecutiveAA {

	/*
		Write a function solution that, given a string S consisting of N characters, returns the maximum number of letters
		'a' that can be inserted into S (including at the from and end of S) so that the resulting string doesn't contain
		three consecutive letters 'a'. If string S already contains "aaa", then your function should return -1;

		Examples:
		1. Given S = "aabab", the function should return 3, because a string "aabaabaa" can be made.
		2. Given S = "dog", the function should return 8, because a string "aadaaoaagaa" can be made.
		3. Given S = "aa, the function should return 0, because no longer string can be made.
		4, Given S = "baaaa", the function should return -1, because there is a substring "aaa"

		Write an efficient algorithms for the following assumptions:
			- N is an integer within the range [1..200 000]
			- string S consists only of lowercase letters (a-z)
	 */

	private static int solution(String S) {
		int res = -1;
		if (!S.contains("a")) {
			res = (S.length() * 2) + 2;

		} else if (S.equals("aaa") || S.contains("aaa")) {
			return res;

		} else if (S.equals("aa")) {
			return 0;


		} else {
			res = 0;

			char[] aux = S.toCharArray();
			for (int i = 0; i < aux.length; i++) {
				if (i == 0 || i == aux.length -1) res = res + 3;
				else {
					if (!(aux[i] == 'a')) res = res + 2;
					else res = res - 1;
				}
			}

			if (S.startsWith("a") || S.startsWith("aa")) {
				if (S.startsWith("a")) {
					res = res - 2;
				}
				res = res - 1;
			}

			if (S.endsWith("a") || S.endsWith("aa")) {
				if (S.endsWith("a")) {
					res = res - 2;
				}
				res = res - 1;
			}
		}
		return res;
	}


	public static void main(String[] args) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < 200_000; i++) {
			if (i % 5 == 0) res.append("a");
			else res.append("b");
		}
		System.err.println(res.toString());
		long start = System.nanoTime();
//		System.out.println(solution(res.toString())); // 5.4411 milisec
		System.out.println(solution("dog"));
		System.out.println(((double) (System.nanoTime() - start))/1000000);

		// works!

	}
}
