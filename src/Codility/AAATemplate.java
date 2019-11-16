package Codility;

import java.util.Arrays;

/*
	Template file to help coding and testing faster the exercises.
 */

class AAATemplate {

	/* Solving code goes here: */
	private static int work(int[] A){
		return -1;
	}

	/* Debugging code: */
	public static int solution(int[] A){
		System.err.println(Arrays.toString(A));
		int solution = work(A);
		System.err.println(solution);
		return solution;
	}

	public static void main(String[] args) {
		int[] A = {1,2,3};
		System.out.println(solution(A));
	}
}
