import java.util.*;

public class Solution {
    public int minimumPushes(String word) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            freqMap.put(word.charAt(i), freqMap.getOrDefault(word.charAt(i), 0) + 1);
        }

        List<Integer> freqList = new ArrayList<>(freqMap.values());

        Collections.sort(freqList, Collections.reverseOrder());

        int val = 1;
        int counter = 1;  
        int res = 0;

        for (int freq : freqList) {
            res += freq * val;
            counter++;

            if (counter == 9) {
                val++;
                counter = 1;  
            }
        }
        return res;
    }

}
