class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int columns = mat[0].length;
        int[][] result = new int[rows][columns];
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (mat[i][j] == 0) {
                    result[i][j] = 0;
                    queue.add(new int[]{i, j});
                } else {
                    result[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < columns) {
                    if (result[newRow][newCol] > result[row][col] + 1) {
                        result[newRow][newCol] = result[row][col] + 1;
                        queue.add(new int[]{newRow, newCol});
                    }
                }
            }
        }
        
        return result;
    }
}
