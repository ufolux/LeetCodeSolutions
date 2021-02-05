//
// Created by sines on 2021/2/5 .
//
#include "PublicHeaders.h"
#include <Solutions/BaseSolution.h>

namespace UnionFind {
    namespace L323_NumberOfConnectedComponentsInAnUndirectedGraph {
        using namespace std;

        class UnionFind {
        private:
            vector<int> parents;
            vector<int> rank;
        public:
            UnionFind(int n) {
                parents.resize(n, -1);
                rank.resize(n, 0);
            }

            int find (int x) {
                int x_root = x;
                while (parents[x_root] != -1) {
                    x_root = parents[x_root];
                }
                return x_root;
            }

            void unionEles(int x, int y) {
                int x_root = find(x);
                int y_root = find(y);
                if (x_root == y_root) {
                    return;
                } else if (rank[x_root] > rank[y_root]) {
                    parents[y_root] = x_root;
                } else {
                    parents[x_root] = y_root;
                    rank[x_root]++;
                }
            }

            int graphNums() {
                return count(parents.begin(), parents.end(), -1);
            }

            bool connected(int x, int y) {
                int x_root = find(x);
                int y_root = find(y);
                return x_root == y_root && x_root != -1;
            }
        };

        class Solution : BaseSolution {
        private:
            int countComponents(int n, vector<vector<int>>& edges) {
                UnionFind uf(n);
                int len = edges.size();
                for (int i = 0; i < len; ++i) {
                    uf.unionEles(edges[i][0], edges[i][1]);
                }
                return uf.graphNums();
            }
        public:
            void run() override {
                vector<vector<int>> vec = {{0,1},{1,2},{3,4}};
                cout << "Graphs Num:" << countComponents(5, vec) << endl;
            }
        };
    }
}