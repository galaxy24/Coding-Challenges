package Codility;

import java.util.Arrays;

class CyclicRotation {

//	An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one
//	index, and the last element of the array is moved to the first place. For example, the rotation of array
//	A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).
//
//	The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.
//
//	Write a function:
//
//	class Solution { public int[] solution(int[] A, int K); }
//
//	that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.
//
//	For example, given
//
//	A = [3, 8, 9, 7, 6]
//	K = 3
//	the function should return [9, 7, 6, 3, 8]. Three rotations were made:
//
//			[3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
//			[6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
//			[7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
//	For another example, given
//
//	A = [0, 0, 0]
//	K = 1
//	the function should return [0, 0, 0]
//
//	Given
//
//	A = [1, 2, 3, 4]
//	K = 4
//	the function should return [1, 2, 3, 4]
//
//	Assume that:
//
//	N and K are integers within the range [0..100];
//	each element of array A is an integer within the range [−1,000..1,000].
//	In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.

	/* Solving code goes here: */
	public static int[] work(int[] A, int K) {
		if (A.length == K || A.length <= 1) return A;
		else {
			int rot = A.length - (K % A.length);
			int[] res = new int[A.length];
			for (int i = 0; i < A.length - rot; i++) res[i] = A[i+rot];
			for (int i = A.length-rot; i < A.length; i++) res[i] = A[i-A.length+rot]; //A[0]
			return res;
		}
	}

	/* Debugging code: */
	public static int[] solution(int[] A, int K) {
		System.err.println(Arrays.toString(A));
		System.err.println(K);
		int[] solution = work(A, K);
		System.err.println(Arrays.toString(solution));
		return solution;
	}

	public static void main(String[] args) {
		int[] A = {3, 8, 9, 7, 6};
		int K = 8;
		solution(A,K);
		// works!!
	}
}