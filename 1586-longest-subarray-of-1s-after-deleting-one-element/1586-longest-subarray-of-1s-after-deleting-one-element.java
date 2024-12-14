class Solution {
    public int longestSubarray(int[] nums) {
        int start = 0;  
        int zerosCount = 0;  
        int maxLength = 0;  

        for (int end = 0; end < nums.length; end++) {
            
            if (nums[end] == 0) {
                zerosCount++;
            }

            while (zerosCount > 1) {
                if (nums[start] == 0) {
                    zerosCount--;
                }
                start++;
            }

            maxLength = Math.max(maxLength, end - start);
        }

        return maxLength;
    }
}
