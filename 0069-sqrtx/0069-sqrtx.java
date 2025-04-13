class Solution {
    public int mySqrt(int x) {
        if(x < 2){
            return x;
        }
        int left = 2;
        int right = x / 2;

        while(left <= right){
            int pvt = left + (right - left) / 2;
            long res = (long) pvt * pvt;

            if(res > x){
                right = pvt - 1;
            }
            else if(res < x){
                left = pvt + 1;
            }
            else{
                return pvt;
            }
        }

        return right;
    }
}