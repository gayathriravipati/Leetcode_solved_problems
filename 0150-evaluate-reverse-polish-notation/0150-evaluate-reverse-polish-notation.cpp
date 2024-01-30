class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        int l = tokens.size();
        stack<int> st;
        for (int i = 0; i < l; i++) {
            if (tokens[i] != "+" && tokens[i] != "-" && tokens[i] != "*" && tokens[i] != "/") {
                st.push(stoi(tokens[i])); 
            } else {
                int b = st.top();
                st.pop();
                int a = st.top();
                st.pop();
                int r;
                if (tokens[i] == "+") {
                    r = a + b;
                } else if (tokens[i] == "-") {
                    r = a - b;
                } else if (tokens[i] == "*") {
                    r = a * b;
                } else if (tokens[i] == "/") {
                    r = a / b;
                }
                st.push(r);
            }
        }
        int result = st.top();
        st.pop();
        return result;
    }
};