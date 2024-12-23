# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def minimumOperations(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: int
        """
        def min_swaps_to_sort(arr):
            n = len(arr)
            sorted_arr = sorted((val, idx) for idx, val in enumerate(arr))
            visited = [False] * n
            swaps = 0

            for i in range(n):
                if visited[i] or sorted_arr[i][1] == i:
                    continue

                cycle_size = 0
                x = i
                while not visited[x]:
                    visited[x] = True
                    x = sorted_arr[x][1]
                    cycle_size += 1

                if cycle_size > 1:
                    swaps += cycle_size - 1

            return swaps

        if not root:
            return 0

        queue = deque([root])
        total_swaps = 0

        while queue:
            level_size = len(queue)
            level_values = []

            for _ in range(level_size):
                node = queue.popleft()
                level_values.append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

            total_swaps += min_swaps_to_sort(level_values)

        return total_swaps
       