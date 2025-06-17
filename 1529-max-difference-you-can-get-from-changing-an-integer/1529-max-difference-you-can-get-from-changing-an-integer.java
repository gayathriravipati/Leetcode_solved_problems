class Solution {
    public int maxDiff(int num) {
        String str = Integer.toString(num);
        StringBuilder minNum = new StringBuilder(str);
        StringBuilder maxNum = new StringBuilder(str);

        //for max-num I want to replace left-most with 9 if it's not 9;

        char toReplace = ' ';
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) != '9'){
                toReplace = str.charAt(i);
                break;
            }
        }

        //Form max-num
        for(int i=0; i<maxNum.length(); i++){
            if(maxNum.charAt(i) == toReplace){
                maxNum.setCharAt(i, '9');
            }
        }

        //Find min-digit;
        toReplace = minNum.charAt(0);
        char replace = '1';

        if(toReplace == '1'){
            for(int i=1; i<minNum.length(); i++){
                if(minNum.charAt(i) != '1' && minNum.charAt(i) != '0'){
                    toReplace = minNum.charAt(i);
                    replace = '0';
                    break;
                }
            }
        }

        //Form min-Num
        for(int i=0; i<minNum.length(); i++){
            if(minNum.charAt(i) == toReplace){
                minNum.setCharAt(i, replace);
            }
        }

        int firstNum = Integer.parseInt(minNum.toString());
        int secondNum = Integer.parseInt(maxNum.toString());
        
        return secondNum - firstNum;
    }
}