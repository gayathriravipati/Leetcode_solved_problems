class Solution {
    public int[] decrypt(int[] code, int k) {
        int res[] = new int[code.length];
        int len = code.length;
        
        // if(k==0){
        //     for(int i =0; i < code.length; i++){
        //         code[i] = 0;
        //     }
        //     return res;
        // }
        
         if(k > 0){
            for(int i = 0; i < code.length; i++){
                int idx = i;
                int cnt = k;
                int sum = 0;
                while(cnt > 0){
                    idx++;
                    sum += code[idx % len];
                    cnt--;
                }
                res[i] = sum;
            }
        }
        
        else if (k < 0){
            for(int i = 0; i < code.length; i++){
                int idx = i - 1;
                int sum = 0;
                int cnt = Math.abs(k);
                while(cnt > 0){
                    while(cnt > 0 && idx >= 0){
                        sum += code[idx];
                        idx--;
                        cnt--;
                    }
                     idx = len - 1;
                    while(cnt > 0 && idx >= 0){
                        sum += code[idx];
                        idx--;
                        cnt--;
                    }
                }
                res[i] = sum;
            }
        }
        
        return res;
    }
}