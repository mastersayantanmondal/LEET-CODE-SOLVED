class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        # Create a dictionary to store the index of each number
        num_to_index = {}
        
        # Iterate over the list of numbers
        for index, num in enumerate(nums):
            # Calculate the number that would complement the current number to reach the target
            complement = target - num
            
            # Check if the complement exists in the dictionary
            if complement in num_to_index:
                # If it exists, return the indices of the complement and the current number
                return [num_to_index[complement], index]
            
            # If it does not exist, store the number and its index in the dictionary
            num_to_index[num] = index

        # If no solution is found, though the problem guarantees one, return an empty list
        return []
