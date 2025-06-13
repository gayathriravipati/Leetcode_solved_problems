class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> resultList = new ArrayList<>();

        for(int i=0; i<arr.length-1; i++){
            if(arr[i+1] - arr[i] < minDiff){
                resultList.clear();
                minDiff = arr[i+1] - arr[i];
                resultList.add(Arrays.asList(arr[i], arr[i+1]));
            }
            else if(arr[i+1] - arr[i] ==  minDiff){
                resultList.add(Arrays.asList(arr[i], arr[i+1]));
            }
        }
        return resultList;
    }
}