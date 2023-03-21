class Solution {
public:
    long long zeroFilledSubarray(vector<int>& nums) {
        long long l = nums.size();
        long long zc = 0;
        long long c=0, j, i;
        vector<long long>t;
        
        for(i=0;i<l;i++){
            if(nums[i]==0){
                cout << i << "i"<<endl;
                c++;
                zc++;
                for(j=i+1;j<l;j++){
                    if(nums[j]==0){
                       c++; 
                       zc++;
                    }
                    else{
                        //cout << "d";
                        t.push_back(c);
                        c=0;
                        //cout << c << "c";
                        i = j;
                       // cout << endl << i << "z";
                        break;
                    }
                }
                if(c>0){
                    t.push_back(c);
                    c=0;
                    i=j;
                }
            }
        }
        if(c > 0){
            t.push_back(c);
            c=0;
        }
        long long zl = t.size();
        long long r = 0;
        
        cout << zc << endl;
        
        for(long long j=0;j<zl;j++){
            //cout << t[j] << "h" << " ";
        }
        
        for(long long j=0;j<zl;j++){
            long long a = t[j];
           // cout << a << "b" << endl;
            long long b = (a * (a+1)) / 2;
            //cout << b << "a" << endl;
            r = r + b;
            //cout << r << "r" << endl;
        }
        return r;
    }
};