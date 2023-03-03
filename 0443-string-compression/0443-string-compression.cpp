class Solution {
public:
    int compress(vector<char>& chars) {
        int l = chars.size();
        if(l==0){
            return 0;
        }
        //char c = chars[0];
        int co = 1;
        string s;
        int i,k = 0;
        for(i=1;i<l;i++){
            if(chars[i]==chars[i-1]){
                co++;
            }
            else{
                chars[k]=chars[i-1];
                cout << k << endl;
                k++;
                // s.push_back(c);
                // cout << c << " " << "h" << endl;
                if(co>1){
                    string ss = to_string(co);
                    for(int j=0;j<ss.size();j++){
                        chars[k] = ss[j];
                        cout << k << endl;
                        k++;
                    }
                   // s = s + ss;
                }
                //c = chars[i];
                co = 1;
            }
        }
        // s.push_back(c);
        // if(co>1){
        //     string ss = to_string(co);
        //     s = s + ss;
        // }
        chars[k] = chars[i-1];
        k++;
        if(co>1){
            string ss = to_string(co);
            for(int j=0;j<ss.size();j++){
                chars[k] = ss[j];
                cout << k << endl;
                k++;
            }
        }
        
        // for(int i=0;i<s.size();i++){
        //     chars[i] = s[i];
        // }
        // return s.size();
        return k;
    }
};