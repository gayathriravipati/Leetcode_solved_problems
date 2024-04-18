class Solution {
    int[][] grid;
    boolean[][] visited;
    int maxArea = 0;

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        int rows = grid.length;
        int columns = grid[0].length;
        visited = new boolean[rows][columns]; 
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {  
                    maxArea = Math.max(maxArea, dfs(i, j));
                }
            }
        }
        return maxArea;
    }

    public int dfs(int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true; 
        return 1 + dfs(i - 1, j) + dfs(i + 1, j) + dfs(i, j - 1) + dfs(i, j + 1);
    }
}
