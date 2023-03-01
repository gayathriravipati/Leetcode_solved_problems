class Solution {
public:
    vector<int> sortArray(vector<int>& nums) {
        int l = nums.size();
        map<int,int>mp;
        for(int i=0;i<l;i++){
            mp[nums[i]]++;
        }
        map<int,int>::iterator itr;
        vector<int>res;
        for(itr = mp.begin();itr!=mp.end();itr++){
            while(itr->second > 0){
                res.push_back(itr->first);
                itr->second--;
            }
        }
        return res;
    }
};