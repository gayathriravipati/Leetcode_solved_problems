class Solution {
    public String[] divideString(String s, int k, char fill) {
        int len = s.length();
        int n = len % k;
        StringBuilder sb = new StringBuilder(s);

        int remainder = len % k;
        if (remainder != 0) {
            int toFill = k - remainder;
            while (toFill-- > 0) {
                sb.append(fill);
            }
        }


        int tp = sb.length() / k;
        String[] partitionString = new String[tp];

        int idx = 0;
        for(int i=0; i<sb.length(); i=i+k){
            partitionString[idx] = sb.substring(i,i+k);
            idx++;
        }
        return partitionString;
    }
}