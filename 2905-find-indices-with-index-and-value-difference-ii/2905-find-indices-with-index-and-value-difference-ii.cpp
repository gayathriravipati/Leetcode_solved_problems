class Solution {
public:
    vector<int> findIndices(vector<int>& nums, int indexDifference, int valueDifference) {
        vector<int>res(2,-1);
        int l = nums.size();
        int min_idx = 0;
        int max_idx = 0;
        for(int i=indexDifference;i<l;i++){
            if(nums[i-indexDifference] < nums[min_idx]){
                min_idx = i-indexDifference;
            }
            if(nums[i-indexDifference] > nums[max_idx]){
                max_idx = i-indexDifference;
            }
            if(abs(nums[i]-nums[min_idx]) >= valueDifference){
                res[0] = min_idx;
                res[1] = i;
                return res;
            }
            if(abs(nums[i]-nums[max_idx]) >= valueDifference){
                res[0] = max_idx;
                res[1] = i;
                return res;
            }
        }
        return res;
    }
};