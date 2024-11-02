class Solution {
    public int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }

        char ch = chars[0];
        int cnt = 1;
        int idx = 0;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == ch) {
                cnt++;
            } else {
                chars[idx++] = ch;
                if (cnt > 1) {
                    for (char c : Integer.toString(cnt).toCharArray()) {
                        chars[idx++] = c;
                    }
                }
                ch = chars[i];
                cnt = 1;
            }
        }
        
        chars[idx++] = ch;
        if (cnt > 1) {
            for (char c : Integer.toString(cnt).toCharArray()) {
                chars[idx++] = c;
            }
        }

        return idx;
    }
}
