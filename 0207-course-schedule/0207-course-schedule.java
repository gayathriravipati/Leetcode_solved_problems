class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjacencyList = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adjacencyList[prerequisites[i][1]].add(prerequisites[i][0]);  
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> inStack = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if (!visited.contains(i)) {  
                if (!dfs(i, visited, inStack, adjacencyList)) {  
                    return false;  
                }
            }
        }
        return true;  
    }

    private boolean dfs(int node, Set<Integer> visited, Set<Integer> inStack, List<Integer>[] adjacencyList) {
        visited.add(node);  
        inStack.add(node);  

        List<Integer> neighbors = adjacencyList[node];  

        // Traverse all neighbors
        for (int neighbor : neighbors) {
            if (inStack.contains(neighbor)) {  
                return false;
            }
            if (!visited.contains(neighbor)) {  
                if (!dfs(neighbor, visited, inStack, adjacencyList)) {  
                    return false; 
                }
            }
        }

        inStack.remove(node); 
        return true;  
    }

}