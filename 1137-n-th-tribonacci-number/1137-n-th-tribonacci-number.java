class Solution {
    public int tribonacci(int n) {
        if(n==0){
            return 0;
        }
        if(n==1 || n==2){
            return 1;
        }
        
        int v=0;
        int a=0,b=1,c=1;
        for(int i=3;i<=n;i++){
            v = a + b + c;
            // System.out.println(i + " " + a + " " + b + " " + c + " " + v);
            a = b;
            b = c;
            c = v;
            
        }
        return v;
    }
}