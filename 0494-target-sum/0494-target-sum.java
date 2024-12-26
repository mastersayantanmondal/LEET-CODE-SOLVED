class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        // If the target is not reachable or the sum + target is odd, return 0
        if (Math.abs(target) > totalSum || (totalSum + target) % 2 == 1) {
            return 0;
        }

        // Transform the problem into subset sum
        int subsetSum = (totalSum + target) / 2;
        return countSubsets(nums, subsetSum);
    }

    private int countSubsets(int[] nums, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1; // There's one way to make sum 0 (use no elements)

        for (int num : nums) {
            for (int s = sum; s >= num; s--) {
                dp[s] += dp[s - num];
            }
        }
        return dp[sum];
    }
}
