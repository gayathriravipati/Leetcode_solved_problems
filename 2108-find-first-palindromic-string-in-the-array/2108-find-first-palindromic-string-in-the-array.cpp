class Solution {
public:
    bool check_palindrome(string s){
        int sl = s.size()-1;
        int si = 0;
        while(si<sl){
            if(s[si]!=s[sl]){
                return false;
            }
            si++;
            sl--;
        }
        return true;
    }
    string firstPalindrome(vector<string>& words) {
        int l = words.size();
        for(int i=0;i<l;i++){
            string s = words[i];
            if(check_palindrome(s)){
                return words[i];
            }
        }
        return "";
    }
};