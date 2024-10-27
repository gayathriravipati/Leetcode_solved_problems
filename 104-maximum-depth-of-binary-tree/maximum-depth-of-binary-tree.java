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
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        int levels = 0;
        
        if(root==null){
            return 0;
        }
        
        while(!nodeQueue.isEmpty()){
            levels++;
            int levelSize = nodeQueue.size();
            while(levelSize > 0){
                TreeNode node = nodeQueue.poll();
                if(node.left != null){
                    nodeQueue.add(node.left);
                }
                
                if(node.right != null){
                    nodeQueue.add(node.right);
                }
                levelSize--;
            }
        }
        return levels;
    }
}