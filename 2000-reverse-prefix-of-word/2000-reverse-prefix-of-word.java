class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int f = 0;
        while (i < word.length() && word.charAt(i) != ch) {
            sb.insert(0, word.charAt(i));
            i++;
        }

        if (i < word.length()) {
            f = 1;
            sb.insert(0, word.charAt(i));
            i++;
        }

        while (i < word.length()) {
            sb.append(word.charAt(i));
            i++;
        }
        if(f==1){
            return sb.toString();
        }
        return word;
    }
}
