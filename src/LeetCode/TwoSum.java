package LeetCode;

// https://leetcode.com/problems/two-sum/submissions/

// Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//		Example:
//
//		Given nums = [2, 7, 11, 15], target = 9,
//
//		Because nums[0] + nums[1] = 2 + 7 = 9,
//		return [0, 1].

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	/* Solving code goes here: */
	private static int[] work(int[] nums, int target){
		Map<Integer, Integer> original = new HashMap<>(nums.length);
		for (int i = 0; i < nums.length; i++) original.put(nums[i], i);
		Arrays.sort(nums);
		int[] res = new int[2];
		for (int i = 0; i < nums.length; i++) {
			int j = Arrays.binarySearch(nums, target-nums[i]);
			if (j > 0 && i != j) {
				res[0] = original.get(nums[i]);
				res[1] = original.get(nums[j]);
				Arrays.sort(res);
				break;
			}
		}
		return res;
	}

	/* Debugging code: */
	public static int[] solution(int[] nums, int target){
		System.err.println(Arrays.toString(nums));
		System.err.println(target);
		int[] solution = work(nums, target);
		System.err.println(Arrays.toString(solution));
		return solution;
	}

	public static void main(String[] args) {
		int[] nums = {3,2,4};
		int target = 6;
		System.out.println(Arrays.toString(solution(nums, target)));
		// [3,3]
		// 6
		// [0,0]
		// Expected: [0,1]
	}
}
