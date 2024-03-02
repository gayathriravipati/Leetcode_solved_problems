class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        int l = nums.size();
        vector<int>res(l);
        int left = 0;
        int right = l-1;
        int s;
        
        for(int i=l-1;i>=0;i--){
            
            if(abs(nums[left]) > nums[right]){
                s = nums[left];
                left++;
            }
            else{
                s = nums[right];
                right--;
            }
            res[i] = s * s;
        }
        return res;
    }
};