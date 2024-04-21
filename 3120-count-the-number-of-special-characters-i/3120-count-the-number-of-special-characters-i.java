//lets get the ascii value of each char
//if it is A - Z 65 - 90
// a- z 97 - 122

class Solution {
    public int numberOfSpecialChars(String word) {
       Set<Character> st = new HashSet<>();
        Set<Character> res = new HashSet<>();
        
        for(int i=0;i<word.length();i++){
            int v = (int) word.charAt(i);
            
            if(v>=65 && v<=90){
               v = v + 32;
               char ch = (char) v;
               if(st.contains(ch)){
                   if(!res.contains(ch)){
                       res.add(ch);
                       System.out.println(res.add(ch));
                   }
                   res.add(ch);
               }
               else{
                   st.add(word.charAt(i));
               }
            }
            
            else{
                v = v - 32;
                char ch = (char) v;
               if(st.contains(ch)){
                   if(!res.contains(word.charAt(i))){
                       res.add(word.charAt(i));
                       System.out.println(res.add(word.charAt(i)));
                   }
               }
               else{
                   st.add(word.charAt(i));
               }
            }  
        }
        return res.size();        
    }
}