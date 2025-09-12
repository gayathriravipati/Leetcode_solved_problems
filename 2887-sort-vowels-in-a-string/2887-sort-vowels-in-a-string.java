class Solution {

    private boolean isVowel(Character ch){
        if(ch == 'A' || ch == 'E' || ch == 'I'|| ch == 'O'|| ch == 'U'|| 
        ch == 'a'|| ch == 'e'|| ch == 'i'|| ch == 'o'|| ch == 'u'){
            return true;
        }
        return false;
    }

    public String sortVowels(String s) {
        int[] charMap = new int[1000];

        for(char ch : s.toCharArray()){
            if(isVowel(ch)){
                charMap[ch - 'A']++;
            }
        }

        String vowelList = "AEIOUaeiou";
        int j = 0;

        StringBuilder res = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(isVowel(ch)){
                while(charMap[vowelList.charAt(j) - 'A'] == 0){
                    j++;
                }
                res.append(vowelList.charAt(j));
                charMap[vowelList.charAt(j) - 'A']--;
            }
            else{
                res.append(ch);
            }
        }
            return res.toString();
    }
}