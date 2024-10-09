class Solution {
    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder("a");
        while (sb.length() <= k) {
            int n = sb.length();
            for (int i = 0; i < n; i++) {
                char nextChar = (char) ((sb.charAt(i) - 'a' + 1) % 26 + 'a');
                sb.append(nextChar);
            }
        }
        return sb.charAt(k - 1);
    }
}
