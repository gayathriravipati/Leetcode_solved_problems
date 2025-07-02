class Solution {
    public int findCircleNum(int[][] isConnected) {
       
        int n = isConnected.length;
        List<List<Integer>> adjacency = new ArrayList<>();
        

        for(int i = 0; i<n; i++){
            adjacency.add(new ArrayList<>());
        }

        //Now traverse the matrix to build the list
        for(int i=0; i<isConnected.length; i++){
            for(int j=0; j<isConnected[0].length; j++){
                if(isConnected[i][j] == 1){
                    adjacency.get(i).add(j);
                    adjacency.get(j).add(i);
                }
            }
        }

        //Now that we have adjacency list lets travel and build components.
        boolean[] visited = new boolean[n];
        int component = 0;
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                component++;
                dfs(visited, i, adjacency);
            }
        }
        return component;
    }

    public void dfs(boolean[] visited, int idx, List<List<Integer>> adjacency){
        visited[idx] = true;

        List<Integer> cities = adjacency.get(idx);

        for(int city : cities){
            if(!visited[city]){
                dfs(visited, city, adjacency);
            }
        }
    }
}