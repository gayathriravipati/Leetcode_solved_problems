class Solution {
    public int tribonacci(int n) {
        int a=0, b=1, c=1;
        if(n==0){
            return 0;
        }
        else if(n==1){
            return 1;
        }
        else if(n==2){
            return 1;
        }
        int res = 0;
        for(int i=3; i<=n ; i++){
            res = a + b + c;
            a = b;
            b = c;
            c = res;
        }
        return res;
    }
}