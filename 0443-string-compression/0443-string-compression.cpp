class Solution {
public:
    int compress(vector<char>& chars) {
        int l = chars.size();
        if(l==0){
            return 0;
        }
        char c = chars[0];
        int co = 1;
        string s;
        for(int i=1;i<l;i++){
            if(chars[i]==c){
                co++;
            }
            else{
                s.push_back(c);
                cout << c << " " << "h" << endl;
                if(co>1){
                    string ss = to_string(co);
                    s = s + ss;
                }
                c = chars[i];
                co = 1;
            }
        }
        s.push_back(c);
        if(co>1){
            string ss = to_string(co);
            s = s + ss;
        }
        
        
        for(int i=0;i<s.size();i++){
            chars[i] = s[i];
        }
        return s.size();
    }
};