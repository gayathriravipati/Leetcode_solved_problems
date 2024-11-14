class Solution {
    private static final int INT_BITS = 32;

    private static class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

    private void insert(TrieNode root, int num) {
        TrieNode node = root;
        for (int i = INT_BITS - 1; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[bit] == null) {
                node.children[bit] = new TrieNode();
            }
            node = node.children[bit];
        }
    }

    private int findMaxXOR(TrieNode root, int num) {
        TrieNode node = root;
        int maxXOR = 0;
        for (int i = INT_BITS - 1; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int toggleBit = 1 - bit; // Opposite bit
            // Try to go down the path with toggleBit if available, otherwise use bit
            if (node.children[toggleBit] != null) {
                maxXOR |= (1 << i); // Set the i-th bit in maxXOR to 1
                node = node.children[toggleBit];
            } else {
                node = node.children[bit];
            }
        }
        return maxXOR;
    }

    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        int maxResult = 0;

        // Insert each number into the Trie
        for (int num : nums) {
            insert(root, num);
        }

        // For each number, compute the maximum XOR with any number in the Trie
        for (int num : nums) {
            maxResult = Math.max(maxResult, findMaxXOR(root, num));
        }

        return maxResult;
    }

//     public static void main(String[] args) {
//         Solution solution = new Solution();

//         int[] nums1 = {3, 10, 5, 25, 2, 8};
//         System.out.println("Output: " + solution.findMaximumXOR(nums1)); // Expected: 28

//         int[] nums2 = {14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70};
//         System.out.println("Output: " + solution.findMaximumXOR(nums2)); // Expected: 127
//     }
}
