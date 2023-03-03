class Solution {
public:
    int strStr(string haystack, string needle) {
        int h = haystack.size();
        int n = needle.size();
        int i,j;
        if(h<n){
            return -1;
        }
        else{
            vector<int>t;
            for(i=0;i<h;i++){
                if(haystack[i]==needle[0]){
                   t.push_back(i); 
                }
            }
            
            for(i=0;i<t.size();i++){
                cout << t[i] << "t" << endl;   
            }
            
            for(i=0;i<t.size();i++){
                j = t[i];
                int k = 0;
                int f = 0;
                while(k<n){
                    if(haystack[j]==needle[k]){
                        cout << j << "j" << endl;
                        k++;
                        j++;
                    }
                    else{
                        f = 1;
                        break;
                    }
                }
             if(f==0){
                 return t[i];
             }
                
            }
        }
        return -1;
    }
};