class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] dp = new int[cols];
        // dp[cols-1] = grid[rows-1][cols-1];        
        
        for(int r = rows-1; r >=0; r--){
            for(int c = cols-1; c >=0; c--){
                if(r==rows-1 && c==cols-1){
                    dp[c] = grid[r][c];
                }
                else if(r==rows-1 && c != cols-1){
                    dp[c] = dp[c+1] + grid[r][c];
                }
                else if(r!=rows-1 && c==cols-1){
                    dp[c] = dp[c] + grid[r][c];
                }
                else{
                    dp[c] =  grid[r][c] + Math.min(dp[c], dp[c+1]);
                }
            }
        }
        
        return dp[0];
        
    }
}