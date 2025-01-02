class Solution(object):
    def vowelStrings(self, words, queries):
        """
        :type words: List[str]
        :type queries: List[List[int]]
        :rtype: List[int]
        """
        def is_vowel_string(s):
            vowels = {'a', 'e', 'i', 'o', 'u'}
            return s[0] in vowels and s[-1] in vowels

        # Preprocess with a prefix sum array
        n = len(words)
        prefix = [0] * (n + 1)
        for i in range(n):
            prefix[i + 1] = prefix[i] + (1 if is_vowel_string(words[i]) else 0)

        # Answer each query
        ans = []
        for li, ri in queries:
            ans.append(prefix[ri + 1] - prefix[li])

        return ans
