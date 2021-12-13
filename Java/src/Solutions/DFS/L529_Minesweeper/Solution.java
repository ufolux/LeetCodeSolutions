package Solutions.DFS.L529_Minesweeper;

public class Solution {
    int mineNumber(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        int cnt = 0;
        cnt = i - 1 >= 0 ? (board[i-1][j] == 'M' ? cnt + 1 : cnt) : cnt;
        cnt = i + 1 < m ? (board[i+1][j] == 'M' ? cnt + 1 : cnt ) : cnt;
        cnt = j - 1 >= 0 ? (board[i][j-1] == 'M' ? cnt + 1 : cnt ) : cnt;
        cnt = j + 1 < n ? (board[i][j+1] == 'M' ? cnt + 1 : cnt ) : cnt;
        cnt = i - 1 >= 0 && j - 1 >= 0 ? (board[i-1][j-1] == 'M' ? cnt + 1 : cnt ) : cnt;
        cnt = i + 1 < m && j - 1 >= 0 ? (board[i+1][j-1] == 'M' ? cnt + 1 : cnt ) : cnt;
        cnt = i - 1 >= 0 && j + 1 < n ? (board[i-1][j+1] == 'M' ? cnt + 1 : cnt ) : cnt;
        cnt = i + 1 < m && j + 1 < n ? (board[i+1][j+1] == 'M' ? cnt + 1 : cnt ) : cnt;
        return cnt;
    }

    public void revealEmpty(char[][] board, int i, int j) {
        if (i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] == 'B') return;
        if (board[i][j] == 'E') {
            int num = mineNumber(board, i, j);
            if (num == 0) {
                board[i][j] = 'B';
                revealEmpty(board, i - 1, j);
                revealEmpty(board, i + 1, j);
                revealEmpty(board, i, j - 1);
                revealEmpty(board, i, j + 1);
                revealEmpty(board, i + 1, j - 1);
                revealEmpty(board, i - 1, j - 1);
                revealEmpty(board, i + 1, j + 1);
                revealEmpty(board, i - 1, j + 1);
            } else {
                board[i][j] = (char)('0' + num);
            }
        }
    }

    public void revealMine(char[][] board, int i, int j) {
        board[i][j] = 'X';
    }
    public char[][] updateBoard(char[][] board, int[] click) {
        int i = click[0];
        int j = click[1];
        if (board[i][j] == 'E') {
            revealEmpty(board, i, j);
        } else if (board[i][j] == 'M') {
            revealMine(board, i, j);
        }
        return board;
    }

    public static void main(String[] args) {
        char[][] arr = {
                {'E','E','E','E','E'},
                {'E','E','M','E','E'},
                {'E','E','E','E','E'},
                {'E','E','E','E','E'}
        };
        Solution s = new Solution();
        s.updateBoard(arr, new int[]{3,0});
        System.out.println(arr);
    }
}
