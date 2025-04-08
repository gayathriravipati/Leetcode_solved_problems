class Solution {
    //Solution learnt from editorial
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }

        if(totalSum % 2 != 0){
            return false;
        }

        int target = totalSum / 2;

        Boolean[][] dp = new Boolean[n+1][target+1];
        dp[0][0] = true;

        return dfs(nums, n, target, dp);
    }

    private Boolean dfs(int[] nums, int n, int target, Boolean[][] dp){
        if(target == 0){
            return true;
        }

        if(n <= 0 || target < 0){
            return false;
        }

        if (dp[n][target] != null){
            return dp[n][target];
        }
            
        dp[n][target] = dfs(nums, n-1, target - nums[n-1], dp) || dfs(nums, n-1, target, dp);
        return dp[n][target];
    }
}