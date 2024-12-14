class Solution {
    public boolean uniqueOccurrences(int[] arr) {
      Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
     Set<Integer> freqSet = new HashSet<>();
        for (int count : freqMap.values()) {
            if (!freqSet.add(count)) {
                return false;  
            }
        }
        
        return true; 
    }
}