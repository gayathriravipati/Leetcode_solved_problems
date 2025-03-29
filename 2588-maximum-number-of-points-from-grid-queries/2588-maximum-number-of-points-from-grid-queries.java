class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int rows = grid.length;
        int cols = grid[0].length;
        int n = queries.length;
        int[] result = new int[n];
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        int[][] sortedQueries = new int[n][2];
        for(int i=0; i<n; i++){
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));


        int points = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.add(new int[] {grid[0][0], 0, 0});

        boolean[][] visited = new boolean[rows][cols];
        visited[0][0] = true;

        for(int[] query : sortedQueries){
            int queryValue = query[0];
            int queryIndex = query[1];

            while(!pq.isEmpty() && pq.peek()[0] < queryValue){
                int[] top = pq.poll();
                int v = top[0];
                int cr = top[1];
                int cc = top[2];
                points++;

                for(int[] dir : dirs){
                    int nr = cr + dir[0];
                    int nc = cc + dir[1];

                    if(nr >=0 && nc >=0 && nr < rows && nc < cols && !visited[nr][nc]){
                        pq.add(new int[] {grid[nr][nc], nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
            result[queryIndex] = points;
        }
            return result;
    }
}