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
        int leftHt = 0;
        int rightHt = 0;

        if(root == null){
            return 0;
        }

        if(root.left != null){
            leftHt = findHt(root.left);
        }
        if(root.right != null){
            rightHt = findHt(root.right);
        }
        return 1 + Math.max(leftHt, rightHt);
    }

    public int findHt(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(findHt(root.left), findHt(root.right));
    }
}