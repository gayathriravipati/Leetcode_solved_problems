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
    public boolean isBalanced(TreeNode root) {
        if (root == null)  return true;
		if (Height(root) == -1)  return false;
		return true;
	}
    // Create a function to return the “height” of a current subtree using recursion...
	public int Height(TreeNode root) {
		if (root == null)  return 0;
		int leftHeight = Height(root.left);
		int rightHight = Height(root.right);
		if (leftHeight == -1 || rightHight == -1)  return -1;
        if (Math.abs(leftHeight - rightHight) > 1)  return -1;
		return Math.max(leftHeight, rightHight) + 1;
    }
}