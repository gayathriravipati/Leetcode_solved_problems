class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
        int zc = 0;
        int l = nums.size();
        int i = 0;
        int j = 0;
        int mlen = 0;
        int len = 0;
        while (i < l) {
            if (nums[i] == 0) {
                zc++;
            }
            if (zc > k) {
                len = i - j; 
                mlen = max(len, mlen);
                while (zc > k) { 
                    if (nums[j] == 0) {
                        zc--;
                        j++;
                    }
                    else{
                        j++;
                    }
                    
                }
            }
            i++;
        }
        if (zc <= k) {
            len = i - j;
            mlen = max(len, mlen);
        }
        return mlen;
    }
};
