class Solution {
    public String reverseWords(String s) {
        Deque<String> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(ch == ' '){
                if(sb.length() > 0){
                    dq.push(sb.toString());
                    sb.setLength(0);
                }
            }
            else{
                sb.append(ch);
            }
        }

        if(sb.length() > 0){
            dq.push(sb.toString());
            sb.setLength(0);
        }

        StringBuilder res = new StringBuilder();
        while(!dq.isEmpty()){
            String str = dq.poll();
            res.append(str);
            if(!dq.isEmpty()){
                res.append(" ");
            }
        }
        return res.toString();
    }
}