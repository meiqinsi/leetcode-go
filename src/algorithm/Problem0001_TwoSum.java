package algorithm;

import java.util.HashMap;

import util.Util;

/***
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * You can return the answer in any order.
 */

// 1~n 给定 target
//target 在1， 就从 2~n 找 （target-arr【1】）二分查找？
public class Problem0001_TwoSum {

	// 需要一个hashmap， 不回头，直接找，因为肯定一个能对上一个。
	// 走过的就记到map离，不回头，因为肯定能对上，前面map里没有，到后边有了以后就直接找后边的pare
	public static int[] twoSum1(int[] nums, int target) {
		// map 的key是某个“之前”的数，value是这个数的位置
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length;i++) {
			// 检查“之前”有没有出现过 配对的数
			if(map.containsKey(target-nums[i])) {
				return new int[] { i, map.get(target - nums[i]) };
			}
			// 如果没找到，说明当前值 作为result【x, dangqian】没答案。
			// 记录下来 继续
			map.put(nums[i], i);
		}
		//还没return，说明没答案
		return new int[] { -1, -1 };

	}

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 7, 11, 15 };
		int target = 9;
		int[] ans = twoSum1(nums, target);
		Util.printArray(ans);

	}

}
