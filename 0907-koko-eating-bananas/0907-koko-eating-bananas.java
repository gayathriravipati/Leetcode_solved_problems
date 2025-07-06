class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        int res = right;

        while (left <= right) {
           
            int middle = (left + right) / 2;
            int hourSpent = 0;

            for (int pile : piles) {
                hourSpent += Math.ceil((double) pile / middle);
            }

            if (hourSpent <= h) {
                res = Math.min(res, middle);
                right = middle - 1;
                
            } else {
                left = middle + 1;
            }
        }

        
        return res;
    }
}