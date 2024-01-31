class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        int l = temperatures.size();
        vector<int>answer(l,0);
        stack<pair<int,int>>s;
        pair<int,int>p;
        
        for(int i=0;i<l;i++){
            if(s.empty()){
                s.push({temperatures[i],i});
            }
            else{
                p = s.top();
                while(s.size()!= 0 && (temperatures[i] > p.first)){
                    answer[p.second] = i - p.second;
                    s.pop();
                    if(s.size()!= 0){
                        p = s.top();
                    }
                }
                s.push({temperatures[i],i});
            }
        }
        return answer;
    }
};