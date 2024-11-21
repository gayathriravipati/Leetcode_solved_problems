class Solution {
    int rows, cols, guarded = 0;
    char[][] matrix;

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        this.rows = m;
        this.cols = n;
        this.matrix = new char[m][n];
        int totalCells = m * n;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = '.';
            }
        }

        for (int[] guard : guards) {
            matrix[guard[0]][guard[1]] = 'G';
        }
        for (int[] wall : walls) {
            matrix[wall[0]][wall[1]] = 'W';
        }

        for (int[] guard : guards) {
            int r = guard[0];
            int c = guard[1];
            explore(r, c);
        }

        int unguarded = totalCells - guarded - guards.length - walls.length;
        return unguarded;
    }

    private void explore(int r, int c) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            while (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                if (matrix[nr][nc] == 'G' || matrix[nr][nc] == 'W') {
                    break; 
                }

                if (matrix[nr][nc] == '.') {
                    matrix[nr][nc] = '#'; 
                    guarded++;
                }

                nr += dir[0];
                nc += dir[1];
            }
        }
    }
}
