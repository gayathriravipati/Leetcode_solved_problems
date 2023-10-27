class Solution {
public:
    string longestPalindrome(string s) {
        int n=s.length();
        vector<vector<bool>> dp(n, vector<bool>(n));
        int max_len=1, st=0;
        for(int i=n-1 ; i>=0 ; i--){
            for(int j=i ; j<n ; j++){
                if(i==j){
                    dp[i][j]=1;
                }else if(j-i==1){
                    dp[i][j] = s[i]==s[j];
                }else{
                    dp[i][j] = (s[i]==s[j] && dp[i+1][j-1]);
                }
                if(dp[i][j] && max_len < j-i+1){
                    st=i;
                    max_len = j-i+1;
                }
            }
        }
        return s.substr(st, max_len);
    }
};