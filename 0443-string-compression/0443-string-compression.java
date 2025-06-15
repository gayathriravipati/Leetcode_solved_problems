class Solution {
    public int compress(char[] chars) {
        int idx = 0;
        int len = chars.length;

        if(len == 1){
            return 1;
        }

        int j=1;
        int cnt = 1;
        char ch = chars[0];

        //let j iterate => when ever there is difference lets modify the characters.
        while(j < len){
            if(chars[j] == ch){
                cnt++;
            }
            else{
                if(cnt == 1){
                    chars[idx] = ch;
                    idx++;
                }
                else{
                    chars[idx++] = ch;
                    String countStr = String.valueOf(cnt);
                    for (int i = 0; i < countStr.length(); i++) {
                        chars[idx++] = countStr.charAt(i);
                    }
                }
                cnt = 1;
                ch = chars[j];
            }
            j++;
        }

        if(cnt == 1){
            chars[idx] = ch;
            idx++;
        }
        else{
            chars[idx++] = ch;
            String countStr = String.valueOf(cnt);
            for (int i = 0; i < countStr.length(); i++) {
                chars[idx++] = countStr.charAt(i);
            }
        }
        return idx;
    }
}