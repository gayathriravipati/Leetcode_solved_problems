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

public class Pair{
    TreeNode node;
    int val;

    Pair(TreeNode node, int val){
        this.node = node;
        this.val = val;
    }
}

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {

        if(root==null){
            return false;
        }

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, root.val));

        while(!st.isEmpty()){
            Pair current = st.pop();
            TreeNode node = current.node;
            int value = current.val;
            // System.out.println("cv" + node.val + " " +  value);

            //If the current node is a leaf node
            if(node.left == null && node.right == null){
                if(value == targetSum){
                    return true;
                }
            }

            if(node.left != null){
                int t = value + node.left.val;
                // System.out.println("tolEFT" + " "  + node.left.val + " " + t);
                st.push(new Pair(node.left, t));
            }

            if(node.right != null){
                int t = value + node.right.val;
                // System.out.println("toR8" + " "  + node.right.val + " " + t);
                st.push(new Pair(node.right, t));
            }
        }

        return false;
    }
}