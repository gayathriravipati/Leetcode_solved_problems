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
    public int sumOfLeftLeaves(TreeNode root) {
        return processsubtree(root, false);
    }
    
    private int processsubtree(TreeNode root, boolean is_left){
        if(root==null){
            return 0;
        }
        
        if(root.left == null && root.right == null && is_left==true){
            return root.val;
        }
            
            
        return processsubtree(root.left,true) + processsubtree(root.right,false);
    }
}