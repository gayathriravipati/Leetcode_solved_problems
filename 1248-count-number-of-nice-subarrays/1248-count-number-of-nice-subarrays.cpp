class Solution {
public:
    int numberOfSubarrays(vector<int>& nums, int k) {
        int l = nums.size();
        for(int i=0;i<l;i++){
            if(nums[i]%2 != 0){
                nums[i] = 1;
            }
            else{
                nums[i] = 0;
            }
        }
        map<int,int>mp;
        map<int,int>::iterator it;
        int ps=0,ans=0;
        for(int i=0;i<l;i++){
            ps = ps + nums[i];
            if(ps == k){
                ans++;
            }
            if(mp.find(ps-k)!=mp.end()){
                ans = ans + mp[ps-k];
            }
            mp[ps]++;
        }
        return ans;
    }
};