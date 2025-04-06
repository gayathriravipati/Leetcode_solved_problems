class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        dp[n-1] = 1;
        int prev = 1;

        for(int i=n-2; i>=0; i--){
            int maxV = 0;
            for(int j = i+1; j<n; j++){
                if(nums[i] < nums[j]){
                    maxV = Math.max(maxV, dp[j]);
                }
            }
            dp[i] = 1 + maxV;
            prev = Math.max(prev, dp[i]);
         }
         return prev;
    }
}