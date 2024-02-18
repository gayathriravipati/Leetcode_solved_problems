class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        vector<int>pn;
        vector<int>nn;
        for(int i=0;i<nums.size();i++){
            if(nums[i]>0){
                pn.push_back(nums[i]);
            }
            else{
                nn.push_back(nums[i]);
            }
        }
        vector<int>res;
        int l = pn.size();
        for(int i=0;i<l;i++){
            res.push_back(pn[i]);
            res.push_back(nn[i]);
        }
        return res;
    }
};