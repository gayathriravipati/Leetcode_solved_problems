class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int l = nums.size();
        map<int,int>c;
        map<int,int>::iterator it;
        for(int i=0;i<l;i++){
            c[nums[i]]++;
        }
        
        int a;
        for(it=c.begin();it!=c.end();it++){
            if(it->second > l/2){
               a = it->first;
                break;
            }
        }
        return a;
    }
};