class Solution {
public:
    vector<int> largestDivisibleSubset(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<int> res;
        int l = nums.size();
        if (l == 0) return res;
        vector<int> dp(l, 1); 
        int max_index = 0; 
        int max_size = 1; 
        for (int i = 1; i < l; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = max(dp[i], dp[j] + 1);
                    if (dp[i] > max_size) {
                        max_size = dp[i];
                        max_index = i;
                    }
                }
            }
        }
        int curr_size = max_size; 
        int curr_num = nums[max_index]; 
        for (int i = max_index; i >= 0; i--) {
            if (curr_size == dp[i] && curr_num % nums[i] == 0) {
                res.push_back(nums[i]);
                curr_size--;
                curr_num = nums[i];
            }
        }
        return res;
    }
};
