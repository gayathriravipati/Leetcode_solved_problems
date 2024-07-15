class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int len = 1;
        int totalGroups = 0;
        
        for(int i=1; i<colors.length; i++){
            if(colors[i] != colors[i-1]){
                len++;
                if(len>=k){
                    totalGroups++;
                }
            }
            else{
                len = 1;
            }
        }
        
        int a = colors[colors.length - 1];
        for(int i = 0; i < k-1; i++){
            if(colors[i] != a){
                len++;
                if(len>=k){
                    totalGroups++;
                }
            }
            else{
                len = 1;
            }
            a = colors[i];
        }
        return totalGroups;
    }
}