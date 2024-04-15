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
    public int sumNumbers(TreeNode root) {
        Queue<Pair<TreeNode,Integer>>q = new LinkedList<>();
        q.add(new Pair<>(root, root.val));
        int t = 0;
        
        while(!q.isEmpty()){
            int s = q.size();
            // System.out.println(s);
            for(int i=0;i<s;i++){
                Pair<TreeNode, Integer> current = q.poll();
                TreeNode currentNode = current.getKey(); 
                Integer currentVal = current.getValue();
                
                if(currentNode.left==null && currentNode.right==null){
                    t += currentVal;
                }
                
                 if(currentNode.left!=null){
                    int val = currentNode.left.val + currentVal * 10;
                    q.add(new Pair<>(currentNode.left, val));
                }
                
                 if(currentNode.right!=null){
                    int val = currentNode.right.val + currentVal * 10;
                    q.add(new Pair<>(currentNode.right, val));
                }
            }
        }
        return t;
    }
}