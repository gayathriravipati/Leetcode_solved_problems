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
    int totalSum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        
        Stack<TreeNode> leftstack = new Stack<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        
        while(!stack.isEmpty() || !leftstack.isEmpty()){
            
            while(!stack.isEmpty()){
                
                TreeNode node = stack.pop();
                
                if(node.left!=null){
                    leftstack.add(node.left);
                }
                if(node.right!=null){
                    stack.add(node.right);
                }
            }
            
            while(!leftstack.isEmpty()){
                
                TreeNode node = leftstack.pop();
                
                if(node.left!=null){
                    leftstack.add(node.left);
                }
                if(node.right!=null){
                    stack.add(node.right);
                }
                if(node.left == null && node.right == null){
                    totalSum += node.val;
                }
            }
        }
        return totalSum;
    }
}