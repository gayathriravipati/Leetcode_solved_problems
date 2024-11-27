class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        
        for(int[] booking : bookings){
            int start = booking[0];
            int end = booking[1];
            int value = booking[2];
            
            res[start-1] += value;
            if(end != n){
                res[end] -= value;
            }
        }
        
        //prefix sum
        int curr = 0;
        for(int i = 0; i<n; i++){
            res[i] += curr;
            curr = res[i];
        }
        return res;
        
    }
}