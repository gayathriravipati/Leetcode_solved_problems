class Solution {
    public int numTrees(int n) {
       if (n <= 1) {
            return 1;
        }

        int result = 0;
        // Recursive calculation
        for (int i = 0; i < n; i++) {
            result += numTrees(i) * numTrees(n - 1 - i);
        }

        return result;
    
    }
}