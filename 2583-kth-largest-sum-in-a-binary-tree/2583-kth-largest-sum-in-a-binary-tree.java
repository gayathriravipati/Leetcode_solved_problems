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
    public long kthLargestLevelSum(TreeNode root, int k) {
        //Perform BFS
        //Compute sum at each level
        //Push that sum to heap
        Queue<TreeNode> levels = new LinkedList<>();
        levels.add(root);
        
        PriorityQueue<Long> levelSum = new PriorityQueue<>();
        
        while(!levels.isEmpty()){
            int eachLevel = levels.size();
            long sum = 0;
            while(eachLevel > 0){
                TreeNode node = levels.poll();
                sum += node.val;
                if(node.left!= null){
                    levels.add(node.left);
                }
                if(node.right!= null){
                    levels.add(node.right);
                }
                eachLevel--;
            }
            levelSum.offer(sum);
            
            if(levelSum.size() > k){
                levelSum.poll();
            }
        }
        
        if(levelSum.size() < k){
            return -1;
        }
        
        return levelSum.poll();
        
    }
}

