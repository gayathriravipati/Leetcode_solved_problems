class Solution {
    public String answerString(String word, int numFriends) {
        //logic => The maximum length of the substring we have have is word.length()-numFriends+1
        int wordLength = word.length();
        int targetLength = word.length()-numFriends+1;

        String res = "";

        if(numFriends == 1){
            return word;
        }

        for(int i = 0; i<wordLength; i++){
            String temp;
            if(i + targetLength <  wordLength){
                temp = word.substring(i, i + targetLength);
            }
            else{
                temp = word.substring(i);
            }

            if(temp.compareTo(res) > 0){
                res = temp;
            }
        }
        return res;
    }
}