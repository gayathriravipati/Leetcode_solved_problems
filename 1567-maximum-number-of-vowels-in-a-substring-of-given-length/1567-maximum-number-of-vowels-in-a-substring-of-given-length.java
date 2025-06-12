class Solution {
    public int maxVowels(String s, int k) {
        int i = 0;
        int len = s.length() - 1;
        int vowelCnt = 0;
        int maxCnt = 0;

        while(i < k){
            if(isVowel(s.charAt(i))){
                vowelCnt++;
            }
            i++;
        }

        int idx = 0;
        maxCnt = vowelCnt;

        while(i <= len){
            if(isVowel(s.charAt(i))){
                vowelCnt++;
            }

            if(isVowel(s.charAt(idx))){
                vowelCnt--;
            }
            idx++;
            i++;
            maxCnt = Math.max(maxCnt, vowelCnt);
        }
        return maxCnt;
    }

    private boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        return false;
    }
}