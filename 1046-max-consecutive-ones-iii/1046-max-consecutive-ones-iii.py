class Solution(object):
    def longestOnes(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        start = 0
        max_length = 0
        zeros_count = 0

        for end in range(len(nums)):
            # Expand the window by including nums[end]
            if nums[end] == 0:
                zeros_count += 1

            # Shrink the window if zeros_count exceeds k
            while zeros_count > k:
                if nums[start] == 0:
                    zeros_count -= 1
                start += 1

            # Update the maximum length
            max_length = max(max_length, end - start + 1)

        return max_length
