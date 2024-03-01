class Solution {
public:
    string maximumOddBinaryNumber(string s) {
        int l = s.size();
        int tz = 0;
        int to = 0;
        for(int i=0;i<l;i++){
            if(s[i]=='0'){
                tz++;
            }
            else{
                to++;
            }
        }
        string rs = "";
        while(to>1){
            rs = rs + "1";
            to--;
        }
        while(tz>0){
            rs = rs + "0";
            tz--;
        }
        
        rs = rs + "1";
        return rs;
        
    }
};