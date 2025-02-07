class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for(int i=0; i<numbers.length; i++){
            int diff = target - numbers[i];
            if(diff >= numbers[i]){
                for(int j = i+1; j<numbers.length; j++){
                    if(numbers[j] == diff){
                        res[0] = i + 1;
                        res[1] = j + 1;
                        return res;
                    }
                }
            }
        }
        return res;
    }
}