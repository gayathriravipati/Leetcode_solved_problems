import java.util.Arrays;
class Solution {
    public static void reverseArray(int[] array) {
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            start++;
            end--;
        }
    }
   
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        reverseArray(happiness);
        
        long sum = 0;
        int i = 0;
        int l = happiness.length;
        
        while(k>0 && i<l){
            happiness[i] = happiness[i] - i;
            if(happiness[i] > 0){
                sum = sum + happiness[i];
                i++;
                k--;
            }
            else{
                break;
            }
        }
        
        return sum;
    }
}