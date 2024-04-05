class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));
        
        for(int i = 1;i<s.length();i++){
            if(!st.isEmpty()){
                Character ch = st.peek();
                if(Math.abs(ch - s.charAt(i)) == 32){
                    System.out.println("here");
                    st.pop();
                }
                else{
                    st.push(s.charAt(i));
                    System.out.println(s.charAt(i));
                }
            }
             else{
                st.push(s.charAt(i));
            }
            
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i< st.size();i++) {
            sb.append(st.get(i));
        }
        
        String result = sb.toString();
        // System.out.println(result);
        return result;
    }
}