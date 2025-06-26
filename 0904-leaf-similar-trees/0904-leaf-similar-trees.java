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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> oneLeaves = new ArrayList<>();
        List<Integer> twoLeaves = new ArrayList<>();
        
        oneLeaves = findLeaves(root1, oneLeaves);
        twoLeaves = findLeaves(root2, twoLeaves);
        
        return oneLeaves.equals(twoLeaves);
    }

    public List<Integer> findLeaves(TreeNode root, List<Integer> leaves){
        if(root.left == null && root.right == null){
            leaves.add(root.val);
        } 
        
       if(root.left != null){
            findLeaves(root.left, leaves);
        }
        
        if(root.right != null){
            findLeaves(root.right, leaves);
        }
        return leaves;
    }
}