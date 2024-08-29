class Solution {
    public int removeStones(int[][] stones) {
        //let us build the components
        int l = stones.length;
        if(l==1){
            return 0;
        }
        
        List<Integer>[] neighbors = new ArrayList[l];
        
        //initiate the ArrayList for all the n nodes
        for(int i=0; i<l; i++){
            neighbors[i] = new ArrayList<>();
        }
        
        //build neighbors
        for(int i=0; i<l; i++){
            for(int j=i+1; j<l; j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    neighbors[i].add(j);
                    neighbors[j].add(i);
                }
            }
        }
        
        int totalComponents = 0;
        boolean[] visited = new boolean[l];
        
        for(int i=0; i<l; i++){
            if (!visited[i]) {
                totalComponents++;
                depthFirstSearch(neighbors, visited, i);
            }
        }
        return l - totalComponents;
    }

    private void depthFirstSearch(List<Integer>[] adjacencyList,
        boolean[] visited,
        int idx
    ){
        visited[idx] = true;
        
        for(int i : adjacencyList[idx]){
            if(!visited[i]){
                depthFirstSearch(adjacencyList, visited, i);
            }
        }
    }
}