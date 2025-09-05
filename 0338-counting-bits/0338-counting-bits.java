class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];

        for(int i = 0; i<=n; i++){
            res[i] = findBits(i);
        }

        return res;
    }

    public int findBits(int n){
        int cnt = 0;
        while(n > 0){
            cnt++;
            n = n & (n-1);
        }
        return cnt;
    }
}