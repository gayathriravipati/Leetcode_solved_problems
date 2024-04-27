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
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> ancestors = new HashSet<>();
        stack.push(root);
        parent.put(root,null);
        
        while(!parent.containsKey(p) || !parent.containsKey(q)){
            TreeNode node = stack.pop();
            if(node.left!=null){
                stack.push(node.left);
                parent.put(node.left, node);
            }
            if(node.right!=null){
                stack.push(node.right);
                parent.put(node.right, node);
            }
        }
        
        while(p!=null){
            ancestors.add(p);
            p = parent.get(p);
        }
        
        while(!ancestors.contains(q)){
            q = parent.get(q);
        }
        return q;
    }
}