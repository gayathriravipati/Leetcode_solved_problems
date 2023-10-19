class Solution {
public:
    bool backspaceCompare(string s, string t) {
        stack<char>ss;
        stack<char>st;
        for(int i=0;i<s.length();i++){
            if(s[i]!='#'){
                ss.push(s[i]);
            }
            else{
                if(!ss.empty()){
                    ss.pop();
                } 
            }
        }
        for(int i=0;i<t.length();i++){
            if(t[i]!='#'){
                st.push(t[i]);
            }
            else{
                if(!st.empty()){
                    st.pop();
                }   
            }
        }
        if(ss==st){
            return true;
        }
        else{
            return false;
        }   
    }
};