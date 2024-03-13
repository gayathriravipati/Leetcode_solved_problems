class Solution {
    public int pivotInteger(int n) {
        int ns = (n*(n+1)) / 2;
        if(n==1){
            return 1;
        }
        while(n>0){
            int ts = (n*(n+1)) / 2;
            int dv = ns - ts + n;
            System.out.println(n + " " + ts + " " + dv);
            if(ts==dv){
                return n;
            }
            n--;
        }
        return -1;
    }
}