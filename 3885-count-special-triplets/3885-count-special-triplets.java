class Solution {
    public int specialTriplets(int[] nums) {
        int MOD = 1000000007;
        Map<Integer, Integer> right = new HashMap<>(), left = new HashMap<>();

        for(int n : nums){
            right.put(n, right.getOrDefault(n,0)+1);
        }

        int ans = 0;

        for(int n : nums){
            right.put(n, right.get(n)-1);
            int cr = right.getOrDefault(n * 2, 0);
            int cl = left.getOrDefault(n * 2, 0);
            ans = (ans + (cr * cl)) % MOD;
            left.put(n, left.getOrDefault(n,0) + 1);
        }
        return ans;
    }
}