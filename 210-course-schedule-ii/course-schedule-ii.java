import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Initialize the adjacency list
        List<Integer>[] adjacencyList = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {  // Corrected numCourses.length to numCourses
            adjacencyList[i] = new ArrayList<>();
        }

        // Build the adjacency list for the graph
        for (int i = 0; i < prerequisites.length; i++) {
            adjacencyList[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        List<Integer> order = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> inStack = new HashSet<>();

        // Perform DFS to detect cycles and find topological order
        for (int i = 0; i < numCourses; i++) {
            if (!visited.contains(i)) {
                if (!dfs(i, visited, inStack, adjacencyList, order)) {
                    return new int[0];  // Return empty array if a cycle is detected
                }
            }
        }

        // Convert the List<Integer> to Integer[]
        Integer[] integerArray = order.toArray(new Integer[0]);

        // Convert Integer[] to int[]
        int[] result = new int[integerArray.length];
        int j = 0;
        for (int i = integerArray.length-1; i >=0; i--) {
            result[j++] = integerArray[i];
        }

        return result;
    }

    private boolean dfs(int node, Set<Integer> visited, Set<Integer> inStack, List<Integer>[] adjacencyList, List<Integer> order) {
        visited.add(node);  // Mark the current node as visited
        inStack.add(node);  // Add it to the current recursion stack

        List<Integer> neighbors = adjacencyList[node];

        // Traverse all neighbors
        for (int neighbor : neighbors) {
            if (inStack.contains(neighbor)) {  // Cycle detected
                return false;
            }
            if (!visited.contains(neighbor)) {
                if (!dfs(neighbor, visited, inStack, adjacencyList, order)) {
                    return false;  // If a cycle is detected in any DFS call, return false
                }
            }
        }

        inStack.remove(node);  // Remove the node from the recursion stack
        order.add(node);  // Add the current node to the topological order

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        System.out.println(Arrays.toString(sol.findOrder(numCourses, prerequisites)));  // Expected output: []
    }
}
