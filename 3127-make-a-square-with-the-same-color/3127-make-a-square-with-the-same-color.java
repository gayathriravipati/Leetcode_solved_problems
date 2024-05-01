class Solution {
    char[][] grid;
    public boolean toleft(int i,int j){
        int W=0,B=0;
        for (int row : new int[]{i, j}) {
            for (int col : new int[]{0, 1}) {
                char cell = grid[row][col];
                if (cell == 'W') {
                    W++;
                } else {
                    B++;
                }
            }
        }
        if((W==3 && B==1) || (W==1 && B==3) || (W==4 && B==0) || (W==0 && B==4)){
            return true;
        }
        return false;
    }
    
    public boolean toright(int i,int j){
        int W=0,B=0;
        for (int row : new int[]{i, j}) {
            for (int col : new int[]{1, 2}) {
                char cell = grid[row][col];
                if (cell == 'W') {
                    W++;
                } else {
                    B++;
                }
            }
        }
        if((W==3 && B==1) || (W==1 && B==3)|| (W==4 && B==0) || (W==0 && B==4)){
            return true;
        }
        return false;
    }
    
    public boolean canMakeSquare(char[][] grid) {
        this.grid = grid;
        boolean topleft = toleft(0,1);
        boolean bottomleft = toleft(1,2);
        boolean topright = toright(0,1);
        boolean bottomright = toright(1,2);
        if (topleft || bottomleft || topright || bottomright) {
            return true;
        }
        return false; 
    }
}