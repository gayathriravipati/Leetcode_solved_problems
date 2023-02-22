class Solution {
public:
    int countConsistentStrings(string allowed, vector<string>& words) {
        int a = allowed.size();
        set<char>s;
        for(int i=0;i<a;i++){
            s.insert(allowed[i]);
        }
        
        int l = words.size();
        int c = 0;
        for(int i=0;i<l;i++){
            int w = words[i].size();
            int f = 0;
            for(int j=0;j<w;j++){
                if(s.find(words[i][j])==s.end()){
                    f = 1;
                    break;
                }
            }
            if(f==0){
                c = c + 1;
            }
        }
        return c;
    }
};