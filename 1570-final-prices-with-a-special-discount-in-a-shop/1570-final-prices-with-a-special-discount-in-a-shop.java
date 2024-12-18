class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = new int[n];
        System.arraycopy(prices, 0, result, 0, n);
        
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int idx = stack.pop();
                result[idx] -= prices[i];
            }
            stack.push(i);
        }
        
        return result;
    }
}
