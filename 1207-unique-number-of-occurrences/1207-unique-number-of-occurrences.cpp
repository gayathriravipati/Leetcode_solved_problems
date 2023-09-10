class Solution {
public:
    bool uniqueOccurrences(vector<int>& arr) {
        map<int,int>mp;
        for(int i=0;i<arr.size();i++){
            mp[arr[i]]++;
        }
        set<int>s;
        map<int,int>::iterator itr;
        for(itr = mp.begin(); itr!=mp.end(); itr++){
            int a = itr->second;
            if(s.find(a)==s.end()){
                s.insert(a);
            }
            else{
                return false;
            }
        }
        return true;
    }
};