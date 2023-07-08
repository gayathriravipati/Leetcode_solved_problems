class Solution {
public:
    long long putMarbles(vector<int>& w, int k) {
    if (k == 1 || k == w.size())
        return 0;
    vector<long long> gaps;
    transform(begin(w), prev(end(w)), begin(w) + 1, back_inserter(gaps), plus());    
    sort(begin(gaps), end(gaps));
    k = min(k, (int)w.size() - k + 1);
    return transform_reduce(rbegin(gaps), rbegin(gaps) + k - 1, begin(gaps), 0LL, plus(), minus());
}
};