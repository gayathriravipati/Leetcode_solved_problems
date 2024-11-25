class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        
        for(String s : tokens){
            
            // System.out.println(s + "str");
            
            if(!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")){
                int val = Integer.valueOf(s);
                // System.out.println(val + "val");
                st.push(val);
            }
            
            else{
                int num2 = st.pop();
                int nums1 = st.pop();
                int res = 0;
                
                if(s.equals("+")){
                    res = nums1 + num2;
                }
                else if(s.equals("-")){
                    res = nums1 - num2;
                }
                else if(s.equals("*")){
                    res = nums1 * num2;
                }
                else if(s.equals("/")){
                    res = nums1 / num2;
                }
                
                // System.out.println(res + "res");
                st.push(res);
            }
        }
        
        return st.peek();
    }
}