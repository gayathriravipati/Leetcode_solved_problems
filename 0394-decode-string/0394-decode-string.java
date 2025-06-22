class Solution {
    public String decodeString(String s) {
        //Among all the approaches, in editorial I am implementing the first - Single Stack approach.

        // 1. Let's push all the char's until we get ]
        // 2. Once ] build the string until [ is found
        // 3. Once [ then build num until digit is found
        // 4. Now push the string from reverse - num times
        // 5. Repeat this for every ] bracket.

        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int len = s.length();

        for(int i=0; i<len; i++){

            if(s.charAt(i) != ']'){
                st.push(s.charAt(i));
            }

            else{
                //Build string until '[' is found
                while(st.peek() != '['){
                    sb.append(st.pop());
                }

                st.pop();

                //Build k until its a digit
                StringBuilder sb1 = new StringBuilder();
                while (!st.isEmpty() && isDigit(st.peek())) {
                    sb1.append(st.pop());
                }
                int k = Integer.parseInt(sb1.reverse().toString());


                //let's push to stack k times sb from reverse
                while(k > 0){
                    for(int j = sb.length()-1; j>=0; j--){
                        st.push(sb.charAt(j));
                    }
                    k--;
                }
                sb = new StringBuilder();
            }
        }

        char[] result = new char[st.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = st.pop();
        }
        return new String(result);

    }

    public boolean isDigit(char ch){
        if(ch >= '0' && ch <= '9'){
            return true;
        }
        return false;
    }
}