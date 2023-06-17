class Solution {
public:
    bool increasingTriplet(vector<int>& nums) {
        int l = nums.size();
        if(l<3){
            return false;
        }
        int fo = INT_MAX;
        int so = INT_MAX;
        
        for(int i=0;i<l;i++){
            if(nums[i] > so){
                return true;
            }
            else if(nums[i] > fo && nums[i] < so){
                so = nums[i];
            }
            else if(nums[i] < fo){
                fo = nums[i];
            }
        }
        return false;
    }
};