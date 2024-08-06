class Solution {
    public int getSum(int a, int b) {
        int x = Math.abs(a);
        int y = Math.abs(b);

        if (x < y) {
            return getSum(b, a); 
        }

        int sign = a > 0 ? 1 : -1;

        int res = 0;

        if (a * b >= 0) { 
            res = x + y;
        } else { 
            res = x - y;
        }

        return sign * res;
    }
}
