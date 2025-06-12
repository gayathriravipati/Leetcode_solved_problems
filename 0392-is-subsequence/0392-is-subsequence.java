class Solution {
    public boolean isSubsequence(String s, String t) {
        int sPnt = 0;

        if(t.length() < s.length()){
            return false;
        }

        if(s.length() == 0){
            return true;
        }

        for(int i=0; i<t.length(); i++){
            if(t.charAt(i) == s.charAt(sPnt)){
                sPnt++;
            }

            if(sPnt == s.length()){
                return true;
            }
        }

        return false;
    }
}