class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        int l = strs.size();
        map<string,vector<string>>mp;
        for(int i=0;i<l;i++){
            string s = strs[i];
            sort(s.begin(),s.end());
            if(mp.find(s) != mp.end()){
                mp[s].push_back(strs[i]);
            }
            else{
                mp[s] = {strs[i]};
            }
        }
        vector<vector<string>>res;
        map<string,vector<string>>::iterator itr;
        for(itr = mp.begin(); itr != mp.end(); itr++){
            res.push_back(itr->second);
        }
        return res;
    }
};