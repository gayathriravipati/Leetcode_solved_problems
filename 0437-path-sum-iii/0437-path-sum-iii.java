class Solution {
    int cnt = 0;
    int target;

    public int pathSum(TreeNode root, int targetSum) {
        this.target = targetSum;
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1); // Initialize for paths that start at root
        dfs(root, 0L, map);
        return cnt;
    }

    private void dfs(TreeNode node, long sum, HashMap<Long, Integer> map) {
        if (node == null) return;

        sum += node.val;

        cnt += map.getOrDefault(sum - target, 0);

        map.put(sum, map.getOrDefault(sum, 0) + 1);

        dfs(node.left, sum, map);
        dfs(node.right, sum, map);

        // Backtrack: remove current prefix sum
        map.put(sum, map.get(sum) - 1);
    }
}
