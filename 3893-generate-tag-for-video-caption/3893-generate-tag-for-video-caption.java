class Solution {
    public String generateTag(String caption) {
        StringBuilder sb = new StringBuilder("#");
        int len = caption.length();
        int idx = 0;
        int cnt = 0;
        boolean firstWordStarted = false;

        while (idx < len && cnt < 99) {
            char current = caption.charAt(idx);

            if (isLetter(current)) {
                if (!firstWordStarted) {
                    sb.append(toLower(current));  
                    firstWordStarted = true; 
                } else if (idx > 0 && caption.charAt(idx - 1) == ' ') {
                    sb.append(toUpper(current)); 
                } else {
                    sb.append(toLower(current)); 
                }
                cnt++;
            }

            idx++;
        }

        return sb.toString();
    }

    private boolean isLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    private char toLower(char c) {
        return (c >= 'A' && c <= 'Z') ? (char)(c + 32) : c;
    }

    private char toUpper(char c) {
        return (c >= 'a' && c <= 'z') ? (char)(c - 32) : c;
    }
}
