//
// Created by sines on 2021/2/11 .
//
#include "PublicHeaders.h"
#include <Solutions/BaseSolution.h>

namespace Search_BFS_DFS_Backtrace {
    namespace L130_SurroundedRegions {
        using namespace std;

        class Solution : BaseSolution {
        private:
            void dfs(vector<vector<char>>& board, int r, int c) {
                int rows = board.size();
                int cols = board.front().size();
                if (c < 0 || c > cols - 1 || r < 0 || r > rows - 1 || board[r][c] != 'O') {
                    return;
                }
                board[r][c] = '.';
                dfs(board, r - 1, c);
                dfs(board, r + 1, c);
                dfs(board, r, c - 1);
                dfs(board, r, c + 1);
            }

            void solve(vector<vector<char>>& board) {
                int rows = board.size();
                if (rows == 0) return;
                int cols = board.front().size();
                // flip all O on the border to .
                for (int i = 0; i < rows; ++i) {
                    if (board[i][0] == 'O') dfs(board, i, 0);
                    if (board[i][cols - 1] == 'O') dfs(board, i, cols - 1);
                }
                for (int i = 0; i < cols; ++i) {
                    if (board[0][i] == 'O') dfs(board, 0, i);
                    if (board[rows - 1][i] == 'O') dfs(board, rows - 1, i);
                }

                for (int i = 0; i < rows; ++i) {
                    for (int j = 0; j < cols; ++j) {
                        if (board[i][j] == 'O') board[i][j] = 'X';
                        else if (board[i][j] == '.') board[i][j] = 'O';
                    }
                }
            }
        public:
            void run() override {
                vector<vector<char>> board = {
                        {'X', 'X', 'X', 'X'},
                        {'X', 'O', 'O', 'X'},
                        {'X', 'X', 'O', 'X'},
                        {'X', 'O', 'X', 'X'}
                };
                solve(board);
                OutputUtils::printMatrix(board);
            }
        };
    }
}