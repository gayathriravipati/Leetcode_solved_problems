#include <iostream>
#include <vector>
#include <map>

using namespace std;

class Solution {
public:
    int countPalindromicSubsequence(string s) {
        map<char, vector<int>> mp;
        map<char, vector<int>>::iterator it;
        int l = s.size();
        int c = 0;
        for (int i = 0; i < l; i++) {
            mp[s[i]].push_back(i);
        }
        set<char>st;
        for (it = mp.begin(); it != mp.end(); it++) {
            int tl = it->second.size();
            if (tl > 1) {
                if(it->second[tl-1] - it->second[0] > 1){
                    int a = it->second[0];
                    int b = it->second[tl-1];
                    for(int i = a+1; i<b; i++){
                        st.insert(s[i]);
                    }
                }
                c = c + st.size();
            }
             st.clear();  
        }
        
        return c;
    }
};