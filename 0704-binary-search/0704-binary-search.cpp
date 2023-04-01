class Solution {
public:
    int search(vector<int>& nums, int target) {
        int l = nums.size();
        int m = l / 2;
        if(nums[m] == target){
            return m;
        }
        else if(nums[m] > target){
            for(int i=0;i<m;i++){
                if(nums[i] == target){
                return i;
            }
            }
            return -1;
        }
        else{
            for(int i=m+1;i<l;i++){
                if(nums[i] == target){
                return i;
            }
            }
            return -1;
        }
        return -1;
    }
};