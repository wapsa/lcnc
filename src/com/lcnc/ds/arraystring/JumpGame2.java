package com.lcnc.ds.arraystring;

/**
 * You are given a 0-indexed array of integers nums of length n. You are
 * initially positioned at nums[0].
 * 
 * Each element nums[i] represents the maximum length of a forward jump from
 * index i. In other words, if you are at nums[i], you can jump to any nums[i +
 * j] where:
 * 
 * 0 <= j <= nums[i] and i + j < n Return the minimum number of jumps to reach
 * nums[n - 1]. The test cases are generated such that you can reach nums[n -
 * 1].
 * 
 * Example 1: Input: nums = [2,3,1,1,4] Output: 2 Explanation: The minimum
 * number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1,
 * then 3 steps to the last index.
 * 
 * Example 2: Input: nums = [2,3,0,1,4] Output: 2
 */
public class JumpGame2 {

	public static void main(String[] args) {
		System.out.println(jump(new int[] { 3, 2, 1, 1, 4 }));
		System.out.println(jump(new int[] { 2, 3, 1, 1, 4 }));
		System.out.println(jump(new int[] { 2, 1, 0, 1, 4 }));
		System.out.println(jump(new int[] { 2, 3, 1, 1, 0, 4 }));
		System.out.println(jump(new int[] { 2, 4, 1, 1, 0, 4 }));

		System.out.println("---");

		System.out.println(jumpDP(new int[] { 3, 2, 1, 1, 4 }));
		System.out.println(jumpDP(new int[] { 2, 3, 1, 1, 4 }));
		System.out.println(jumpDP(new int[] { 2, 1, 0, 1, 4 }));
		System.out.println(jumpDP(new int[] { 2, 3, 1, 1, 0, 4 }));
		System.out.println(jumpDP(new int[] { 2, 4, 1, 1, 0, 4 }));

		System.out.println("---");

		System.out.println(jumpPractice(new int[] { 3, 2, 1, 1, 4 }));
		System.out.println(jumpPractice(new int[] { 2, 3, 1, 1, 4 }));
		System.out.println(jumpPractice(new int[] { 2, 1, 0, 1, 4 }));
		System.out.println(jumpPractice(new int[] { 2, 3, 1, 1, 0, 4 }));
		System.out.println(jumpPractice(new int[] { 2, 4, 1, 1, 0, 4 }));
	}

	private static int jumpPractice(int[] nums) {
		return -1;
	}

	/**
	 * https://www.youtube.com/watch?v=dJ7sWiOoK7g
	 */
	private static int jump(int[] nums) {
		int jumps = 0;
		int left = 0;
		int right = 0;
		while (right < nums.length - 1) {
			int farthest = 0;
			while (left <= right) {
				farthest = Math.max(farthest, left + nums[left]);
				left++;
			}
			if (farthest <= right)
				return -1;
			jumps++;
			left = right + 1;
			right = farthest;
		}
		return jumps;
	}

	/**
	 * https://www.youtube.com/watch?v=Zobz9BXpwYE
	 */
	private static int jumpDP(int[] nums) {
		Integer[] dp = new Integer[nums.length];
		dp[nums.length - 1] = 0;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] <= 0)
				continue;
			Integer min = Integer.MAX_VALUE;
			for (int j = 1; j <= nums[i] && i + j < dp.length; j++) {
				if (dp[i + j] == null)
					continue;
				min = Math.min(min, dp[i + j]);
			}
			if (min < Integer.MAX_VALUE)
				dp[i] = min + 1;
		}
		return null == dp[0] ? -1 : dp[0];
	}

}
