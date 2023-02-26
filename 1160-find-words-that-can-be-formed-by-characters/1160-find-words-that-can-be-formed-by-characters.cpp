class Solution {
public:
    int countCharacters(vector<string>& words, string chars){
        int wl = words.size();
        int cl = chars.size();
        int c[26] = {0};
        
        for(int i=0;i<cl;i++){
            c[chars[i] - 'a']++;
        }
        
        for(int i=0;i<26;i++){
            cout << c[i] << " ";
        }
        
        int fin = 0;
        for(int i=0;i<wl;i++){
            int w[26] = {0};
            int z = 0;
            string s = words[i];
            int il = s.size();
            for(int j=0;j<il;j++){
                w[s[j] - 'a']++;
            }
            cout << endl;
            for(int j=0;j<26;j++){
                cout << w[j] << " ";
            }

            for(int j=0;j<il;j++){
               if(w[s[j] - 'a'] > c[s[j] - 'a']){
                   z = 1;
                   break;
               } 
            }
            if(z==0){
                fin = fin + il; 
            }
            
        }
        return fin;
    }
};