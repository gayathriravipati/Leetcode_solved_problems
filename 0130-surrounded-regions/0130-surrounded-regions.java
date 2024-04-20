class Solution {
    char[][] board;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up, Down, Left, Right

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        this.board = board;

        // Traverse the boundary cells
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1)) {
                    dfs(i, j); // Start DFS from boundary 'O' cells
                }
            }
        }

        // After DFS, flip the 'O's to 'X's and the temporary 'T's back to 'O's
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return; // Out of bounds or cell is not 'O'
        }

        // Mark the current 'O' as temporary 'T' to indicate it's visited
        board[i][j] = 'T';

        // Explore neighboring cells
        for (int[] dir : directions) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            dfs(ni, nj); // Recursive DFS
        }
    }
}
