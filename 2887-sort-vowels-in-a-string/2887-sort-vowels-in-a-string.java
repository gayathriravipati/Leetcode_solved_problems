import java.util.*;

class Solution {
    public String sortVowels(String s) {
        // 1. Collect vowels
        // 2. Sort them
        // 3. Replace in original order

        StringBuilder vowelString = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                vowelString.append(ch);
            }
        }

        char[] charArray = vowelString.toString().toCharArray();
        Arrays.sort(charArray);

        int i = 0;
        StringBuilder res = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                res.append(charArray[i]);
                i++;
            } else {
                res.append(ch);
            }
        }

        return res.toString();
    }
}
