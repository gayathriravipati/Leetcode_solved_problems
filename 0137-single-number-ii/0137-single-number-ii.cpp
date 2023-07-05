class Solution {
public:
    int singleNumber(std::vector<int>& nums) {
        int l = nums.size();
        map<int,int>mp;
        for(int i=0;i<l;i++){
            mp[nums[i]]++;
        }
        int r;
        map<int,int>::iterator itr;
        for(itr = mp.begin();itr!=mp.end();itr++){
            if(itr->second==1){
                r = itr->first;
                break;
            }
        }
        return r;
    }
};
