class Solution {
public:
    int findMinArrowShots(vector<vector<int>>& points) {
        sort(points.begin(), points.end());
        int l = points.size();
        int c = 1;
        int pv = points[0][1];
        for (int i = 1; i < l; i++) {
            if (points[i][0] > pv) {
                c++;
                pv = points[i][1];
            }
            else{
                pv = min(pv,points[i][1]);
            }
        }
        return c;
    }
};
// class Solution {
// public:
//     int findMinArrowShots(vector<vector<int>>& points) {
//         if (points.empty()) {
//             return 0;
//         }

//         sort(points.begin(), points.end(), [](const vector<int>& a, const vector<int>& b) {
//             return a[1] < b[1];
//         });

//         int arrows = 1;
//         int end = points[0][1];

//         for (const vector<int>& interval : points) {
//             if (interval[0] > end) {
//                 arrows++;
//                 end = interval[1];
//             }
//         }

//         return arrows;
//     }
// };
