class Solution {
public:
    int minimizeArrayValue(vector<int>& nums) {
        long long ps=nums[0];
        int res=nums[0];
        for(int i=1;i<nums.size();i++){
            //cout << i+1 << endl;
            long long  a = ceil(1.0*(ps + nums[i]) / (i+1));
            //cout << ps + nums[i] << " " <<  a << "a" << endl;
            res = max((long long)res, a);
            //cout << res << "m" << endl;
            ps = ps + nums[i];
        }
        return res;
    }
};