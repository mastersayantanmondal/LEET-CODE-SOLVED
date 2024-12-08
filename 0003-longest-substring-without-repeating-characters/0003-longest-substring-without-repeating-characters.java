import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // HashSet to store characters in the current window
        HashSet<Character> charSet = new HashSet<>();
        // Left pointer of the sliding window
        int left = 0;
        // Variable to track the maximum length of the substring
        int maxLength = 0;

        // Iterate over the string with the right pointer
        for (int right = 0; right < s.length(); right++) {
            // If the character is already in the set, slide the left pointer
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }
            
            // Add the current character to the set
            charSet.add(s.charAt(right));

            // Update the maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
