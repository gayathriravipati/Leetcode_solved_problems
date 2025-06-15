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

        //let j iterate => whenever there is difference let's modify the characters.
        while(j < len){
            if(chars[j] == ch){
                cnt++;
            }
            else{
                chars[idx++] = ch;
                if(cnt > 1){
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

        chars[idx++] = ch;
        if(cnt > 1){
            String countStr = String.valueOf(cnt);
            for (int i = 0; i < countStr.length(); i++) {
                chars[idx++] = countStr.charAt(i);
            }
        }
        return idx;
    }
}