/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countPairs(TreeNode root, int distance) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        Set<TreeNode> leafNodes = new HashSet<>();
        int ans = 0;
        traverseTree(root, null, graph, leafNodes);
        
        for(TreeNode leaf : leafNodes){
            Queue<TreeNode> bfsQueue = new LinkedList<>();
            Set<TreeNode> seen = new HashSet<>();
            bfsQueue.add(leaf);
            seen.add(leaf);
            
            for(int i=0; i<=distance; i++){
                int size = bfsQueue.size();
                for(int j=0; j<size; j++){
                    TreeNode node = bfsQueue.poll();
                    if(leafNodes.contains(node) && leaf!=node){
                        ans++;
                    }
                    
                if (graph.containsKey(node)){
                    for(TreeNode neighbor : graph.get(node)){
                        if(!seen.contains(neighbor)){
                            seen.add(neighbor);
                            bfsQueue.add(neighbor);
                        }
                    }
                }
            }
            }
        }
        return ans / 2;
    }
    
    public void traverseTree(TreeNode currNode, TreeNode prevNode, Map<TreeNode,List<TreeNode>> graph, Set<TreeNode> leafNodes){
        
        if(currNode == null){
            return;
        }
        
        if(currNode.left==null && currNode.right==null){
            leafNodes.add(currNode);
        }
        
        if(prevNode!=null && currNode != null){
            graph.computeIfAbsent(prevNode, k-> new ArrayList<>()).add(currNode);
            graph.computeIfAbsent(currNode, k-> new ArrayList<>()).add(prevNode);
        }
        traverseTree(currNode.left, currNode,graph, leafNodes);
        traverseTree(currNode.right, currNode,graph, leafNodes);
    }
}