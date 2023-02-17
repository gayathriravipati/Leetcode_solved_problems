class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int i,b,c=0;
        vector<int> o;
        for(i=0;i<nums.size();i++){
            //if(target>nums[i]){
                b = target - nums[i];
            //}
            
            for(int j=i+1;j<nums.size();j++){
                if(b==nums[j]){
                    o.push_back(i);
                    o.push_back(j);
                    return o;
                 }
            }
        }
        return o;
    }
    
};