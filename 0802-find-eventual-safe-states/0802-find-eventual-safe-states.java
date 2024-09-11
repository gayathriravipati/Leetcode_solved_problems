import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        Set<Integer> visited = new HashSet<>();
        Set<Integer> inStack = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                if(!inStack.contains(i)){
                    explore(i, visited, graph, inStack);
                }
                else{
                    continue;
                }
            }
        }
        
        List<Integer> safeNodes = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (visited.contains(i)) {
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }
    
    private boolean explore(int idx, Set<Integer> visited, int[][] graph, Set<Integer> inStack) {
        if (inStack.contains(idx)) {
            return false;
        }
        
        if (visited.contains(idx)) {
            return true;
        }
        
        visited.add(idx);
        inStack.add(idx);
        
        for (int neighbor : graph[idx]) {
            if (!explore(neighbor, visited, graph, inStack)) {
                visited.remove(idx);
                return false;
            }
        }
        
        inStack.remove(idx);
        return true;
    }
}
