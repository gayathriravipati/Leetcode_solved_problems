import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[][] grid;
    boolean[][] visited;
    
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        this.grid = grid;
        int rows = grid.length;
        int cols = grid[0].length;
        this.visited = new boolean[rows][cols];
        int maxArea = 0;
        
        // Iteration through the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, explore(i, j));
                }
            }
        }
        return maxArea; 
    }
    
    private int explore(int r, int c) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        int totalCells = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        visited[r][c] = true;
        
        while (!queue.isEmpty()) {
            totalCells++;
            int[] current = queue.poll();
            int currRow = current[0];
            int currCol = current[1];
            
            for (int[] dir : directions) {
                int newRow = currRow + dir[0];
                int newCol = currCol + dir[1];
                
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols 
                    && grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                    queue.add(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
        return totalCells;
    }
}
