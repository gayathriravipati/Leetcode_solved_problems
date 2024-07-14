import java.util.*;

class Solution {
    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        long totalEnergy = currentEnergy;
        int min = Integer.MAX_VALUE;
        
        for(int j = enemyEnergies.length - 1; j >= 0 ; j--){
            totalEnergy += enemyEnergies[j];
            if(enemyEnergies[j] < min){
                min = enemyEnergies[j];
            }
        }
        
        totalEnergy -= min;
        if(min > currentEnergy){
            return 0;
        }
        
        return totalEnergy / min;
    }
}
