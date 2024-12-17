class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (char c : freqMap.keySet()) {
            maxHeap.add(c);
        }

        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            char currentChar = maxHeap.poll(); 
            int count = freqMap.get(currentChar);
            
            int useCount = Math.min(repeatLimit, count);
            for (int i = 0; i < useCount; i++) {
                result.append(currentChar);
            }

            count -= useCount;

            if (count > 0) {
                if (maxHeap.isEmpty()) {
                    break; 
                }
                char nextChar = maxHeap.poll(); 
                result.append(nextChar); 

                freqMap.put(nextChar, freqMap.get(nextChar) - 1);
                if (freqMap.get(nextChar) > 0) {
                    maxHeap.add(nextChar);
                }

                freqMap.put(currentChar, count);
                maxHeap.add(currentChar);
            }
        }

        return result.toString();
    }
}
