class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> arrFrequency = new HashMap<>();
        
        for(int i=0; i<arr.length; i++){
            arrFrequency.put(arr[i], arrFrequency.getOrDefault(arr[i], 0) + 1);
        }
        
        for(int i = 0; i<target.length; i++){
            if(!arrFrequency.containsKey(target[i])){
                return false;
            }
            
            arrFrequency.put(target[i], arrFrequency.get(target[i]) - 1);
            if(arrFrequency.get(target[i]) == 0){
                arrFrequency.remove(target[i]);
            }
        }
        return true;
    }
}