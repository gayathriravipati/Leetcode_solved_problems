class Solution {
    //optimised way of writing code
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().getAsInt();

        // int max = candies.stream().max().getAsInt();
        List<Boolean> result = new ArrayList<>(candies.length);

        for (int c : candies) {
            result.add(c + extraCandies >= max);
        }

        return result;
    }
}
