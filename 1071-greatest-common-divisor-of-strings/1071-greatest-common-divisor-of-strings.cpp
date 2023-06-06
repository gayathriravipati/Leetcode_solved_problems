class Solution {
public:
    string gcdOfStrings(string str1, string str2) {
        int l2 = str2.size();
        int l1 = str1.size();
        // string s;
        // set<char>st;
        // for(int i=0;i<l2;i++){
        //     if(st.find(str2[i])==st.end()){
        //         s = s + str2[i];
        //         st.insert(str2[i]);
        //         ///cout << str2[i] << "1" << endl;
        //     }
        //     else{
        //         break;
        //     }
        // }
        if(str1+str2 == str2+str1){
            return str1.substr(0,gcd(str1.length(),str2.length()));
        }
        else{
            return "";
        }
    }
};