class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxValuesI = values[0]; 
        int maxScore = 0; 

        for (int j = 1; j < values.length; j++) {
            maxScore = Math.max(maxScore, maxValuesI + values[j] - j);
            maxValuesI = Math.max(maxValuesI, values[j] + j);
        }

        return maxScore;
    }
}
