class Solution {
    public int maxDistance(String s, int k) {
        char[] dirs = {'S','N','E','W'};
        int best = 0;
        for (char v : new char[]{'N','S'}) {
            for (char h : new char[]{'E','W'}) {
                best = Math.max(best, calc(s, k, v, h));
            }
        }
        return best;
    }

    static int calc(String s, int K, char a, char b) {
        int mx = 0, cnt = 0, ans = 0;
        for (char c : s.toCharArray()) {
            if (c == a || c == b) {
                mx++;
            } else if (cnt < K) {
                mx++;
                cnt++;
            } else {
                mx--;
            }
            ans = Math.max(ans, mx);
        }
        return ans;
    }
}