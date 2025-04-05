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
 //learnt from editorial and techdose
class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).getKey();
    }

    public Pair<TreeNode, Integer> dfs(TreeNode root){
        if(root == null){
            return new Pair<>(null, 0);
        }

        Pair<TreeNode, Integer> leftPair = dfs(root.left);
        Pair<TreeNode, Integer> rightPair = dfs(root.right);

        if(leftPair.getValue() > rightPair.getValue()){
            return new Pair<>(leftPair.getKey(), leftPair.getValue() + 1);
        }

        else if(rightPair.getValue() > leftPair.getValue()){
            return new Pair<>(rightPair.getKey(), rightPair.getValue() + 1);
        }

        else{
            return new Pair<>(root, leftPair.getValue() + 1);
        }
    }
}