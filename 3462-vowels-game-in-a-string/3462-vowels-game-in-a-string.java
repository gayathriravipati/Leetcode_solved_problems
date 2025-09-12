class Solution {
    public boolean doesAliceWin(String s) {
        int vowelCnt = 0;
        for(char ch : s.toCharArray()){
            if(ch == 'a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                vowelCnt++;
            }
        }
        return vowelCnt != 0;
    }
}