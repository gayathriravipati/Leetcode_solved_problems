class Solution {
public:
    int minPairSum(vector<int>& nums) {
      int l = nums.size();
      sort(nums.begin(),nums.end());
      int m = INT_MIN;
      int i=0,j=l-1;
      while(i<j){
          int s = nums[i] + nums[j];
          if(s > m){
              m = s;
          }
          i++;
          j--;
      }
        return m;
    }
};