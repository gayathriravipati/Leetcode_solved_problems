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
    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorderHelper(root);
        return res;
    }

    private void inorderHelper(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderHelper(root.left);
        res.add(root.val);
        inorderHelper(root.right);
    }
}
