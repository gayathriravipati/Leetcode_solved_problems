class Solution {
    // public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
    //     Arrays.sort(fruits);
    //     int basketIdx = -1;

    //     for(int i=0; i<fruits.length; i++){
    //         int basketVal = findMatch(fruits[i], baskets, basketIdx);
    //         if(basketVal == -1){
    //             return fruits.length - i;
    //         }
    //         basketIdx = basketVal;
    //     }
    //     return 0;
    // }

    // public int findMatch(int fruit, int[] baskets, int basketIdx){
    //     for(int i = basketIdx+1; i<baskets.length; i++){
    //         if(baskets[i] >= fruit){
    //             return i;
    //         }
    //     }
    //     return -1;
    // }

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int unPlaced = 0;
        for(int i=0; i<fruits.length; i++){
            if(!isAllocated(fruits[i], baskets)){
                unPlaced++;
            }
        }
        return unPlaced;
    }

    public boolean isAllocated(int fruit, int[] baskets){
        for(int i = 0; i<baskets.length; i++){
            if(baskets[i] >= fruit){
                baskets[i] = -1;
                return true;
            }
        }
        return false;
    }
}