class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] sneakyNumbers = new int[2];
        Set<Integer> uniqueNums = new HashSet<>();
        int idx = 0;
        
        for(int num : nums){
            if(uniqueNums.contains(num)){
                sneakyNumbers[idx] = num;
                idx++;
                if(idx == 2){
                    return sneakyNumbers;
                }
            }
            else{
                uniqueNums.add(num);
            }   
        }
        return new int[2];
    }
}