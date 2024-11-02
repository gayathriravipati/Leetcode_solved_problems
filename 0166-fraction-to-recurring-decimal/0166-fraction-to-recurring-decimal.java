class Solution {
    public String fractionToDecimal(int num, int den) {
        //if num == 0
        StringBuilder res = new StringBuilder();
        
        if(num == 0){
            res.append('0');
            return res.toString();
        }
        
        //den == 0; - avoided
    
        //If either of them -ve then let us append '-'
        if(num < 0 ^ den < 0){
            res.append('-');
        }
        
        // converting a num from -ve to +ve => overflow long
        long dividend = Math.abs((long) num);
        long divisor = Math.abs((long) den);
        res.append(String.valueOf(dividend / divisor));
        long rem = dividend % divisor;
        if(rem == 0){
            return res.toString();
        }
        res.append('.');
        
        Map<Long, Integer> remP = new HashMap<>();
        
        while(rem != 0){
            if(remP.containsKey(rem)){
                res.insert(remP.get(rem), "(");
                res.append(")");
                return res.toString();
            }
            else{
                remP.put(rem, res.length());
                rem = rem * 10;
                res.append(String.valueOf(rem / divisor));
                rem = rem % divisor;
            }
        }
        return res.toString();
    }
}