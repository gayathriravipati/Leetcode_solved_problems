import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public String minimizeStringValue(String s) {
        int n = s.length();
        int[] freq = new int[26];
        
        for (char ch : s.toCharArray()) {
            if (ch != '?') {
                freq[ch - 'a']++;
            }
        }
        
        List<Character> chars = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '?') {
                int indexOfMinElement = 0;
                for (int j = 0; j < 26; j++) {
                    if (freq[j] < freq[indexOfMinElement]) {
                        indexOfMinElement = j;
                    }
                }
                char chh = (char) (indexOfMinElement + 'a');
                chars.add(chh);
                freq[indexOfMinElement]++;
            }
        }
        
        Collections.sort(chars);
        
        StringBuilder sb = new StringBuilder(s);
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '?') {
                sb.setCharAt(i, chars.get(j++));
            }
        }
        
        return sb.toString();
    }
}
