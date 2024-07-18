class Solution {
    public boolean checkValidString(String s) {
        int totalOpen = 0;
        int totalClose = 0;
        for(int i = 0; i< s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '*'){
                totalOpen++;
            }
            else{
                totalOpen--;
            }
            if(totalOpen < 0){
                return false;
            }
        }
        
        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) == ')' || s.charAt(i) == '*'){
                totalClose++;
            }
            else{
                totalClose--;
            }
            if(totalClose < 0){
                return false;
            }
        }
        
        return true;
    }
}