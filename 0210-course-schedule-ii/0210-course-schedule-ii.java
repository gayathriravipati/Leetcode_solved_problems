class Solution {
    List<Integer> order = new ArrayList<>();
    int[][] prerequisites;
    List<Integer>[] adjacencyList;
    boolean[] visited;
    Set<Integer> currentNodes = new HashSet<>();
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.prerequisites = prerequisites;
        visited = new boolean[numCourses];
        
        
        adjacencyList = new ArrayList[numCourses];
        
        //Check neighbors and build
        
        for(int i = 0; i<numCourses; i++){
            adjacencyList[i] = new ArrayList<>();
        }
        
        
        for(int[] course : prerequisites){
            adjacencyList[course[0]].add(course[1]);
        }
        
        for(int i = 0; i<numCourses; i++){
            if(!visited[i]){
                if(!explore(i)){
                    return new int[0];   
                }
            }
        }
        int[] orderArray = order.stream().mapToInt(Integer::intValue).toArray();
        int[] result = new int[orderArray.length];
        int j = 0;
        for (int i = orderArray.length-1; i >=0; i--) {
            result[j++] = orderArray[i];
        }
        return orderArray;
    }
    
    public boolean explore(int i){
        visited[i] = true;
        currentNodes.add(i);
        
        List<Integer> neighbors = adjacencyList[i];
        
        for(int neighbor : neighbors){
            if(currentNodes.contains(neighbor)){
                    return false;
            }
            
            if(!visited[neighbor]){
                 if(!explore(neighbor)){
                     return false;
                 }
            }
        }
        currentNodes.remove(i);
        order.add(i);
        return true;
    }
}