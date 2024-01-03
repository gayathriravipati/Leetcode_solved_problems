class Solution {
public:
    int numberOfBeams(vector<string>& bank) {
        int l = bank.size();
        vector<int>arr(l,0);
        for(int i=0;i<l;i++){
            int to = 0;
            for(int j=0;j<bank[i].size();j++){
                if(bank[i][j]=='1'){
                    to++;
                }
            }
            arr[i] = to;
        }
        
        int res = 0;
        for(int i=0;i<l;i++){
            if(arr[i] > 0){
                int t = arr[i];
                for(int j = i+1; j<l;j++){
                    if(arr[j] > 0){
                        res = res + t * arr[j];
                        break;
                    }
                }
            }
        }
        return res;
    }
};