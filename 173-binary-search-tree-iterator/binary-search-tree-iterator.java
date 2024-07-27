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
class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();  
        pushAllLeft(root);
    }

    private void pushAllLeft(TreeNode root) {
        while (root != null) {
            stack.push(root);  
            root = root.left;
        }
    }

    public int next() {
        TreeNode node = stack.pop();  
        pushAllLeft(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();  
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */