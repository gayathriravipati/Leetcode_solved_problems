class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        int len = s.length();
        HashSet<Character> st = new HashSet<>();
        int maxlen = 0;

        while (j < len) {
            if (!st.contains(s.charAt(j))) {
                st.add(s.charAt(j));
                j++;
                maxlen = Math.max(maxlen, j - i);
            } else {
                st.remove(s.charAt(i));
                i++;
            }
        }

        return maxlen;
    }
}