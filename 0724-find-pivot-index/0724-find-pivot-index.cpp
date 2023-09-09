class Solution {
public:
    int pivotIndex(vector<int>& nums) {
        int l = nums.size();
        vector<int> lv(l,0);
        vector<int> rv(l,0);
        lv[0] = 0;
        rv[l-1] = 0;
        for(int i=1;i<l;i++){
            lv[i] = lv[i-1] + nums[i-1];
            //cout << lv[i] << " ";
        }
        cout << endl;
        for(int j=l-2;j>=0;j--){
            rv[j] = rv[j+1] + nums[j+1];
            //cout << rv[j] << " ";
        }
        for(int i=0;i<l;i++){
            if(lv[i]==rv[i]){
                return i;
            }
        }
        return -1;
    }
};