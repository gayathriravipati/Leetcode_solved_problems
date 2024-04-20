class Solution {
    int[][] land;
    boolean[][] visited;
    List<int[]> groups;

    public int[][] findFarmland(int[][] land) {
        this.land = land;
        int m = land.length;
        int n = land[0].length;
        visited = new boolean[m][n];
        groups = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    int[] group = new int[4];
                    group[0] = i; 
                    group[1] = j;
                    group[2] = i; 
                    group[3] = j;
                    dfs(i, j, group);
                    groups.add(group);
                }
            }
        }

        int[][] resultArray = new int[groups.size()][];
        for (int i = 0; i < groups.size(); i++) {
            resultArray[i] = groups.get(i);
        }

        return resultArray;
    }

    private void dfs(int i, int j, int[] group) {
        if (i < 0 || i >= land.length || j < 0 || j >= land[0].length || land[i][j] == 0 || visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        group[2] = Math.max(group[2], i);
        group[3] = Math.max(group[3], j);

        dfs(i - 1, j, group); 
        dfs(i + 1, j, group); 
        dfs(i, j - 1, group); 
        dfs(i, j + 1, group);
    }
}
