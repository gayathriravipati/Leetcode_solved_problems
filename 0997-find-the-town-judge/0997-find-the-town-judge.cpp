class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        int l = trust.size();
        map<int,int>mp;
        
        if(trust.size()==0 and n==1){
            return 1;
        }
        
        for(int i=0;i<l;i++){
            mp[trust[i][1]]++;
        }
        
        
        int mt= 0;
        int max = 0;
        for(auto it = mp.begin();it!=mp.end();it++){
            if(it->second > max){
                max = it->second;
                mt = it->first;
            }
        }
        
        // cout << mt << "maxvotes" << endl;
        
        if(max != n-1){
            return -1;
        }
        
       
        for(int i=0;i<l;i++){
            if(trust[i][0] == mt){
                return -1;
            }
        }
        
        return mt;
    }
};