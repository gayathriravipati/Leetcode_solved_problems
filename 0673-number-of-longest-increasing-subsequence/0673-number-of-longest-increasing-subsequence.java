class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int[] dp = new int[n];     
        int[] count = new int[n]; 
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        int maxLen = 1;

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j]; 
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j]; 
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        int totalLIS = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLen) {
                totalLIS += count[i];
            }
        }

        return totalLIS;
    }
}
