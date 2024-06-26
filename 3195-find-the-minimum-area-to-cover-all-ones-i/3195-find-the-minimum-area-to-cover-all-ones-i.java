class Solution {
    public int minimumArea(int[][] grid) {
        int lw = Integer.MAX_VALUE, rw = Integer.MIN_VALUE;
        int th = Integer.MAX_VALUE, bh = Integer.MIN_VALUE;
        int max_area = 0;
        
        for(int i = 0; i< grid.length; i++){
            for(int j = 0; j< grid[0].length; j++){
                if(grid[i][j]==1){
                    if(i < lw){
                        lw = i;
                    }
                    if(i > rw){
                        rw = i;
                    }
                    if(j < th){
                        th = j;
                    }
                    if(j > bh){
                        bh = j;
                    }
                }
            }
        }
        
        max_area = (rw - lw + 1) * (bh - th + 1);
        return max_area;
    }
}