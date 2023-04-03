class Solution {
public:
    int numRescueBoats(vector<int>& people, int limit) {
        int tc=0;
        int l = people.size();
        sort(people.begin(),people.end());
        int i=0,j=people.size()-1;
        //cout << i << j << "ij" << endl;
        while(i<=j){
            if(people[i]+people[j]<=limit){
                tc++;
                // cout << people[i] << " " << people[j] << endl;
                // cout << tc << endl;
                i++;
                j--;
            }
            else{
               tc++;
               j--;
               // cout << people[i] << " " << people[j] << "j" << endl;
               // cout << tc << endl;
            }
        }
       return tc;    
    }
};