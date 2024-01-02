class Solution {
public:
    std::vector<std::vector<int>> findMatrix(std::vector<int>& nums) {
        std::map<int, int> mp;
        std::vector<std::vector<int>> vmp;

        int l = nums.size();
        for (int i = 0; i < l; i++) {
            mp[nums[i]]++;
        }

        for (const auto& pair : mp) {
            int k = pair.second;
            for (int i = 0; i < k; i++) {
                if (i >= vmp.size()) {
                    vmp.push_back({pair.first});
                } else {
                    vmp[i].push_back(pair.first);
                }
            }
        }

        return vmp;
    }
};
