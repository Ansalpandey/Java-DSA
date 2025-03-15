package Blind75;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
public class RemoveDuplicates {
	public static void main(String[] args) {
		int[] nums = {1, 1, 2};
		System.out.println(removeDuplicates(nums));
	}

	public static int removeDuplicates(int[] nums) {
		// If the array is null or empty, return 0 (invalid case)
		if (nums == null || nums.length == 0) {
			return 0;
		}

		// Initialize count to 1 since the first element is always unique
		int count = 1;

		// Start looping from the second element (index 1)
		for (int i = 1; i < nums.length; i++) {
			// If the current element is different from the previous element
			if (nums[i] != nums[i - 1]) {
				// Place the unique element at the next available position
				nums[count] = nums[i];

				// Increment the count of unique elements
				count++;
			}
		}

		// Return the number of unique elements in the modified array
		return count;
	}
}
