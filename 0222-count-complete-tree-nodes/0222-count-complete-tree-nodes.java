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
    public int findleftheight(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1 + findleftheight(root.left);
    }
    
    public int findrightheight(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1 + findrightheight(root.right);
    }
    
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = findleftheight(root);
        int rh = findrightheight(root);
        
        if(lh==rh){
            return (int)Math.pow(2,lh)-1;
        }
        
        return 1+countNodes(root.left) + countNodes(root.right);
        
        // st.push(root);
        // int c = 0;
        // while(!st.isEmpty()){
        //     c++;
        //     TreeNode node = st.peek();
        //     st.pop();
        //     if(node.left!=null){
        //         st.push(node.left);
        //     }
        //     if(node.right!=null){
        //         st.push(node.right);
        //     }
        // }
        // return c;
    }
}