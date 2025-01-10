class Solution(object):
    def wordSubsets(self, words1, words2):
        """
        :type words1: List[str]
        :type words2: List[str]
        :rtype: List[str]
        """
        # Step 1: Compute the maximum frequency for each character in words2
        max_freq = Counter()
        for word in words2:
            word_freq = Counter(word)
            for char, count in word_freq.items():
                max_freq[char] = max(max_freq[char], count)
        
        # Step 2: Filter the universal strings from words1
        result = []
        for word in words1:
            word_freq = Counter(word)
            if all(word_freq[char] >= count for char, count in max_freq.items()):
                result.append(word)
        
        return result
