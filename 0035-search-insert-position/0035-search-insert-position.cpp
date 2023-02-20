class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int l = nums.size();
        int m = l/2;
        int res;
        if(target<=nums[m]){
            for(int i=0;i<=m;i++){
                if(nums[i] == target){
                    res = i;
                    break;
                }
                else if(nums[i] > target){
                    res = i;
                    break;
                }
            }
        }
        
    else{
            for(int i=m+1;i<l;i++){
                if(nums[i] == target){
                    res = i;
                    break;
                }
                else if(nums[i] > target){
                    res = i;
                    break;
                }  
            }
    }
        return res;
    }
};