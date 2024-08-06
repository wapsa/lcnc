package com.lcnc.algo.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KSum {

	public static void main(String[] args) {
		System.out.println(kSum(new int[] { 1, 0, -1, 0, -2, 2 }, 4, 0));
		System.out.println(kSum(new int[] { 2, 2, 2, 2, 2 }, 4, 8));
		System.out.println(kSum(new int[] { 2, 2, 2, 2, 2 }, 3, 6));
		System.out.println(kSum(new int[] { 1000000000, 1000000000, 1000000000, 1000000000 }, 4, -294967296));

		System.out.println("---");

		System.out.println(kSumPractice(new int[] { 1, 0, -1, 0, -2, 2 }, 4, 0));
		System.out.println(kSumPractice(new int[] { 2, 2, 2, 2, 2 }, 4, 8));
		System.out.println(kSumPractice(new int[] { 2, 2, 2, 2, 2 }, 3, 6));
		System.out.println(kSumPractice(new int[] { 1000000000, 1000000000, 1000000000, 1000000000 }, 4, -294967296));
	}

	private static List<List<Integer>> kSumPractice(int[] nums, int k, int target) {
		return null;
	}

	private static List<List<Integer>> kSum(int[] nums, int k, int target) {
		Arrays.sort(nums);
		return kSum(nums, k, target, 0);
	}

	private static List<List<Integer>> kSum(int[] nums, int k, long target, int left) {
		if (k == 2) {
			return twoSum(nums, target, left);
		}
		List<List<Integer>> res = new ArrayList<>();
		for (int i = left; i < nums.length; i++) {
			if (i > left && nums[i] == nums[i - 1])
				continue;
			List<List<Integer>> kMinus1Res = kSum(nums, k - 1, target - nums[i], i + 1);
			for (List<Integer> t : kMinus1Res) {
				t.add(nums[i]);
				res.add(t);
			}
		}
		return res;
	}

	private static List<List<Integer>> twoSum(int[] nums, long target, int left) {
		List<List<Integer>> res = new ArrayList<>();
		int right = nums.length - 1;
		while (left < right) {
			long twoSum = nums[left] + nums[right];
			if (twoSum == target) {
				res.add(new ArrayList<>(Arrays.asList(nums[left], nums[right])));
				left++;
				right--;
				while (left < right && nums[left] == nums[left - 1])
					left++;
				while (right > left && nums[right] == nums[right + 1])
					right--;
			} else if (twoSum < target)
				left++;
			else
				right--;
		}
		return res;
	}

}
