class Solution {
    public int climbStairs(int n) {

        if(n == 1){
            return 1;
        }

        if(n==2){
            return 2;
        }

        int[] dp = new int[n+1];
        dp[n] = 0;
        dp[n-1] = 1;

        for(int i = n-2; i>=0; i--){
            dp[i] = 1 + Math.max(dp[i+1], dp[i+2]);
        }

        return dp[0];
    }
}