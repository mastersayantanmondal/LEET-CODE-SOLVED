class Solution(object):
    def waysToSplitArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        prefix_sum = [0] * n
        prefix_sum[0] = nums[0]
        
        # Compute prefix sums
        for i in range(1, n):
            prefix_sum[i] = prefix_sum[i - 1] + nums[i]
        
        total_sum = prefix_sum[-1]  # Total sum of the array
        valid_split_count = 0
        
        # Iterate to count valid splits
        for i in range(n - 1):  # Only check indices 0 to n-2
            left_sum = prefix_sum[i]
            right_sum = total_sum - left_sum
            if left_sum >= right_sum:
                valid_split_count += 1
        
        return valid_split_count
       