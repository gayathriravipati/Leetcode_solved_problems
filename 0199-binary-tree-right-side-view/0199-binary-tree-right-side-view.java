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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        Deque<TreeNode> currentNodes = new ArrayDeque<>();

        if(root==null){
            return new ArrayList<>();
        }
        
        currentNodes.add(root);

        while(!currentNodes.isEmpty()){
            int size = currentNodes.size();
            rightView.add(currentNodes.getLast().val);
            for(int i=0; i<size; i++){
                TreeNode current = currentNodes.poll();
                if(current.left != null){
                    currentNodes.add(current.left);
                }
                if(current.right != null){
                    currentNodes.add(current.right);
                }
            }
        }

        return rightView;
    }
}