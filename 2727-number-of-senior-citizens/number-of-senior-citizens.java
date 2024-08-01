class Solution {
    public int countSeniors(String[] details) {
        int greaterSixty = 0;
        for(int i = 0; i < details.length; i++){
            int num = 0;
            String s = details[i];
            char numericChar1 = s.charAt(11);
            int intValue1 = numericChar1 - '0';
            num = num * 10 + intValue1;
            char numericChar2 = s.charAt(12);
            int intValue2 = numericChar2 - '0';
            num = num * 10 + intValue2;
            if(num > 60){
                greaterSixty++;
            }
        }
        return greaterSixty;
    }
}
