class Solution {
    public int minimumLevels(int[] nums) {
        int l = nums.length;
        int[] bob = new int[l];
        int[] dan = new int[l];

        int cb = 0;
        int cd = 0;
        for(int i=0;i<l;i++){
            if(nums[i]==0){
                cd--;
            }
            else{
                cd++;
            }
            dan[i] = cd;

            if(nums[l-i-1]==0){
                cb--;
            }
            else{
                cb++;
            }
            bob[l-i-1] = cb;
        }
        
//         for(int i=0;i<l;i++){
//             System.out.println(bob[i]);   
//         }
        
//         System.out.println();
        
//         for(int i=0;i<l;i++){
//             System.out.println(dan[i]);   
//         }
        
        int i = 0;
        while(i<l-1){
            if(dan[i] > bob[i+1]){
                return i+1;
            }
            i++;
        }
        return -1;
    }
}