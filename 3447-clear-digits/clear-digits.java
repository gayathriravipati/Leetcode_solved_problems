class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch >= 'a' && ch <= 'z'){
                sb.append(ch);
            }
            else{
                sb.delete(sb.length() - 1, sb.length());
            }
        }

        return sb.toString();

    }
}