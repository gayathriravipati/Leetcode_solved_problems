class Solution {
    public int possibleStringCount(String word) {
        int cnt = 1;
        char ch = word.charAt(0);
        int possibleCount = 1;

        for(int i=1; i<word.length(); i++){
            if(word.charAt(i) == ch){
                cnt++;
            }
            else{
                // System.out.println(ch + " " + cnt);
                if(cnt > 1){
                    possibleCount = possibleCount + (cnt - 1);
                    //  System.out.println(possibleCount);
                }
                ch = word.charAt(i);
                cnt = 1;
            }
        }

        if(cnt > 1){
            possibleCount = possibleCount + (cnt - 1);
        }

        return possibleCount;
    }
}