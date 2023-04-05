class Solution {
public:
    int findTheLongestBalancedSubstring(string s) {
        int l = s.length();
        string t = "01";
        int mv=0;
        while(t.length()<=l){
            if(s.find(t) <s.size()){
                mv = t.length();
                cout << t << " " << mv << endl;
            }   
        t = "0" + t + "1";
        }
     return mv; 
    }
};