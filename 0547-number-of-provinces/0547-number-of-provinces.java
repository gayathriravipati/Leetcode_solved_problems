import java.util.*;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int totalProvinces = 0;
        List<Integer>[] adjacencylist = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adjacencylist[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {  
                if (isConnected[i][j] == 1) {
                    adjacencylist[i].add(j);
                    adjacencylist[j].add(i);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) { 
                totalProvinces++;
                explore(i, visited, adjacencylist);
            }
        }

        return totalProvinces;
    }

    public void explore(int idx, boolean[] visited, List<Integer>[] adjacencylist) {
        visited[idx] = true;
        for (int neighbor : adjacencylist[idx]) {  
            if (!visited[neighbor]) {
                explore(neighbor, visited, adjacencylist);
            }
        }
    }
}
