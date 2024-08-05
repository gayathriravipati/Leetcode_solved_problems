class Solution {
    public String kthDistinct(String[] arr, int k) {
        //freq count
        Map<String, Integer> freqCount = new HashMap<>();
        for(int i = 0; i<arr.length; i++){
            freqCount.put(arr[i], freqCount.getOrDefault(arr[i],0) + 1);
        }
        
        int c = 0;
        for(int i = 0; i<arr.length; i++){
            int val = freqCount.get(arr[i]);
            if(val == 1){
                c++;
                if(c==k){
                    return arr[i];
                }
            }
        }
        return "";
    }
}