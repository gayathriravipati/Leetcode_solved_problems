class Solution {
public:
    int passThePillow(int n, int time) {
        int idx=1,f=0;
        while(time){
            if(f==0){
               idx++;
            }
            else{
                idx--;
            }
            if(idx==n){
                f=1;
            }
            else if(idx==1){
                f=0;
            }
            time--;
        }
        return idx;
    }
};