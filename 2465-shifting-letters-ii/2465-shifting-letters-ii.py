class Solution(object):
    def shiftingLetters(self, s, shifts):
        """
        :type s: str
        :type shifts: List[List[int]]
        :rtype: str
        """
        # Initialize a difference array to track shifts
        n = len(s)
        diff = [0] * (n + 1)

        # Populate the difference array with shifts
        for start, end, direction in shifts:
            shift = 1 if direction == 1 else -1
            diff[start] += shift
            diff[end + 1] -= shift

        # Calculate the net shifts at each index
        net_shifts = [0] * n
        current_shift = 0
        for i in range(n):
            current_shift += diff[i]
            net_shifts[i] = current_shift

        # Apply shifts to the string
        result = []
        for i, char in enumerate(s):
            shift = (ord(char) - ord('a') + net_shifts[i]) % 26
            result.append(chr(ord('a') + shift))

        return ''.join(result)
       