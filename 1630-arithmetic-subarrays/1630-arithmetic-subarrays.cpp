class Solution {
public:
    vector<bool> checkArithmeticSubarrays(vector<int>& nums, vector<int>& l, vector<int>& r) {
        vector<bool>res;
        for(int i=0; i<l.size();i++){
            int a  = l[i];
            int b = r[i];
            vector<int>temp;
            
            for(int j=a;j<=b;j++){
                temp.push_back(nums[j]);
            }
            sort(temp.begin(),temp.end());
            
            int d = temp[1] - temp[0];
            int f = 0;
            
            for(int k = 1;k < temp.size(); ++k){
                if(temp[k] - temp[k-1] != d){
                    f=1;
                    break;
                }
            }
            if(f==1){
                res.push_back(false);
            }
            else{
                res.push_back(true);
            }
            temp.clear();
        }
        return res;
    }
};