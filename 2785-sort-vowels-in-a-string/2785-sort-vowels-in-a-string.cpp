class Solution {
public:
    string sortVowels(string s) {
        set<char>vst = {'a','e','i','o','u','A','E','I','O','U'};
        vector<int>vi;
        vector<char>vc;
        
        for(int i=0;i<s.size();i++){
            if(vst.find(s[i])!=vst.end()){
                vi.push_back(i);
                vc.push_back(s[i]);
            }
        }
        
        sort(vc.begin(),vc.end());
        
        for(int i=0;i<vi.size();i++){
            int a = vi[i];
            s[a] = vc[i];
        }
        return s;
    }
};