import java.util.HashMap;
import java.util.Map;

class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> mp = new HashMap<>();
        
        for (char ch : s.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }
        
        char[] result = new char[s.length()];
        int index = 0;
        
        for (char ch : order.toCharArray()) {
            int freq = mp.getOrDefault(ch, 0);
            while (freq > 0) {
                result[index++] = ch;
                freq--;
            }
            mp.remove(ch);
        }
        
        for (char ch : mp.keySet()) {
            int freq = mp.get(ch);
            while (freq > 0) {
                result[index++] = ch;
                freq--;
            }
        }
        
        return new String(result);
    }
}
