class Solution {
    public int countOfSubstrings(String word, int k) {
        
        Map<Character, Integer> vowelCount = new HashMap<>();
        int wordLen = word.length();
        int consonantCount = 0;
        int result = 0;
        int targetLen = 5 + k;

        for (int i = 0; i <= wordLen - targetLen; i++) {
            vowelCount.clear(); 
            consonantCount = 0; 

            for (int j = i; j < wordLen; j++) {
                char ch = word.charAt(j);

                if (isVowel(ch)) {
                    vowelCount.put(ch, vowelCount.getOrDefault(ch, 0) + 1);
                } else {
                    consonantCount++;
                }

                if (consonantCount > k) {
                    break;
                }

                if (vowelCount.size() == 5 && consonantCount == k) {
                    result++;
                }
            }
        }

        return result;
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
