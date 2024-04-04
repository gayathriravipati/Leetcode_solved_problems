class Solution {
    public int maxDepth(String s) {
        int mc = 0;
        int tc = 0;
        int tc1 = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                tc++;
            }
            else if(s.charAt(i) ==')'){
                if(mc < tc){
                    mc = tc;
                }
                tc--;
            }
        }
        return mc;
    }
}