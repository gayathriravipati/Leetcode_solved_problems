class Solution {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int[] free = new int[len];
        int[] hold = new int[len];

        free[0] = 0;
        hold[0] = -prices[0];

        for(int i=1; i<len; i++){
            free[i] = Math.max(free[i-1], hold[i-1] + prices[i] - fee);
            hold[i] = Math.max(hold[i-1], free[i-1] - prices[i]);
        }
        return free[len-1];
    }
}

//To save space-complexity


// class Solution {
//     public int maxProfit(int[] prices, int fee) {
//         int n = prices.length;
//         int free = 0, hold = -prices[0];
        
//         for (int i = 1; i < n; i++) {
//             int tmp = hold;
//             hold = Math.max(hold, free - prices[i]);
//             free = Math.max(free, tmp + prices[i] - fee);
//         }
        
//         return free;
//     }
// }