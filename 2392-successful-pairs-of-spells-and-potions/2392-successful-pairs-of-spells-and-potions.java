class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] res = new int[spells.length];

        for(int i=0; i<spells.length; i++){
            res[i] = findValid(spells[i], potions, success);
        }
        return res;
    }

    public int findValid(int val, int[] potions, long target){
        int low = 0;
        int high = potions.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;  
            long res = (long) val * potions[mid];
            // System.out.println(low + " " + high + " " + mid + " " + res);
            if(res >= target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return potions.length - low;
    }
}