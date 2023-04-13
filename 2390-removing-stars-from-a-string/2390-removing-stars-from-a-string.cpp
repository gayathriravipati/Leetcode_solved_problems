class Solution {
public:
    string removeStars(string s) {
        int l = s.length();
        stack<char>st;
        for(int i=0;i<l;i++){
            if(s[i] =='*'){
                st.pop();
            }
            else{
                st.push(s[i]);
            }
        }
        string fs = "";
        while(!st.empty()){
            fs.push_back(st.top());
            st.pop();
        }
        reverse(fs.begin(),fs.end());
        return fs;
    }
};