class Solution {
    public String reverseVowels(String s) {
        int len = s.length() - 1;
        int i = 0;

        char[] chars = s.toCharArray();

        while (i < len) {
            while (i < len && !isVowel(chars[i])) {
                i++;
            }

            while (i < len && !isVowel(chars[len])) {
                len--;
            }

            char temp = chars[i];
            chars[i] = chars[len];
            chars[len] = temp;

            i++;
            len--;
        }

        return new String(chars);
    }

    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}
