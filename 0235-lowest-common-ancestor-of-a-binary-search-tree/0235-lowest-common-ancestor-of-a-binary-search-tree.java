/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pval = p.val;
        int qval = q.val;
        
        while(root!=null){
            int val = root.val;
            if(pval > val && qval > val){
                root = root.right;
            }
            
            else if(pval < val && qval < val){
                root = root.left;
            }
            
            else{
                return root;
            }
        
        }
        return null;
    }
}