class Solution {
public:
    int maxCoins(vector<int>& piles) {
        sort(piles.begin(),piles.end());
        reverse(piles.begin(),piles.end());
        int mp = 0;
        // for(int i=0;i<piles.size();i++){
        //     cout << piles[i] << endl;
        // }
        // cout << "piles" << endl;
        int i = 1, j =piles.size();
        while(i < j){
            mp = mp + piles[i];
            cout << piles[i] << " ";
            i = i + 2;
            j--;
        }   
         return mp;
    }
};