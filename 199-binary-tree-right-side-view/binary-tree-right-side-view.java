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
    List<Integer> rightView = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return rightView;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            int qs = q.size();
            for(int i = 0; i< qs; i++){
                TreeNode node = q.poll();
                if(i == qs - 1){
                    rightView.add(node.val);
                }
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
        }
        return rightView;
    }
}