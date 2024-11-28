class Solution {
    int rows;
    int cols;
    
    public int minimumObstacles(int[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        int[][] minObstacles = new int[rows][cols];
        
        for(int i = 0; i<rows; i++){
            for(int j=0; j<cols; j++){
                minObstacles[i][j] = Integer.MAX_VALUE;
            }
        }
        
        Deque<int[]> dq = new ArrayDeque<>();
        if(grid[0][0] == 0){
            dq.addFirst(new int[] {0, 0, 0});
            minObstacles[0][0] = 0;
        }
        else{
            dq.addFirst(new int[] {1, 0, 0});
            minObstacles[0][0] = 1;
        }
        
        
        while(!dq.isEmpty()){
            int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
            int[] nextCell = dq.poll();
            int obs = nextCell[0];
            int r = nextCell[1];
            int c = nextCell[2];
            
            for(int[] dir : dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                if(isValid(nr, nc) && minObstacles[nr][nc] == Integer.MAX_VALUE){
                    
                    if(grid[nr][nc] == 1){
                        dq.addLast(new int[] {obs + 1, nr, nc});
                        minObstacles[nr][nc] = obs + 1;
                    }
                    else{
                         dq.addFirst(new int[] {obs, nr, nc});
                        minObstacles[nr][nc] = obs;
                    }
                    
                    
                    
                    if(nr == rows-1 && nc == cols-1){
                        return minObstacles[nr][nc];
                    }
                }
            }           
        }
        
        return -1;
    }
    
    public boolean isValid(int r , int c){
        if(r < 0 || r >= rows || c < 0 || c >= cols){
            return false;
        }
        return true;
    }
}