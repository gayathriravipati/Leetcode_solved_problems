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
    int[] inorder;
    int[] postorder;
    int postOrderidx;
    Map<Integer, Integer> inorderMap = new HashMap<>();
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        postOrderidx = (postorder.length) - 1;
        TreeNode root = constructTree(0, postOrderidx);
        
        return root;
    }
    
    private TreeNode constructTree(int left, int right){
        if(left > right){
            return null;
        }
        
        int rootValue = postorder[postOrderidx--];
        TreeNode root = new TreeNode(rootValue);
        
        root.right = constructTree(inorderMap.get(rootValue) + 1 , right);
        root.left = constructTree(left, inorderMap.get(rootValue) - 1);
        
        return root;
        
    }
}