class Solution {
public:
    int partitionString(string s) {
        int tss = 1;
        int l = s.size();
        set<char>se;
        for(int i=0;i<l;i++){
            if(se.find(s[i])!=se.end()){
                se.clear();
                cout << se.size() << "size" << endl;
                se.insert(s[i]);
                cout << s[i] << "2";
                tss++;
            }
            else{
                se.insert(s[i]);
                cout << s[i] << "1";
            }
        }
        return tss;
    }
};