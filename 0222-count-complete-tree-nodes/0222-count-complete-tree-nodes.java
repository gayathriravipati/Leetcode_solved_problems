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
    
    public int countNodes(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        if (root == null) {
            return 0;
        }
        st.push(root);
        int c = 0;
        while(!st.isEmpty()){
            c++;
            TreeNode node = st.peek();
            st.pop();
            if(node.left!=null){
                st.push(node.left);
            }
            if(node.right!=null){
                st.push(node.right);
            }
        }
        return c;
    }
}