class Solution {
public:
    int removeDuplicates(std::vector<int>& nums) {
        int j=1,c=1;
        int l = nums.size();
        
        for(int i=1;i<l;i++){
            if(nums[i-1]==nums[i]){
                c++;
            }
            else{
                c=1;
            }
            
            if(c<=2){
                nums[j++] = nums[i];
            }
        }
        
        return j;
    }
};