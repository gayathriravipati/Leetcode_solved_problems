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
    private boolean validateleft(TreeNode root){
        return root != null && root.left == null && root.right == null;
    }
    
    public int sumOfLeftLeaves(TreeNode root) {
        Stack<TreeNode>st = new Stack<>();
        int t = 0;
        st.push(root);
        while(!st.empty()){
            TreeNode node = st.pop();
            if(node.left!=null &&validateleft(node.left)){
                    t += node.left.val;
            }
            
             if(node.left!=null){
                st.push(node.left);
             }
             
             if(node.right!=null){
                st.push(node.right);
             }
        }
        return t;
    }
}
