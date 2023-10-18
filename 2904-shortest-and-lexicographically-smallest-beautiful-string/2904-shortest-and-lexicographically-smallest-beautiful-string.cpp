class Solution {
public:
    string shortestBeautifulSubstring(string s, int k) {
        int l = s.size();
        int left=0,right=0;
        vector<string>res;
        int si = -1;
        int tz = 0;
        int sl = INT_MAX;
        while(right<l){
            if(s[right]=='1'){
                tz++;
            }
            while(tz==k){
                if(right-left+1 <= sl){
                    if(right-left+1 < sl){
                        res.clear();
                    }
                    sl = right-left+1;
                    si=left;
                    res.push_back(s.substr(si,sl));
                }
                if(s[left]=='1'){
                    tz--;
                }
                left++;
            }
            right++;
        }
        if(sl == -1){
            return "";
        }
        sort(res.begin(),res.end());
        for(int i=0;i<res.size();i++){
            if(res[i].length()==sl){
                return res[i];
            }
        }
        return "";
    }
};