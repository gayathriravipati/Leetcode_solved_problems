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
        List<Integer> rightList = new ArrayList<>();
        Deque<TreeNode> currentLevel = new ArrayDeque<>();
        Deque<Integer> nextLevel = new ArrayDeque<>();
        
        if(root==null){
            return rightList;
        }
        
        currentLevel.add(root);
        while(!currentLevel.isEmpty()){
            int size = currentLevel.size();
            for(int i=0; i<size; i++){
                TreeNode node = currentLevel.poll();
                if(i==size-1){
                    rightList.add(node.val);
                }
                if(node.left!=null){
                    currentLevel.add(node.left);
                }
                if(node.right!=null){
                    currentLevel.add(node.right);
                }
            }
        }
        return rightList;
    }
}