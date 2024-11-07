class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        // int[] dp = new int[cols];
        // dp[cols-1] = grid[rows-1][cols-1];        
        
        for(int r = rows-1; r >=0; r--){
            for(int c = cols-1; c >=0; c--){
                if(r==rows-1 && c==cols-1){
                    grid[r][c] = grid[r][c];
                }
                else if(r==rows-1 && c != cols-1){
                    grid[r][c] = grid[r][c+1] + grid[r][c];
                }
                else if(r!=rows-1 && c==cols-1){
                    grid[r][c] = grid[r+1][c] + grid[r][c];
                }
                else{
                    grid[r][c] =  grid[r][c] + Math.min(grid[r+1][c], grid[r][c+1]);
                }
            }
        }
        
        return grid[0][0];
        
    }
}