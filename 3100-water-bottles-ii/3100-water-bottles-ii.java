class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int emptyBottles = 0;
        int bottlesDrunk = 0;
        
        while(emptyBottles + numBottles >= numExchange || numBottles>0){
            if(numBottles>0){
                emptyBottles = emptyBottles  + numBottles;
                bottlesDrunk += numBottles;
                numBottles = 0;
            }
            
            if(emptyBottles >= numExchange){
                emptyBottles = emptyBottles  - numExchange;
                numBottles++;
                numExchange++;
            }
            
        }
        
        return bottlesDrunk;
    }
}