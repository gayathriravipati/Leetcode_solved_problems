class Solution {
    int[][] grid;
    int rows;
    int cols;
    boolean[][] visited;
    
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        visited = new boolean[rows][cols];
        int maxArea = 0;
        //iteration
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    maxArea = Math.max(maxArea, explore(i,j));
                }
            }
        }
        return maxArea;
    }
    
    private int explore(int r, int c){
        visited[r][c] = true;
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        int totalCells = 0;
        
        while(!q.isEmpty()){
            totalCells++;
            int[] current = q.poll();
            int currentRow = current[0];
            int currentCol = current[1];
            for(int i=0; i<dirs.length; i++){
                int newRow = currentRow + dirs[i][0];
                int newCol = currentCol + dirs[i][1];
                if(newRow >= 0 && newRow<= rows-1 && newCol>=0 && newCol<=cols-1 && grid[newRow][newCol]==1 && !visited[newRow][newCol]){
                    q.add(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
        return totalCells;
    }
    
}