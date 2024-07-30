class Solution {
    public int minimumDeletions(String s) {
        Stack<Character> charStack = new Stack<>();
        int totalDel = 0;
        
        for(int i=0; i<s.length(); i++){
            if(!charStack.isEmpty() && charStack.peek() == 'b' && s.charAt(i) == 'a'){
                charStack.pop();
                totalDel++;
            }
            else{
                charStack.push(s.charAt(i));
            }
        }
        return totalDel;
    }
}