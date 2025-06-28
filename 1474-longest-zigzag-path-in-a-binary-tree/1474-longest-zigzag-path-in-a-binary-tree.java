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
    int pathLen = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root, true, 0);
        return pathLen;
    }

    private void dfs(TreeNode root, boolean isLeft, int steps){
        if(root==null){
            return;
        }
        pathLen  = Math.max(pathLen, steps);

        if(isLeft){
            dfs(root.left, false, steps + 1);
            dfs(root.right, true, 1);
        }
        else{
            dfs(root.left, false, 1);
            dfs(root.right, true, steps + 1);
        }
    }

}