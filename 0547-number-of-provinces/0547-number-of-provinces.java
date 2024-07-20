class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> neighbors = new ArrayList<>();
        
        for (int i = 0; i < isConnected.length; i++) {
            neighbors.add(new ArrayList<>());
        }
        
        for(int i=0; i<isConnected.length; i++){
            for(int j=i+1; j<isConnected[0].length; j++){
                if(isConnected[i][j] == 1){
                    neighbors.get(i).add(j);
                    neighbors.get(j).add(i);
                }
            }
        }
        
        int totalProvinces = 0;
        Set<Integer> visited = new HashSet<>();
        
        
        for(int i = 0; i<neighbors.size(); i++){
            if(!visited.contains(i)){
                totalProvinces++;
                dfs(i,neighbors,visited);
            }
        }
        
        return totalProvinces;
    }
    
    public void dfs(int i, List<List<Integer>> neighbors, Set<Integer> visited){
        visited.add(i);
        for(int j = 0; j<neighbors.get(i).size(); j++){
            if(!visited.contains(neighbors.get(i).get(j))){
                visited.add(neighbors.get(i).get(j));
                dfs(neighbors.get(i).get(j),neighbors,visited);
            }
        }
    }
    
}