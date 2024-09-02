class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        
        while(k > 0){
            for(int i = 0; i<chalk.length; i++){
                if(k >= chalk[i]){
                    k -= chalk[i];
                }
                else{
                    return i;
                }
            }
        }
        
        return 0;
    }
}