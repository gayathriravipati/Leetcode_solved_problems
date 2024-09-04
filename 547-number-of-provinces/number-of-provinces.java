class Solution {
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
         List<Integer>[] adjacencylist = new ArrayList[n];
        
        for(int i = 0; i < n; i++){
            adjacencylist[i] = new ArrayList<>();
        }
        
        for(int i=0; i<isConnected.length; i++){
            for(int j=0; j<isConnected[0].length; j++){
                if(isConnected[i][j] == 1){
                    adjacencylist[i].add(j);
                }
            }
        }
        
        boolean[] visited = new boolean[n];
        int totalProvinces = 0;
        
        for(int i=0; i<n; i++){
            if(!visited[i] && adjacencylist[i].size() > 0){
                System.out.println(i);
                totalProvinces++;
                explore(i, adjacencylist, visited);
            }
        }
        return totalProvinces;
    }
    
    private void explore(int idx, List<Integer>[] adjacencylist, boolean[] visited ){
        visited[idx] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        
        while(!q.isEmpty()){
            int cr = q.poll();
            List<Integer> neighbor = adjacencylist[cr];
            for(int i=0; i<neighbor.size(); i++){
                if(!visited[neighbor.get(i)]){
                    visited[neighbor.get(i)] = true;
                    q.add(neighbor.get(i));
                }
            }
        }
    }
    
}