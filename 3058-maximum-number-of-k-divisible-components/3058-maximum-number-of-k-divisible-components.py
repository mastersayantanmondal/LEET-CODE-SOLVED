class Solution(object):
    def maxKDivisibleComponents(self, n, edges, values, k):
        """
        :type n: int
        :type edges: List[List[int]]
        :type values: List[int]
        :type k: int
        :rtype: int
        """
        from collections import defaultdict

        # Build the adjacency list for the tree
        tree = defaultdict(list)
        for u, v in edges:
            tree[u].append(v)
            tree[v].append(u)

        self.result = 0  # To count the number of valid components

        def dfs(node, parent):
            # Calculate the sum of the current subtree
            subtree_sum = values[node]
            for neighbor in tree[node]:
                if neighbor != parent:
                    subtree_sum += dfs(neighbor, node)

            # If the subtree sum is divisible by k, form a new component
            if subtree_sum % k == 0:
                self.result += 1
                return 0  # Reset the sum for this component

            return subtree_sum

        dfs(0, -1)

        return self.result
