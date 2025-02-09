package Blind75;

import java.util.Arrays;
import java.util.HashSet;

// https://leetcode.com/problems/contains-duplicate/
public class ContainsDuplicates {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		//Using The iterative approach.
		System.out.println(containsDuplicate(nums));

		//Using the HashSet approach
		System.out.println(containsDuplicate(nums));
	}


	// Using the iterative approach and condition checking at every step.
	// Time complexity of this approach is O(n log n)
	// Space complexity of this approach is O(n log n)

	//Steps taken:-
	//Sorted the array.
	//Ran a for loop till the last index.
	// Iterated each value and checked for the duplicate value on the next index.
	//If the value found returned true, else returned false on the exit of Function.
	public static boolean containsDuplicate(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1]) {
				return true;
			}
		}
		return false;
	}

	// Using the HashSet approach
	// Time complexity of this approach is O(n)
	// Space complexity of this approach is O(n)

	//Steps taken:-
	//Created a HashSet of type Integer.
	//Using HashSet made the insert and finding in O(1).
	//Ran a for loop till the last index.
	// Iterated each value and checked for the duplicate value as HashSet cannot contain Duplicate Value, If there will be any duplicate value it will instantly return true.
	//If the value found returned true, else returned false on the exit of Function.
	public static boolean containsDuplicateHashSet(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length - 1; i++) {
			if (set.contains(nums[i])) {
				return true;
			}
			set.add(nums[i]);
		}
		return false;
	}
}
