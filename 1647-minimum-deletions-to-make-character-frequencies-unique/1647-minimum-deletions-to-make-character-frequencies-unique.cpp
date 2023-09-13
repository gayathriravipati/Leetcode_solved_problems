class Solution {
public:
    int minDeletions(string s) {
        int l = s.size();
        map<char, int> mp;
        set<int> st;
        vector<int> v;
        map<char, int>::iterator itr;
        int c = 0;

        for (int i = 0; i < l; i++) {
            mp[s[i]]++;
        }

        for (itr = mp.begin(); itr != mp.end(); itr++) {
            int t = itr->second;
            v.push_back(t);
        }

        sort(v.begin(), v.end(), greater<int>());

        for (int i = 0; i < v.size(); i++) {
            while (st.find(v[i]) != st.end() && v[i] > 0) {
                v[i]--;
                c++;
            }
            st.insert(v[i]);
        }

        return c;
    }
};
