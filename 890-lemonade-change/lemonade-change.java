class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveCount = 0;
        int tenCount = 0;
        int twenCount = 0;
        int total = 0;
        
        for(int i=0; i<bills.length; i++){
            if(bills[i] == 5){
                total += bills[i];
                fiveCount++;
            }
            else if(bills[i] == 10){
                if(fiveCount > 0){
                    fiveCount--;
                    total += bills[i];
                    tenCount++;
                }
                else{
                    return false;
                }
            }
            else{
                if(fiveCount >= 1 && tenCount >= 1) {
                    fiveCount--;
                    tenCount--;
                    total += bills[i];
                    twenCount++;
                }
                else if(fiveCount >= 3){
                    fiveCount = fiveCount - 3;
                    total += bills[i];
                    twenCount++;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}