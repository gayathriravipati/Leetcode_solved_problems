class Solution {
public:
    string frequencySort(string s) {
        int l = s.size();
        map<char,int> m;
        map<char,int>::iterator itr;
        for(auto i:s){
             m[i]++;
        }
        
        vector<pair<int,char>> v;
        for(auto i:m){
            v.push_back(make_pair(i.second,i.first));
         }
        
        sort(v.begin(), v.end());
        reverse(v.begin(),v.end());
        
        string fs;    
        for(auto i:v)
        {
            while(i.first>0){
                fs.push_back(i.second);
                i.first--;
            }
        }
        return fs;
    }
};