class Solution {
    public int calculate(String s) {
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int sign = 1;
        int res = 0;
        
        for(int i = 0; i < len; i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num * 10 +  (ch - '0');
            }
            else if(ch == '+'){
                res += sign * num;
                num = 0;
                sign = 1;
            }
            else if(ch == '-'){
                res += sign * num;
                num = 0;
                sign = -1;
            }
            else if(ch == '('){
                stack.push(res);
                stack.push(sign);
                sign = 1;   
                res = 0;
           }
            else if(ch == ')'){
                res += sign * num; 
                num = 0;
                res *= stack.pop();    
                res += stack.pop();   
            }
        }
        
        if(num != 0){
            res += sign * num;
        } 
        
    return res;
}
}