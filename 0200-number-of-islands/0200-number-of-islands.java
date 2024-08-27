class Solution {
    char[][] grid;
    boolean[][] visited;
    int rows;
    int cols;
    
    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        visited = new boolean[rows][cols];
        int totalIslands = 0;
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    totalIslands++;
                    explore(i,j);
                }
            }
        }
        return totalIslands;
    }
    
    private void explore(int r, int c){
        visited[r][c] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        
        while(!q.isEmpty()){
            int[] current = q.poll();
            int currentRow = current[0];
            int currentCol = current[1];
            
            for(int i=0; i<dirs.length; i++){
                int newRow = currentRow + dirs[i][0];
                int newCol = currentCol + dirs[i][1];
                if(newRow >= 0 && newRow <= rows-1 && newCol>=0 && newCol <=cols-1 && !visited[newRow][newCol] && grid[newRow][newCol] == '1'){
                    q.add(new int[]{newRow,newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
    }
    
}