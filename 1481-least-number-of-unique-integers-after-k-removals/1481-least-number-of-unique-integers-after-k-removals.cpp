class Solution {
public:
    int findLeastNumOfUniqueInts(vector<int>& arr, int k) {
        int l = arr.size();
        map<int,int>mp;
        vector<int>res;
        
        for(int i=0;i<l;i++){
            mp[arr[i]]++;
        }
        
        for(auto i = mp.begin(); i!=mp.end(); i++){
            res.push_back(i->second);
        }
        
        sort(res.begin(),res.end());
        
        for(int i=0;i<res.size();i++){
            cout << res[i] << " ";
        }
        
        int i;
        for(i=0;i<res.size();i++){
            k = k - res[i];
            if(k < 0){
                break;
            }
        }
        
        return res.size() - i;
    }
};