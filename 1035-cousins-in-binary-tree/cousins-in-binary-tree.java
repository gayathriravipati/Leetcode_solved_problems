class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            boolean foundX = false;
            boolean foundY = false;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (node.left != null && node.right != null) {
                    if ((node.left.val == x && node.right.val == y) || 
                        (node.left.val == y && node.right.val == x)) {
                        return false; 
                    }
                }

                if (node.val == x) foundX = true;
                if (node.val == y) foundY = true;

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            if (foundX && foundY) return true;

            if (foundX || foundY) return false;
        }

        return false;
    }
}
