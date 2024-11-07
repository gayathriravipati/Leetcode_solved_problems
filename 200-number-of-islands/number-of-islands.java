class Solution {
        char[][] grid;
        int rows;
        int cols;
        boolean[][] visited;
    
    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.visited = new boolean[rows][cols];
        int totalIslands = 0;
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    totalIslands++;
                    explore(i, j);
                } 
            }
        }
        return totalIslands;
    }
    
    public void explore(int i, int j){
        
        int[][] dirs = new int [][] {{1,0}, {0,1}, {-1,0}, {0,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i, j});
        
        System.out.println(grid[i][j]);
        
        while(!q.isEmpty()){
            int[] current = q.poll();
            int currentX = current[0];
            int currentY = current[1];
            
            for(int[] dir : dirs){
                int newdirX = currentX + dir[0];
                int newdirY = currentY + dir[1];
                
                if(newdirX >=0 && newdirX<rows && newdirY>=0 && newdirY<cols){
                    if(grid[newdirX][newdirY] == '1' && !visited[newdirX][newdirY]){
                        visited[newdirX][newdirY] = true;
                        q.add(new int[] {newdirX, newdirY});
                    }
                }  
            }
            
            }
        }
}