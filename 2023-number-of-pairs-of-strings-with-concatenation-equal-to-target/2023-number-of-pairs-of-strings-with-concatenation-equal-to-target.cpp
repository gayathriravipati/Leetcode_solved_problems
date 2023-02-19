class Solution {
public:
    int numOfPairs(vector<string>& nums, string target) {
        vector<int>len;
        int l = nums.size();
        int t = target.size();
        map<string,int>mp;
        map<string,int>::iterator itr;
        for(int i=0;i<l;i++){
            mp[nums[i]]++;
        }
        
        int c=0;
        for(int i=0;i<l;i++){
            int sl = nums[i].size();
            if(nums[i]==target.substr(0,sl)){
                if(mp.find(target.substr(sl,t))!=mp.end()){
                    if(target.substr(sl,t)==target.substr(0,sl)){
                        if(mp[target.substr(sl,t)]-1>0){
                            c = c + mp[target.substr(sl,t)]-1;
                        }
                    }
                    else{
                        c = c+mp[target.substr(sl,t)];
                    }
                }
            }
        }
        return c;
    }
};