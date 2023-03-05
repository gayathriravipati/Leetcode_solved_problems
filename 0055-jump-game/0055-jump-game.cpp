class Solution {
public:
    bool canJump(vector<int>& nums) {
        int l = nums.size();
        //vector<int>temp(l,-1);
        int lp = nums.size()-1;
        for(int i=l-1;i>=0;i--){
            if(nums[i]+i>=lp){
                lp = i;
            }
        }
        return lp==0;
    }
};