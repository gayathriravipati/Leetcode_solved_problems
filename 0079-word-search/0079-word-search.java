class Solution {
    char[][] board;
    String word;
    int rows;
    int cols;
    
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.rows = board.length;
        this.cols = board[0].length;
        
        //iterate until the first char is found

        for(int i = 0; i< rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == word.charAt(0)){
                    if(explore(i, j, 1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean explore(int i, int j, int idx){
        if(idx == word.length()){
            return true;
        }
        
        int[][] dirs = {{1,0}, {-1,0}, {0, 1}, {0, -1}};
        
        char ch = board[i][j];
        board[i][j] = '#';
        
        for(int it = 0; it < dirs.length; it++){
            int nr = i + dirs[it][0];
            int nc = j + dirs[it][1];
            
            //validate nr and nc
            if(nr < 0 || nr >= rows || nc < 0 || nc >= cols || board[nr][nc] != word.charAt(idx)){
                continue;
            }
            
            if(explore(nr, nc, idx+1)){
                return true;
            }
        }
        board[i][j] = ch;
        return false;
    }
}