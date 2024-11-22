import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Frequency map for characters in t
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        // Sliding window variables
        Map<Character, Integer> sMap = new HashMap<>();
        int left = 0, right = 0;
        int required = tMap.size();
        int formed = 0;
        int[] result = {-1, 0, 0}; // {window length, left, right}

        while (right < s.length()) {
            char ch = s.charAt(right);
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);

            // Check if this character satisfies the frequency requirement
            if (tMap.containsKey(ch) && sMap.get(ch).intValue() == tMap.get(ch).intValue()) {
                formed++;
            }

            // Try to shrink the window from the left
            while (left <= right && formed == required) {
                // Update result if this window is smaller
                if (result[0] == -1 || right - left + 1 < result[0]) {
                    result[0] = right - left + 1;
                    result[1] = left;
                    result[2] = right;
                }

                char leftChar = s.charAt(left);
                sMap.put(leftChar, sMap.get(leftChar) - 1);
                if (tMap.containsKey(leftChar) && sMap.get(leftChar).intValue() < tMap.get(leftChar).intValue()) {
                    formed--;
                }
                left++;
            }
            right++;
        }

        // Return the smallest window or an empty string if no valid window is found
        return result[0] == -1 ? "" : s.substring(result[1], result[2] + 1);
    }
}
