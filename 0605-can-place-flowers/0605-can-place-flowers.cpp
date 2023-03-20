class Solution {
public:
    bool canPlaceFlowers(vector<int>& flowerbed, int n) {
        int c=0;
        int l = flowerbed.size();
        for(int i=0;i<l;i++){
            if(n==c){
                return true;
            }
            
            if(flowerbed[i]==0){
                if(i-1>0 && i+1<l){
                    if((flowerbed[i-1]==0) && (flowerbed[i+1]==0)){
                    flowerbed[i]=1;
                    cout << i-1 << " " << i << " " <<i+1 << " " << "a" << endl;
                    c++;
                    if(n==c){
                        return true;
                    }
                    }
                }
                
                else if(i-1<0 && i+1<l){
                    if(flowerbed[i+1]==0){
                       flowerbed[i]=1;
                        cout << i- 1 << " " << i << " " <<i+1 << " " << "b" << endl;
                        c++; 
                        if(n==c){
                            return true;
                        }
                    }
                }
                else if(i-1>=0 && i+1>=l){
                    if(flowerbed[i-1]==0){
                       flowerbed[i]=1;
                        cout << i-1 << " " << i << " " <<i+1 << " " << "c" << endl;
                        c++;
                        if(n==c){
                            return true;
                        }
                    }
                }
              else if(i-1<0 &&i+1>=l){
                  flowerbed[i]=1;
                        cout << i-1 << " " << i << " " <<i+1 << " " << "c" << endl;
                        c++;
                        if(n==c){
                            return true;
                        }
              }
            }
        }
        return false;
    }
};