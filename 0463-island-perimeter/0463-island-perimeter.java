class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int u,d,l,ri;
        int t = 0;
        
        for(int r=0;r<rows;r++){
            
            for(int c=0;c<columns;c++){
                
                if(grid[r][c]==1){
                    if(r==0){
                        u = 0;
                    }
                    else{
                        u = grid[r-1][c];
                    }
                    
                    if(c==0){
                        l = 0;
                    }
                    else{
                        l = grid[r][c-1];
                    }
                    
                    if(r==rows-1){
                        d = 0;
                    }
                    else{
                        d = grid[r+1][c];
                    }
                    
                    if(c==columns-1){
                        ri= 0;
                    }
                    else{
                        ri = grid[r][c+1];
                    }
                    
                    t  = t + 4 - (u + d + l + ri);
                }
            }
        }
        return t;
    }
}