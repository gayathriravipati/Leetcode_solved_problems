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
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            int size = stack.size();
            for(int i=0; i<size; i++){
                TreeNode node = stack.removeFirst();
                if(node.left!=null){
                    parentMap.put(node.left, node);
                    stack.addLast(node.left);
                }
                if(node.right!=null){
                    parentMap.put(node.right, node);
                    stack.addLast(node.right);
                }
            }
        }
        
        Set<TreeNode> pathNodes = new HashSet<>();
        parentMap.put(root,null);
        
        while(parentMap.containsKey(p)){
                pathNodes.add(p);
                p = parentMap.get(p);
        }
        
         while(parentMap.containsKey(q)){
             if(pathNodes.contains(q)){
                 return q;
             }
                q = parentMap.get(q);
        }
        
        return null;
    }
}