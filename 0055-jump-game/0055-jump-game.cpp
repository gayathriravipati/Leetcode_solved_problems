class Solution {
public:
    bool canJump(vector<int>& nums) {
        int l = nums.size();
        // vector<int>v(l,0);
        // for(int i=l-1;i>=0;i--){
        //     if(nums[i]+i>=l-1){
        //         v[i] = 1;
        //     }
        //     else{
        //         for(int j = nums[i];j>=1;j--){
        //             if(v[i+j]==1){
        //                 v[i] = 1;
        //                 break;
        //             }
        //         }
        //     }
        // }
        // return v[0]==1;
        
        int lp = nums.size()-1;
        for(int i=l-1;i>=0;i--){
            if(nums[i]+i>=lp){
                lp = i;
            }
        }
        return lp==0;
    }
};