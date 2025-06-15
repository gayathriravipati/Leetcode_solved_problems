class Solution {
    public String mergeAlternately(String word1, String word2) {
        int word1idx = 0;
        int word2idx = 0;

        int word1Len = word1.length();
        int word2Len = word2.length();

        StringBuilder sb = new StringBuilder();

        while(word1idx < word1Len && word2idx < word2Len){
            sb.append(word1.charAt(word1idx));
            sb.append(word2.charAt(word2idx));
            word1idx++;
            word2idx++;
        }

        while(word1idx < word1Len){
            sb.append(word1.charAt(word1idx));
            word1idx++;
        }

        while(word2idx < word2Len){
            sb.append(word2.charAt(word2idx));
            word2idx++;
        }
        return sb.toString();
    }
}