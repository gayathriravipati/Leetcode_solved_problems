class Solution {
    
    int[][] matrix;
    int n;
    
    public int minFallingPathSum(int[][] matrix) {
        this.n = matrix.length;
        this.matrix = matrix;
        int[][] dp = new int[n][n];
        
        int minSum = Integer.MAX_VALUE;
        
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        for(int c = 0; c < matrix[0].length; c++){
            minSum = Math.min(minSum, findMinSum(0, c, dp));
        }
        return minSum;
    }
    
    public int findMinSum(int row, int col, int[][] dp){
        
        if(col < 0 || col == n){
            return Integer.MAX_VALUE;
        }
        
        if (row == n - 1) {
            return matrix[row][col];
        }
        
         if (dp[row][col] != Integer.MAX_VALUE) {
            return dp[row][col];
        }
        
        int left = findMinSum(row + 1, col - 1, dp);
        int right = findMinSum(row + 1, col + 1, dp);
        int mid = findMinSum(row + 1, col, dp);
        
        dp[row][col] = Math.min(left, Math.min(right, mid)) + matrix[row][col];;
        return dp[row][col];
    }
}