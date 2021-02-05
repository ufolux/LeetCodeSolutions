//
// Created by sines on 2021/2/5 .
//
#include "PublicHeaders.h"
#include <Solutions/BaseSolution.h>

namespace Array {
    namespace L54_SpiralMatrix {
        using namespace std;
        class Solution : BaseSolution {
        private:
            vector<int> spiralOrder(vector<vector<int>>& matrix) {
                int m = matrix.size();
                int n = matrix[0].size();
                int x = 0, y = 0;
                vector<int> ans;
                const int visited = INT_MAX;
                bool cr = true, cd = true, cl = true, cu = true;
                while (cr || cd || cl || cu) {
                    ans.push_back(matrix[x][y]);
                    matrix[x][y] = visited;
                    cr = y + 1 < n && matrix[x][y + 1] != visited;
                    cd = x + 1 < m && matrix[x + 1][y] != visited;
                    cl = y - 1 >= 0 && matrix[x][y - 1] != visited;
                    cu = x - 1 >= 0 && matrix[x - 1][y] != visited;

                    if (cr) {
                        if (cu) x--;
                        else y++;
                    } else if (cd) {
                        x++;
                    } else if (cl) {
                        y--;
                    } else if (cu) {
                        x--;
                    }
                }
                return ans;
            }
        public:
            void run() override {
                vector<vector<int>> matrix = {{1,2,3},{4,5,6},{7,8,9}};
                auto ans = spiralOrder(matrix);
                for (auto e: ans) {
                    cout << e << " " << endl;
                }
            }
        };
    };
};