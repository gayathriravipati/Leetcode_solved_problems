class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        map<int,int>mp;
        map<int,int>::iterator itr;
        for(int i=0;i<nums.size();i++){
            mp[nums[i]]++;
        }
        vector<pair<int,int>>t;
        for(itr = mp.begin();itr!=mp.end();itr++){
            t.push_back(make_pair(itr->second,itr->first));
        }
        sort(t.begin(),t.end());
        int l = t.size();
        vector<int>res;
        int i = l-1;
        while(k>0){
            res.push_back(t[i].second);
            i--;
            k--;
        }
        // vector<int>t;
        // for(int i=0;i<k;i++){
        //     t.push_back(res[i]);
        // }
        return res;
    }
};