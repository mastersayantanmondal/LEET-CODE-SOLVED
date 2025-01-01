class Solution(object):
    def maxScore(self, s):
        """
        :type s: str
        :rtype: int
        """
        # Calculate total ones in the string
        total_ones = sum(1 for char in s if char == '1')
        max_score = 0
        left_zeros = 0  # Cumulative count of zeros in the left substring
        left_ones = 0   # Cumulative count of ones in the left substring

        for i in range(len(s) - 1):  # Avoid splitting at the last character
            if s[i] == '0':
                left_zeros += 1
            else:
                left_ones += 1

            # Calculate ones in the right substring
            right_ones = total_ones - left_ones
            # Calculate score
            score = left_zeros + right_ones
            # Update maximum score
            max_score = max(max_score, score)

        return max_score
