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
    int cnt = 0;
    Map<Long, Integer> mp = new HashMap<>();
    int k;
    
    public int pathSum(TreeNode root, int targetSum) {
        this.k = targetSum;
        dfs(root, 0L);
        return cnt;
    }
    
    public void dfs(TreeNode node, long sum){
        if(node == null){
            return;
        }
        
        sum += node.val;
        
        if(sum == k){
            cnt++;
        }
        
        cnt += mp.getOrDefault(sum - k, 0);
        
        mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        
        dfs(node.left, sum);
        dfs(node.right, sum);
        
        mp.put(sum, mp.get(sum) - 1);
    }
}