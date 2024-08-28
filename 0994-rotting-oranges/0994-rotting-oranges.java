class Solution {
    
    public int orangesRotting(int[][] grid) {
        Queue<int[]> rottenOranges = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int totalMins = 0;
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 2){
                    rottenOranges.add(new int[]{i, j, 0}); 
                    visited[i][j] = true;
                }
            }
        }
        
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        while(!rottenOranges.isEmpty()){
            int[] current = rottenOranges.poll();
            int currentRow = current[0];
            int currentCol = current[1];
            int currentMin = current[2];
            totalMins = currentMin;
            
            for(int i=0; i<dirs.length; i++){
                int newRow = currentRow + dirs[i][0];
                int newCol = currentCol + dirs[i][1];
                
                if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol] && grid[newRow][newCol] == 1){
                    grid[newRow][newCol] = 2;
                    visited[newRow][newCol] = true;
                    rottenOranges.add(new int[]{newRow, newCol, currentMin + 1}); 
                }
            }
        }
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        
        return totalMins;
    }
}
