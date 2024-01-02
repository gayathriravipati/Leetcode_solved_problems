class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(s.begin(),s.end());
        int c = 0;
        for(int i=0;i<g.size();i++){
            int t = g[i];
            //cout << t << "t" << endl;
            for(int j=0;j<s.size();j++){
                if(s[j] > 0 && s[j] >= t){
                    //cout << s[j] << "s[j]" << endl;
                    c++;
                    s[j] = -1;
                    break;
                }
            }
        }
        return c;
    }
};