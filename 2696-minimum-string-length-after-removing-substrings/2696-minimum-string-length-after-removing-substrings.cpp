class Solution {
public:
    int minLength(string s) {
        stack<char>st;
        int l = s.size();
        for(int i=0;i<l;i++){
            if(s[i] == 'B'){
                if(!st.empty() && st.top()=='A'){
                    cout << "h" << endl;
                    st.pop();
                }
                else{
                    st.push(s[i]);
                }
            }
            else if(s[i] == 'D'){
                if(!st.empty() && st.top()=='C'){
                    cout << "th" << endl;
                    st.pop();
                }
                else{
                    st.push(s[i]);
                }
            }
           else{
               cout << s[i] << endl;
               st.push(s[i]);
           }
        }
        return st.size();
    }
};