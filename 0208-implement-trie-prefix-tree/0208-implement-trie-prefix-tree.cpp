class Trie {
public:
    
    map<string,int>mpw,mpp;
    
    Trie() {
    }
    
    void insert(string word) {
        int l = word.size();
        mpw[word]++;
        string s;
        for(auto i:word){
            s.push_back(i);
            mpp[s]++;
        }
    }
    
    bool search(string word) {
        if(mpw[word]){
            return true;
        }
        else{
            return false;
        }
    }
    
    bool startsWith(string prefix) {
        if(mpp[prefix]){
            return true;
        }
        else{
            return false;
        }
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */