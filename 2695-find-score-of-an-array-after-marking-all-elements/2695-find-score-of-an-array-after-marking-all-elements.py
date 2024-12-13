class Solution(object):
    def findScore(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        # Min-heap to store (value, index) pairs
        heap = []
        for i, val in enumerate(nums):
            heapq.heappush(heap, (val, i))
        
        marked = set()  # To track marked indices
        score = 0

        while heap:
            val, idx = heapq.heappop(heap)
            
            # Skip if the element is already marked
            if idx in marked:
                continue
            
            # Add the value to the score
            score += val

            # Mark the current element and its adjacent elements
            marked.add(idx)
            if idx > 0:
                marked.add(idx - 1)
            if idx < n - 1:
                marked.add(idx + 1)
        
        return score
