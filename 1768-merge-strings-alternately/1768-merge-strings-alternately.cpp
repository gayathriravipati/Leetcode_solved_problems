class Solution {
public:
    string mergeAlternately(string word1, string word2) {
        int l1 = word1.size();
        int l2 = word2.size();
        string fs = "";
        int i,j=0;
        while((i<=l1-1) && (j<=l2-1)){
            fs = fs + word1[i] + word2[j];
            i++;
            j++;
        }
        while(i<=l1-1){
                fs = fs + word1[i];
                i++;
        }
        while(j<=l2-1){
                fs = fs + word2[j];
                cout << fs << endl;
                j++;
        }
        return fs;
    }
};