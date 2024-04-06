class Solution {
    public String minRemoveToMakeValid(String s) {
        int open = 0;
        StringBuilder sb = new StringBuilder();
        
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')'){
                if(open > 0){
                    open--;
                    sb.append(s.charAt(i));
                    // System.out.println(sb + "" + "1");
                }
            }
            else if(s.charAt(i)=='('){
                open++;
                sb.append(s.charAt(i));
                // System.out.println(sb + "" + "2");
            }
            else{
                sb.append(s.charAt(i));
                // System.out.println(sb + "" + "3");
            }
        }
        
        // System.out.println(open);
        
        int i = sb.length() - 1; 
        while (open > 0 && i >= 0) { 
            if (sb.charAt(i) == '(') {
                open--;
                sb.deleteCharAt(i);
            }
            i--; 
        }

        
        
        return sb.toString();
    }
    
}