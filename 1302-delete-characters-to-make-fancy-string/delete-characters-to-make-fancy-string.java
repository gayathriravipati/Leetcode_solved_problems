class Solution {
    public String makeFancyString(String s) {
        StringBuilder res = new StringBuilder();
        
        int cnt = 1;
        char ch = s.charAt(0);
        res.append(ch);
        
        
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) != ch){
                ch = s.charAt(i);
                cnt = 1;
                res.append(ch);
            }
            else{
                if(cnt < 2){
                    res.append(ch);
                    cnt++;
                }
            }
        }
        
        return res.toString();
    }
}