class Solution {
    int[][] grid1;
    int[][] grid2;
    boolean[][] visited;
    int rows;
    int cols;
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        this.grid1 = grid1;
        this.grid2 = grid2;
        this.rows = grid1.length;
        this.cols = grid1[0].length;
        this.visited = new boolean[rows][cols];
        int totalSubIslands = 0;
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(!visited[i][j] && grid2[i][j] == 1 && grid1[i][j] == 1) {
                    if(explore(i, j)) {
                        totalSubIslands++;
                    }
                }
            }
        }
        
        return totalSubIslands;
    }
    
    private boolean explore(int r, int c) {
        boolean isSubIsland = true;
        visited[r][c] = true;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        
        while(!q.isEmpty()) {
            int[] current = q.poll();
            int cr = current[0];
            int cc = current[1];
            
            for(int[] dir : dirs) {
                int nr = cr + dir[0];
                int nc = cc + dir[1];
                
                if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc]) {
                    if(grid2[nr][nc] == 1) {
                        if(grid1[nr][nc] == 0) {
                            isSubIsland = false;  
                        }
                        visited[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }
        
        return isSubIsland;
    }
}
