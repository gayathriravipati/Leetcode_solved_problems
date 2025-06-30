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
    public int maxLevelSum(TreeNode root) {
        int sum = Integer.MIN_VALUE;
        int level = 0;
        int fLevel = 1;
        Queue<TreeNode> child = new LinkedList<>();
        child.add(root);

        while(!child.isEmpty()){
            int size = child.size();
            int csum = 0;
            level++;
            int cl = level + 1;
            // System.out.println(cl + " " + "level");

            while(size > 0){
                TreeNode current = child.poll();
                csum = csum + current.val;
                size--;
                // System.out.println(current.val + " " + "val");
                if(current.left != null){
                    child.add(current.left);
                }
                if(current.right != null){
                    child.add(current.right);
                }
            }

            // System.out.println(csum + " " + "sum");

            if(csum > sum){
                sum = csum;
                fLevel = level;
                // System.out.println(sum + " " + level + " " +  "updaete");
            }

            csum = 0;
        }
        return fLevel;
    }
}