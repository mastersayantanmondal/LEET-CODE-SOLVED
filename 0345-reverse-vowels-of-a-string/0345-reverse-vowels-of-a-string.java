class Solution {
    public String reverseVowels(String s) {
        // Define the set of vowels
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray(); // Convert string to character array
        int left = 0, right = s.length() - 1;

        // Use two pointers to find vowels and swap them
        while (left < right) {
            // Move left pointer until it points to a vowel
            while (left < right && vowels.indexOf(chars[left]) == -1) {
                left++;
            }
            // Move right pointer until it points to a vowel
            while (left < right && vowels.indexOf(chars[right]) == -1) {
                right--;
            }
            // Swap the vowels
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            // Move both pointers inward
            left++;
            right--;
        }

        // Convert the character array back to a string
        return new String(chars);
    }
}
