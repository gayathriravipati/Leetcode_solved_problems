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
    public int goodNodes(TreeNode root) {
        return goodCnt(root, root.val);
    }

    public int goodCnt(TreeNode root, int maxVal){
        if(root==null)
        {
            return 0;
        }

        int cnt = 0;
        if(root.val >= maxVal){
            cnt = 1;
            maxVal = root.val;
        }

        cnt += goodCnt(root.left, maxVal);
        cnt += goodCnt(root.right, maxVal);

        return cnt;
    }
}