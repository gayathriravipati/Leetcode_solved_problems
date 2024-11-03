class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> sChar = new Stack<>();
        Stack<Character> tChar = new Stack<>();
        
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) != '#'){
                sChar.push(s.charAt(i));
            }
            else{
                if(!sChar.isEmpty()){
                    sChar.pop();
                }   
            }
        }
        
        for(int i = 0; i<t.length(); i++){
            if(t.charAt(i) != '#'){
                tChar.push(t.charAt(i));
            }
            else{
                if(!tChar.isEmpty()){
                    tChar.pop();
                }
            }
        }
        
        return sChar.equals(tChar);
    }
}