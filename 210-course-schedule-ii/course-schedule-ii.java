import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjacencyList = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) { 
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adjacencyList[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        List<Integer> order = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> inStack = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if (!visited.contains(i)) {
                if (!dfs(i, visited, inStack, adjacencyList, order)) {
                    return new int[0];  
                }
            }
        }

        Integer[] integerArray = order.toArray(new Integer[0]);

        int[] result = new int[integerArray.length];
        int j = 0;
        for (int i = integerArray.length-1; i >=0; i--) {
            result[j++] = integerArray[i];
        }

        return result;
    }

    private boolean dfs(int node, Set<Integer> visited, Set<Integer> inStack, List<Integer>[] adjacencyList, List<Integer> order) {
        visited.add(node);  
        inStack.add(node);  
        List<Integer> neighbors = adjacencyList[node];
        for (int neighbor : neighbors) {
            if (inStack.contains(neighbor)) {  
                return false;
            }
            if (!visited.contains(neighbor)) {
                if (!dfs(neighbor, visited, inStack, adjacencyList, order)) {
                    return false; 
                }
            }
        }

        inStack.remove(node);  
        order.add(node); 

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        System.out.println(Arrays.toString(sol.findOrder(numCourses, prerequisites)));  
    }
}
