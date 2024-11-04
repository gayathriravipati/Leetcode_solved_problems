class Solution {
    public int countSubstrings(String s) {
        if(s.length() == 1){
            return 1;
        }
        
        int totalPalin = 0;
        
        for(int i=0; i<s.length(); i++){
            totalPalin += countpalin(s, i, i);
            // System.out.println(totalPalin);
        }
        
        for(int i=0; i<s.length(); i++){
            totalPalin += countpalin(s, i, i+1);
        }
        
        return totalPalin;
    }
    
    public int countpalin(String s, int start, int end){
        int palin = 0;
        
        while(start >= 0 && end < s.length()){
            if(s.charAt(start) == s.charAt(end)){
                palin++;
                // System.out.println(start + " " + end + " " + palin);
                start--;
                end++;
            }
            else{
                break;
            }
        }
        
        return palin;
    }
    
}