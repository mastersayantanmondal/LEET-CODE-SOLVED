class Solution {
    public String reverseWords(String s) {
        // Step 1: Trim leading and trailing spaces
        s = s.trim();

        // Step 2: Split the string into words using spaces as delimiters
        String[] words = s.split("\\s+"); // \\s+ matches one or more spaces

        // Step 3: Reverse the array of words
        int left = 0, right = words.length - 1;
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }

        // Step 4: Join the reversed words into a single string with a space delimiter
        return String.join(" ", words);
    }
}
