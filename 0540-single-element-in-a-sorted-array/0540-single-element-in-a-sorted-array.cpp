class Solution {
public:
    int singleNonDuplicate(vector<int>& nums) {
        int l = 0;
        int h = nums.size()-1;
        while(l<h){
            int m = l + (h-l) / 2;
            int he = (h - m) % 2;
            if(nums[m-1]==nums[m]){
                if(he==0){
                    h = m - 2;
                }
                else{
                    l = m + 1;
                }
            }
            else if(nums[m+ 1]==nums[m]){
                if(he==0){
                    l = m + 2;
                }
                else{
                    h = m - 1;
                }
            }
            else{
                return nums[m];
            }
        }
        return nums[l];
    }
};