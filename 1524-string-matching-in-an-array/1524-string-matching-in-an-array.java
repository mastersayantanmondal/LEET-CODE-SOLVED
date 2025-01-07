class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        
        // Iterate over each word
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                // Check if words[i] is a substring of words[j] and they are not the same word
                if (i != j && words[j].contains(words[i])) {
                    result.add(words[i]);
                    break; // Add the word only once
                }
            }
        }
        
        return result;
    }
}
