//Learnt from Leetcode solution
class Solution {
    public int findKthNumber(int n, int k) {
        int currNum = 1;
        k--;

        while(k > 0){
            // long p1 = currNum;
            // long p2 = currNum + 1;
            int totalSteps = countSteps(n, currNum, currNum + 1);

            if(totalSteps <=  k){
                currNum++;
                k = k - totalSteps;
            }
            else{
                currNum = currNum * 10;
                k--;
            }
        }

        return currNum;

    }


        private int countSteps(int limit, long p1, long p2){
            int t = 0;
            
            while(p1 <= limit){
                t +=  Math.min(limit + 1, p2) - p1;
                p1 = p1 * 10;
                p2 = p2 * 10;
            }
            return t;
        }
}