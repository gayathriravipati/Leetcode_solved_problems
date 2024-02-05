class Solution {
public:
    int firstUniqChar(string s) {
        int l = s.size();
        map<char,int>mp;
        for(int i=0;i<l;i++){
            mp[s[i]]++;
        }
        
        for(int i=0;i<l;i++){
            if(mp[s[i]]==1){
                return i;
            }
        }
        
        return -1;
    }
};