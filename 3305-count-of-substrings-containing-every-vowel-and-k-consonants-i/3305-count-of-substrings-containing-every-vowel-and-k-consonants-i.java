class Solution {
    public int countOfSubstrings(String word, int k) {
        // Map to store frequency of vowels in the current window
        Map<Character, Integer> vowelCount = new HashMap<>();
        int wordLen = word.length();
        int consonantCount = 0;
        int result = 0;

        // Iterate with the left pointer `i`
        for (int i = 0; i < wordLen; i++) {
            vowelCount.clear(); // reset the vowel count for each new starting point
            consonantCount = 0; // reset the consonant count

            // Move the right pointer `j` starting from `i`
            for (int j = i; j < wordLen; j++) {
                char ch = word.charAt(j);

                // Check if the current character is a vowel
                if (isVowel(ch)) {
                    vowelCount.put(ch, vowelCount.getOrDefault(ch, 0) + 1);
                } else {
                    // Increment consonant count
                    consonantCount++;
                }

                // If consonant count exceeds k, break out of the loop as further substrings won't satisfy the condition
                if (consonantCount > k) {
                    break;
                }

                // Check if we have all 5 vowels and exactly k consonants
                if (vowelCount.size() == 5 && consonantCount == k) {
                    result++;
                }
            }
        }

        return result;
    }

    // Helper method to check if a character is a vowel
    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
