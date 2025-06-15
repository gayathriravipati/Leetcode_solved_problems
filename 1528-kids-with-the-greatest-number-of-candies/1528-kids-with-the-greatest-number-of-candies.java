class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> status = new ArrayList<>();

        int maxNum = Integer.MIN_VALUE;

        for(int c : candies){
            if(c > maxNum){
                maxNum = c;
            }
        }

        for(int c : candies){
            if(c + extraCandies >= maxNum){
                status.add(true);
            }
            else{
                status.add(false);
            }
        }
        return status;
    }
}