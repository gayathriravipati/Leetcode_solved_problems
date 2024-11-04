class Solution {
    public String compressedString(String word) {
        
        char tchar = word.charAt(0);
        int char_c = 1;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i< word.length(); i++){
            if(word.charAt(i) == tchar){
                char_c++;
                if(char_c > 9){
                    char charValue = (char) (9 + '0');
                    sb.append(charValue);
                    sb.append(tchar);
                    char_c = 1;
                }
            }
            else{
                char charValue = (char) (char_c + '0');
                sb.append(charValue);
                sb.append(tchar);
                char_c = 1;
                tchar = word.charAt(i);
            }
        }
        char charValue = (char) (char_c + '0');
        sb.append(charValue);
        sb.append(tchar);
        return sb.toString();   
    }
}