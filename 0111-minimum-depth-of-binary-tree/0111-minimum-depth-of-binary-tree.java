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
    public int minDepth(TreeNode root) {
        Queue<TreeNode>q = new LinkedList<>();
        int depth = 1;
        q.offer(root);
        
        if(root==null){
            return 0;
        }
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size > 0){
                TreeNode node = q.poll();
                if(node.left == null && node.right == null){
                    return depth;
                }
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
                size--;
            }
            depth++;
        }
        return depth;
    }
}