class Solution {
public:
    bool totalhours(vector<int>& time,long long n, int totalTrips){
        long long int tv = 0;
        for(int i=0;i<time.size();i++)
        {
            tv = tv + (n / time[i]);
        }
        return tv >=totalTrips;
    }
    
    long long minimumTime(vector<int>& time, int totalTrips) {
        long long int l = time.size();
        long long int right = 1LL * *max_element(time.begin(), time.end()) * totalTrips;
        long long int left = 1;
        while(left<right){
            long long m = (left + right) / 2;
            if(totalhours(time,m,totalTrips)){
                right = m;
            }
            else{
                left = m+1;
            }
        }
        return left;
    }
};