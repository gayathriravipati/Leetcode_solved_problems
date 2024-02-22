class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int n = nums.size();
        int sn = n * (n + 1) / 2;
        int f = 0;
        int ts = 0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                f = 1;
            }
            ts = ts + nums[i];
        }
        
        if(f==0){
            return 0;
        }
        
        return sn - ts;
    }
};