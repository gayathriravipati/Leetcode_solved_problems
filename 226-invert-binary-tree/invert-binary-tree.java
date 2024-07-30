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
    public TreeNode invertTree(TreeNode node) {
        if(node==null){
            return null;
        }

//         TreeNode temp = root.left;
//         root.left = root.right;
//         root.right = temp;

//         invertTree(root.left);
//         invertTree(root.right);

//         return root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            TreeNode root = stack.pop();
            if(root.left!=null || root.right!=null){
                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;
            }
            if(root.left!=null){
                stack.push(root.left);
            }
            if(root.right!=null){
                stack.push(root.right);
            }
        }
        return node;
    }
}