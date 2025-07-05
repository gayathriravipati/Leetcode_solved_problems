class Solution {
    int rows;
    int cols;
    public int orangesRotting(int[][] grid) {
        //Let's push all the rotten to the q - make it visited
        //For every rotten -- push the neighboring set to q
        //Repeat until q not empty and count minutes for every iteration.

        Queue<int[]> rotten = new LinkedList<>();
        int freshOrange = 0;
        this.rows = grid.length;
        this.cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 1){
                    freshOrange++;
                } 

                if(grid[i][j] == 2){
                    rotten.add(new int[] {i, j});
                    visited[i][j] = true;
                } 
            }
        }

        if (freshOrange == 0) {
            return 0;
        }


        int mins = -1;
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};

        while(!rotten.isEmpty()){
            mins++;
            int size = rotten.size();
            for(int i=0; i<size; i++){
               int[] current = rotten.poll();
               int cRow = current[0];
               int cCol = current[1];
               for(int d=0; d<dirs.length; d++){
                 int nR = cRow + dirs[d][0];
                 int nC = cCol + dirs[d][1];
                 if(isValid(nR, nC) && !visited[nR][nC]){
                    if(grid[nR][nC] == 1){
                        freshOrange--;
                        rotten.add(new int[] {nR, nC});
                    }
                    visited[nR][nC] = true;
                 }
               }
            }
        }

        return freshOrange == 0 ? mins : -1;
    }

    public boolean isValid(int r, int c){
        if(r >= 0 && r < rows && c >=0 && c < cols){
            return true;
        }
        return false;
    }
}