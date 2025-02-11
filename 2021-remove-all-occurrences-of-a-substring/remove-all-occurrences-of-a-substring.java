class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder st = new StringBuilder();
        int partLen = part.length();

        for (char ch : s.toCharArray()) {
            st.append(ch);
            
            if (st.length() >= partLen && st.substring(st.length() - partLen).equals(part)) {
                st.delete(st.length() - partLen, st.length());
            }
        }

        return st.toString();
    }
}
