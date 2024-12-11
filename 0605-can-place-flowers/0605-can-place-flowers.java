public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0; // To track the number of flowers planted
        
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean emptyLeftPlot = (i == 0) || (flowerbed[i - 1] == 0);
                boolean emptyRightPlot = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);
                
                if (emptyLeftPlot && emptyRightPlot) {
                    flowerbed[i] = 1; // Mark the current plot as planted
                    count++; // Increment the flower count
                    
                    if (count >= n) {
                        return true;
                    }
                }
            }
        }
        
        // If we've finished iterating and haven't planted enough flowers
        return count >= n;
    }
}
