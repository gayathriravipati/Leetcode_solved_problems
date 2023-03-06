class Solution {
public:
    int findKthPositive(vector<int>& arr, int k) {
        int l = arr.size();
        set<int>s;
        
        for(int i=0;i<l;i++){
            s.insert(arr[i]);
        }
        
        int n = arr[l-1];
        int c=0;
        
        for(int i=1;i<=n;i++){
            if(s.find(i)==s.end()){
                c++;
                cout << i << " ";
                if(c==k){
                    return i;
                }
            }
        }
        cout << endl;
        while(c<k){
            n++;
            cout << n << " ";
            c++;
        }
        return n;
    }
};