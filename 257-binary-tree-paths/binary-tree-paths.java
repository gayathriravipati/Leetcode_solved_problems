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
    List<String> listOfPaths = new ArrayList<>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        if (root != null) {
            findPaths(root, new StringBuilder());
        }
        return listOfPaths;
    }
    
    private void findPaths(TreeNode root, StringBuilder res) {
        if (root != null) {
            int length = res.length();
            if (length > 0) {
                res.append("->");
            }
            res.append(root.val);
            
            if (root.left == null && root.right == null) {
                listOfPaths.add(res.toString());
            } else {
                if (root.left != null) {
                    findPaths(root.left, new StringBuilder(res));
                }
                if (root.right != null) {
                    findPaths(root.right, new StringBuilder(res));
                }
            }
        }
    }
}