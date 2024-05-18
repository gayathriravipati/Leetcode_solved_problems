class Solution {
    public String reversePrefix(String word, char ch) {
        Deque<Character> stack = new ArrayDeque<>();
        int l = word.length();
        int i = 0;
        int f = 0;
        while(i < l){
            if(word.charAt(i)!=ch){
                stack.push(word.charAt(i));
            }
            else{
                f = 1;
                break;
            }
            i++;
        }
        if(f==0){
            return word;
        }
        StringBuilder sb = new StringBuilder();
        if(i<l){
            sb.append(word.charAt(i));
            i++;
        }
        
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        while(i < l){
            sb.append(word.charAt(i));
            i++;
        }
        
        return sb.toString();
    }
}