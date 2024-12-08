import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // HashMap to store the number and its index
        Map<Integer, Integer> numToIndex = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement
            int complement = target - nums[i];

            // Check if the complement exists in the map
            if (numToIndex.containsKey(complement)) {
                // Return the indices of the two numbers
                return new int[] { numToIndex.get(complement), i };
            }

            // Otherwise, store the number and its index in the map
            numToIndex.put(nums[i], i);
        }

        // If no solution exists (shouldn't happen per constraints)
        throw new IllegalArgumentException("No two sum solution");
    }
}
