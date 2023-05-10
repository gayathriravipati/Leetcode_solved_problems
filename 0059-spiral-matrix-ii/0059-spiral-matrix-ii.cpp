class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        if (n == 0) {
            return {};
        }
        vector<vector<int>> ans(n, vector<int>(n, 0));
        int left = 0, right = n-1, top = 0, bottom = n-1, num = 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                ans[top][i] = num++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                ans[i][right] = num++;
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans[bottom][i] = num++;
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans[i][left] = num++;
                }
                left++;
            }
        }
        return ans;
    }
};