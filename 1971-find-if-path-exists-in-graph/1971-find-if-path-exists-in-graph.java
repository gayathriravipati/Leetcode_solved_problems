class Solution {
    private boolean dfs(List<Integer>[] connections, int currentVertex, int destination, boolean[] visited) {
    if (currentVertex == destination) {
        return true;
    }
    
    visited[currentVertex] = true;
    
    for (int connectedVertex : connections[currentVertex]) {
        if (!visited[connectedVertex]) {
            if (dfs(connections, connectedVertex, destination, visited)) {
                return true;
            }
        }
    }
    
    return false;
}

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] connections = new List[n];
        for (int i = 0; i < n; i++) {
            connections[i] = new ArrayList<>();
        }
        if (edges.length == 0) 
            return source == destination;

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            connections[from].add(to);
            connections[to].add(from);
        }
        
       List<Integer> sourceConnections = connections[source];
    
    boolean[] visited = new boolean[connections.length];

    return dfs(connections, source, destination, visited);
        
    }
}