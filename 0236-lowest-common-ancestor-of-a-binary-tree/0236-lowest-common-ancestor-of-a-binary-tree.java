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
        HashMap<TreeNode, TreeNode> mp = new HashMap<>();
        mp.put(root, null);

        Stack<TreeNode> st = new Stack<>();
        st.add(root);

        while(!st.isEmpty()){
            TreeNode top = st.pop();
            if(top.left != null){
                mp.put(top.left , top);
                st.add(top.left);
            }
            if(top.right != null){
                mp.put(top.right, top);
                st.add(top.right);
            }
        }

        Set<TreeNode> uniqueNode = new HashSet<>();
        
        while(mp.containsKey(p)){
            uniqueNode.add(p);
            p = mp.get(p);
        }

        while(!uniqueNode.contains(q)){
            q = mp.get(q);
        }

        return q;

    }
}