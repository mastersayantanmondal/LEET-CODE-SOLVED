class Solution(object):
    def countPalindromicSubsequence(self, s):
        """
        :type s: str
        :rtype: int
        """
        # Initialize data structures
        n = len(s)
        left = set()  # Characters seen on the left
        right = [0] * 26  # Count of characters on the right
        result_set = set()
        
        # Fill `right` array with character frequencies
        for char in s:
            right[ord(char) - ord('a')] += 1
        
        # Iterate through the string
        for i, mid in enumerate(s):
            # Update the count of `mid` in `right`
            right[ord(mid) - ord('a')] -= 1
            
            # Check all characters in the alphabet
            for char in range(26):
                ch = chr(char + ord('a'))
                if ch in left and right[char] > 0:
                    # Form the palindrome and add to the set
                    result_set.add(ch + mid + ch)
            
            # Update `left` for the next iteration
            left.add(mid)
        
        # Return the size of the result set
        return len(result_set)