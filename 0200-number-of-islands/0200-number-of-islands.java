class Solution {
    char[][] grid;
    boolean[][] visited;
    int c = 0;
    public int numIslands(char[][] grid) {
        this.grid = grid;
        visited = new boolean[grid.length][grid[0].length];
        for(int i = 0;i<grid.length;i++){
            for(int j=0;j< grid[0].length;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    c++;
                    dfs(i,j);
                }
            }
        }
        return c;
    }
    
    public void dfs(int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0' || visited[i][j]){
            return;
        }
        visited[i][j] = true;
        dfs(i+1,j);
        dfs(i,j+1);
        dfs(i-1,j);
        dfs(i,j-1);
    }
}