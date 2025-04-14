class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int totalTriplets = 0;
        int len = arr.length;

        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                if(Math.abs(arr[i] - arr[j]) <= a){
                    for(int k=j+1; k<len; k++){
                        if((Math.abs(arr[j] - arr[k]) <= b) && (Math.abs(arr[i] - arr[k]) <= c)){
                            totalTriplets++;
                        }
                    }
                }
            }
        }
        return totalTriplets;
    }
}