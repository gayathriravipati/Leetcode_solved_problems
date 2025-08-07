class Solution {
    public int totalFruit(int[] fruits) {
        int maxPicked = 0;
        Map<Integer, Integer> diffTypes = new HashMap<>();
        int left = 0;
        for(int right = 0; right < fruits.length; right++){
            diffTypes.put(fruits[right], diffTypes.getOrDefault(fruits[right], 0) + 1);

            while(diffTypes.size() > 2){
                diffTypes.put(fruits[left], diffTypes.get(fruits[left]) - 1);
                if(diffTypes.get(fruits[left]) == 0){
                    diffTypes.remove(fruits[left]);
                }
                left++;
            }
            maxPicked = Math.max(maxPicked, (right - left) + 1);
        }
        return maxPicked;
    }
}