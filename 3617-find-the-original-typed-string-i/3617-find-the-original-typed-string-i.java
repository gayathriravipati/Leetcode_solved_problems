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
                if(cnt > 1){
                    possibleCount = possibleCount + (cnt - 1);
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


// //Best solution, see how simple the code can be
// class Solution {

//     public int possibleStringCount(String word) {
//         int n = word.length(), ans = 1;
//         for (int i = 1; i < n; ++i) {
//             if (word.charAt(i - 1) == word.charAt(i)) {
//                 ++ans;
//             }
//         }
//         return ans;
//     }
// }