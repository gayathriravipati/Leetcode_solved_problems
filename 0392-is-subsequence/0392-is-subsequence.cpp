class Solution {
public:
    bool isSubsequence(string s, string t) {
        int i = 0,j=0;
        int sl = s.size();
        int tl = t.size();
        while(j<tl){
            if(i==sl){
                return true;
            }
            if(t[j]==s[i]){
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        if(i==sl){
                return true;
        }
        else{
            return false;
        }
    }
};