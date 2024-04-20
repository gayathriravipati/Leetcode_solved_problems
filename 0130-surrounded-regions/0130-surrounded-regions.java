class Solution {
    char[][] board;
    
    public void solve(char[][] board) {
        this.board = board;
        
        for(int i = 0;i < board.length; i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j]=='O' && (i==0 || i==board.length-1 || j==0 || j==board[0].length-1)){
                    dfs(i,j);
                }
            }
        }
        
        for(int i = 0;i < board.length; i++){
            for(int j = 0;j < board[0].length;j++){
                if(board[i][j] == 'O'){
                     board[i][j]='X';
                }
                else if(board[i][j] =='T'){
                     board[i][j]='O';
                }
            }
        }
        
    }
    
    public void dfs(int i, int j){
         if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O'){
            return;
        }
        
        board[i][j] = 'T';
        
        dfs(i - 1, j);
        dfs(i + 1, j);
        dfs(i, j - 1);
        dfs(i, j + 1);
    }
}