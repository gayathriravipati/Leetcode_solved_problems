class Solution {
    int[][] grid;
    boolean[][] visited;
    int rows;
    int cols;
    
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        visited = new boolean[rows][cols];
        int maxArea = 0;
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    maxArea = Math.max(maxArea, explore(i,j));
                }
            }
        }
        
        return maxArea;
    }
    
    private int explore(int r, int c){
        visited[r][c] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r,c});
        int totalCells = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while(!queue.isEmpty()){
            totalCells++;
            int[] current = queue.poll();
            int currRow = current[0];
            int currCol = current[1];
            
            for(int i = 0; i<dirs.length; i++){
                int newRow = currRow + dirs[i][0];
                int newCol = currCol + dirs[i][1];
                
                if(newRow >= 0 && newRow < rows && newCol >=0 && newCol < cols && grid[newRow][newCol] == 1 && !visited[newRow][newCol]){
                    queue.add(new int[]{newRow,newCol});
                    visited[newRow][newCol] = true;
                }
            }   
        }
        
        return totalCells;
    }
}