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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findsum(root);
        return maxSum;
    }
    
    private int findsum(TreeNode node){
        if(node == null){
            return 0;
        }
        
        int left_max = findsum(node.left);
        int right_max = findsum(node.right);
        
        int left_gain = Math.max(0, left_max);
        int right_gain = Math.max(0, right_max);
        
        maxSum = Math.max(maxSum, left_gain + right_gain + node.val);
        
        return Math.max( right_gain + node.val ,  left_gain + node.val);
        
    }
}