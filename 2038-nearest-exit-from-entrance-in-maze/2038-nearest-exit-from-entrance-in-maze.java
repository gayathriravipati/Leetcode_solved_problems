class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int cols = maze[0].length;
        boolean[][] visited = new boolean[rows][cols];

        Queue<int[]> q = new LinkedList<>();
        q.add(entrance);
        int steps = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        visited[entrance[0]][entrance[1]] = true;


        while(!q.isEmpty()){
            int size = q.size();
            steps++;
            for(int i=0; i<size; i++){
                int[] top = q.poll();
                int currRow = top[0];
                int currCol = top[1];
                System.out.println(currRow + " " + currCol);
                for(int[] dir : dirs){
                    int nRow = dir[0] + currRow;
                    int nCol = dir[1] + currCol;
                    if(nRow >= 0 && nRow < rows && nCol >=0 && nCol < cols && 
                    !visited[nRow][nCol] && maze[nRow][nCol] == '.'){
                        if((nRow == 0 || nRow == rows-1 || nCol == 0 || nCol == cols -1) &&
                            !(nRow == entrance[0] && nCol == entrance[1])){
                            return steps;
                        }
                        visited[nRow][nCol] = true;
                        q.add(new int[]{nRow, nCol});
                    }
                }
            }
        }
        return -1;
    }
}