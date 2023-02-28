class Solution {
public:
    int countPrimes(int n) {
        vector<bool>v(n,1);
        int ans=0;
        for(int i=2;i*i<n;i++){
            if(v[i]==0){
                continue;
            }
            for(int j=i*i;j<n;j+=i){
                v[j] = 0;
            }
        }
        for(int i=2;i<n;i++){
            if(v[i]==1){
                ans++;
            }
        }
        return ans;
    }
};