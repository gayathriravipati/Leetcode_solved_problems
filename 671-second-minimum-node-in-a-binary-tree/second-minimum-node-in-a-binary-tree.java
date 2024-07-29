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
    List<Integer> res = new ArrayList<>();
    public int findSecondMinimumValue(TreeNode root) {
        inorder(root);
        // for(int i=0; i<res.size(); i++){
        //     System.out.println(res.get(i));
        // }
        Collections.sort(res);
        int minv = res.get(0);
        for(int i=1; i<res.size(); i++){
            if(res.get(i) > minv){
                minv = res.get(i);
                break;
            }
        }
        
        if(minv!=res.get(0)){
            return minv;
        }
        return -1;
    }
    
    public void inorder(TreeNode root){
        if(root == null){
            return;
        }
        
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }
}