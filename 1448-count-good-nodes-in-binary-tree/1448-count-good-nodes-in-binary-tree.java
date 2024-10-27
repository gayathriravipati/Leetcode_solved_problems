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
        if(root.left == null && root.right==null){
            return 1;
        }
        
        Queue<Pair<TreeNode, Integer>> queuePair = new LinkedList<>();
        queuePair.add(new Pair<>(root, root.val));
        int goodNodes = 1;
        
        while(!queuePair.isEmpty()){
            var top = queuePair.poll();
             root = top.getKey();
            int maximum = top.getValue();
            
            if(root.left != null){
                if(root.left.val >= maximum){
                    queuePair.add(new Pair<>(root.left, root.left.val));
                    goodNodes++;
                }
                else{
                    queuePair.add(new Pair<>(root.left, maximum));
                }
            }
            
            if(root.right != null){
                if(root.right.val >= maximum){
                    queuePair.add(new Pair<>(root.right, root.right.val));
                    goodNodes++;
                }
                else{
                    queuePair.add(new Pair<>(root.right, maximum));
                }
            }
        }
        return goodNodes;
    }
}