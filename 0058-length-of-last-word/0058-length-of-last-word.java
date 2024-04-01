class Solution {
    public int lengthOfLastWord(String s) {
        int len = s.length();
        int j = len-1;
        int c = 0;
        String ts = "";
       
        int i = 0;
        while(s.charAt(i) == ' ' && i < len){
            i++;
        }
        
        while(i < len){
            if(s.charAt(i) == ' '){
                if(i+1 < len && s.charAt(i+1) != ' '){
                    ts = "";
                }
            }
            else{
                ts = ts + s.charAt(i);
            }
            i++;
        }
        
        return ts.length();
    }
}