package Codility;

import java.util.Arrays;

class Triangle {

//	An array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:
//
//	A[P] + A[Q] > A[R],
//	A[Q] + A[R] > A[P],
//	A[R] + A[P] > A[Q].
//	For example, consider array A such that:
//
//	A[0] = 10    A[1] = 2    A[2] = 5
//	A[3] = 1     A[4] = 8    A[5] = 20
//	Triplet (0, 2, 4) is triangular.
//
//	Write a function:
//
//	class Solution { public int solution(int[] A); }
//
//	that, given an array A consisting of N integers, returns 1 if there exists a triangular triplet for this array and returns 0 otherwise.
//
//	For example, given array A such that:
//
//	A[0] = 10    A[1] = 2    A[2] = 5
//	A[3] = 1     A[4] = 8    A[5] = 20
//	the function should return 1, as explained above. Given array A such that:
//
//	A[0] = 10    A[1] = 50    A[2] = 5
//	A[3] = 1
//	the function should return 0.
//
//	Write an efficient algorithm for the following assumptions:
//
//	N is an integer within the range [0..100,000];
//	each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].

	public static int solution(int[] A) {
		System.err.println(Arrays.toString(A));
		Arrays.sort(A);
		for (int i = 0; i < A.length; i++) {
			for (int j = i+1; j < A.length; j++) {
				for (int k = j+1; k < A.length; k++) {
					if (isTriangular(A[i],A[j],A[k])) {
						System.err.println("A[P] = " + A[i] + "  A[Q] = " + A[j] + "  A[R] = " + A[k]);
						return 1;
					}
				}
			}
		}

		return 0;

	}

	private static boolean isTriangular(int P, int Q, int R){
		return P+Q>R && Q+R>P && R+P>Q;
		// doesn't pass large instances
	}

	public static void main(String[] args) {
		int[] A = {10,2,5,1,8,20};
		System.out.println(solution(A));

	}
}