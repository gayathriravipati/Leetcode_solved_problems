class Solution {
public:
    int maxOperations(vector<int>& nums, int k) {
        int c = 0;
        int l = nums.size();
        int i=0,j=l-1;
        sort(nums.begin(),nums.end());
        while(i<j){
            if(nums[i] + nums[j] == k){
                c++;
                i++;
                j--;
            }
            else if(nums[i] + nums[j] > k){
                j--;
            }
            else if(nums[i] + nums[j] < k){
                i++;
            }
        }
        return c;
    }
};