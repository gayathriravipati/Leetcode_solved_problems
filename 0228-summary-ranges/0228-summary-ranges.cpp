class Solution {
public:
    vector<string> summaryRanges(vector<int>& nums) {
        int l = nums.size();
        vector<string> res;
        int si = 0;

        for (int i = 1; i < l; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                string s;
                if (i - si == 1) {
                    s = to_string(nums[si]);
                } else {
                    s = to_string(nums[si]) + "->" + to_string(nums[i - 1]);
                }
                res.push_back(s);
                si = i;
            }
        }

        string lastRange;
        if (si >= 0 && si < l) {
            if (l - si == 1) {
                lastRange = to_string(nums[si]);
            } else {
                lastRange = to_string(nums[si]) + "->" + to_string(nums[l - 1]);
            }
            res.push_back(lastRange);
        }
        return res;
    }
};
