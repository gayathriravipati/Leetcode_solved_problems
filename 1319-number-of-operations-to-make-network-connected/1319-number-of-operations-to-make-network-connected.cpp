class Solution {
public:
    void dfs(int node, vector<vector<int>>& adj, vector<bool>& visit) {
        visit[node] = true;
        for (int neighbor : adj[node]) {
            if(!visit[neighbor]){
                dfs(neighbor, adj, visit);
            }
        }
    }

    int makeConnected(int n, vector<vector<int>>& connections) {
        int l = connections.size();
        if(l<n-1){
            return -1;
        }
         vector<vector<int>> adj(n);
         for (int i=0;i<l;i++) {
            adj[connections[i][0]].push_back(connections[i][1]);
            adj[connections[i][1]].push_back(connections[i][0]);
        }
        int numberOfConnectedComponents = 0;
        vector<bool> visit(n);
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                numberOfConnectedComponents++;
                dfs(i, adj, visit);
            }
        }
            return numberOfConnectedComponents - 1;
    }
};