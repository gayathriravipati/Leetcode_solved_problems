class Solution {
public:
    double average(vector<int>& salary) {
        sort(salary.begin(),salary.end());
        int l = salary.size();
        double c=0;
        double s=0;
        for(int i=1;i<l-1;i++){
            c++;
            s = s + salary[i];
        }
        double r = s / c;
        return r;
    }
};