class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        int ml = 0;
        int si=0;
        int ei=0;
        int nz=0;
        int l = nums.size();
        while(ei < l){
            if(nums[ei]==0){
                //cout << ei << endl;
                nz++;
            }
            while(si<l && nz==2){
                if(nums[si]==0){
                    nz--;
                }
                si++;
            }
            ml = max(ml,ei-si);
            ei++;
        }
        return ml;
    }
};