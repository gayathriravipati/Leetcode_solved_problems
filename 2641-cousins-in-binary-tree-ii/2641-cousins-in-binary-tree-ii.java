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

//Learnt this from the solution to pass it in O(n);

class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        int previousLevelSum = root.val;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        
        while(!nodeQueue.isEmpty()){
            int currentLevelSum = 0;
            int nodeQueueSize = nodeQueue.size();
            
            while(nodeQueueSize > 0){
                TreeNode node = nodeQueue.poll();
                node.val = previousLevelSum - node.val;
                
                int siblingSum = 0;
                siblingSum += node.left != null ? node.left.val : 0;
                siblingSum += node.right != null ? node.right.val : 0;

                
                if(node.left != null){
                    currentLevelSum += node.left.val;
                    node.left.val = siblingSum;
                    nodeQueue.add(node.left);
                }
                
                if(node.right != null){
                    currentLevelSum += node.right.val;
                    node.right.val = siblingSum;
                    nodeQueue.add(node.right);
                }
                nodeQueueSize--;
            }
            previousLevelSum = currentLevelSum;
            
        }
        return root;
    }
}