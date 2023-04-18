class Solution {
public:
    vector<bool> kidsWithCandies(vector<int>& candies, int extraCandies) {
        int max = *max_element(candies.begin(), candies.end());
        cout << max << endl;
        int l =  candies.size();
        vector<bool>res(l);
        for(int i=0;i<l;i++){
            int a = candies[i]+extraCandies;
            if(a>=max){
                cout << a << "a" << endl;
                res[i] = true;
            }
            else{
                cout << a << "b" << endl;
                res[i] = false;
            }
        }
        return res;
    }
};