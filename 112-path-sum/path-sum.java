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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        
        Queue<Pair<TreeNode, Integer>> nodeQueue = new LinkedList<>();
        nodeQueue.add(new Pair<>(root, root.val));
        
        while(!nodeQueue.isEmpty()){
            var top = nodeQueue.poll();
            TreeNode node = top.getKey();
            int sum = top.getValue();
            // System.out.println(node.val + " " + sum);
            
            if(node.left != null){
                int val = sum + node.left.val;
                nodeQueue.add(new Pair<>(node.left,val));
            }
            
            if(node.right != null){
                int val = sum + node.right.val;
                nodeQueue.add(new Pair<>(node.right,val));
            }
            
            if(node.left == null && node.right == null && sum == targetSum){
                return true;
            }
        }
        
        return false;
    }
}