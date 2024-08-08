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
    int preOrderIndex = 0;
    Map<Integer, Integer> inOrderMap = new HashMap<>(); 
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i< inorder.length; i++){
            inOrderMap.put(inorder[i], i);
        }
        TreeNode node = buildTree(preorder, 0, preorder.length-1);
        return node;
    }
    
    private TreeNode buildTree(int[] preorder, int left, int right){
        if(left > right){
            return null;
        }
        
        int rootValue = preorder[preOrderIndex++];
        TreeNode root = new TreeNode(rootValue);
        
        root.left = buildTree(preorder, left, inOrderMap.get(rootValue) -1);
        root.right = buildTree(preorder, inOrderMap.get(rootValue) + 1, right);
        
        return root;
        
    }
}