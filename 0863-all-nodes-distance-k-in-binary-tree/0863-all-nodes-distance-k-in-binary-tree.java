/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<Integer, List<Integer>> parentToChildren = new HashMap<>();
    HashMap<Integer, Integer> childrenToParent = new HashMap<>();
    List<Integer> kDistPoints = new ArrayList<>();
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // Step 1: Generate parent-child relationships
        generatePointers(root);

        // Step 2: Use a queue for BFS
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(target.val);
        visited.add(target.val);

        int dist = 0;
        
        // Step 3: Perform BFS up to distance k
        while (!queue.isEmpty() && dist <= k) {
            int size = queue.size();
            if (dist == k) {
                // All the nodes at the current distance are the result
                kDistPoints.addAll(queue);
                break;
            }

            // Process nodes level by level
            for (int i = 0; i < size; i++) {
                int nodeVal = queue.poll();

                // Check children
                if (parentToChildren.containsKey(nodeVal)) {
                    for (int child : parentToChildren.get(nodeVal)) {
                        if (!visited.contains(child)) {
                            queue.add(child);
                            visited.add(child);
                        }
                    }
                }

                // Check parent
                if (childrenToParent.containsKey(nodeVal)) {
                    int parentVal = childrenToParent.get(nodeVal);
                    if (!visited.contains(parentVal)) {
                        queue.add(parentVal);
                        visited.add(parentVal);
                    }
                }
            }

            dist++;
        }

        return kDistPoints;
    }
    
    public void generatePointers(TreeNode root){
        if (root == null) {
            return;
        }
        Stack<TreeNode> st = new Stack<>();
        st.add(root);
        
        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            if (node.left != null) {
                childrenToParent.put(node.left.val, node.val);
                parentToChildren.computeIfAbsent(node.val, value -> new ArrayList<>()).add(node.left.val);
                st.add(node.left);
            }
            
            if (node.right != null) {
                childrenToParent.put(node.right.val, node.val);
                parentToChildren.computeIfAbsent(node.val, value -> new ArrayList<>()).add(node.right.val);
                st.add(node.right);
            }
        }
    }
}
