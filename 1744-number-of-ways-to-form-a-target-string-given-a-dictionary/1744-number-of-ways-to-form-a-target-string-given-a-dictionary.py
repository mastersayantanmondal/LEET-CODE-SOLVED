class Solution(object):
    def numWays(self, words, target):
        """
        :type words: List[str]
        :type target: str
        :rtype: int
        """
        MOD = 10**9 + 7
        m, n = len(words), len(words[0])  # Number of words and their length
        t_len = len(target)

        # Precompute the frequency of each character at each position
        freq = [[0] * 26 for _ in range(n)]
        for word in words:
            for i, char in enumerate(word):
                freq[i][ord(char) - ord('a')] += 1

        # DP array
        dp = [0] * (t_len + 1)
        dp[0] = 1  # One way to form an empty string

        # Update DP table
        for j in range(n):  # Iterate over positions in `words`
            # Traverse target from end to start to avoid overwriting states
            for i in range(t_len - 1, -1, -1):
                char_index = ord(target[i]) - ord('a')
                dp[i + 1] += dp[i] * freq[j][char_index]
                dp[i + 1] %= MOD

        return dp[t_len]
