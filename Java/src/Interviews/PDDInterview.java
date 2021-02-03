package Interviews;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Given a matrix(2D array) containing binary digits with each row sorted,
 * this function will find the row which as maximum number of 1’s .
 * 0 0 0 1 1 1
 * 0 1 1 1 1 1
 * 0 0 0 0 1 1
 * 0 0 1 1 1 1
 * 0 0 0 1 1 1
 */
public class PDDInterview {
    /**
     * O(m*n)
     * @param mtx
     * @return
     */
    List<int[]> search1 (int[][] mtx) {
        List<int[]> res = new ArrayList<>();
        if (mtx == null || mtx[0].length == 0) return res;
        int maxLen = 0;
        for (int i = 0; i < mtx.length; i++) {
            for (int j = 0; j < mtx[i].length; j++) {
                if (mtx[i][j] == 1) {
                    int len = mtx[i].length - j;
                    if (len > maxLen) {
                        res.clear();
                        res.add(new int[]{i, len});
                        maxLen = len;
                    } else if (len == maxLen) {
                        res.add(new int[]{i, len});
                    }
                    break;
                }
            }
        }
        return res;
    }

    /**
     * O(mlogn)
     * @param mtx
     * @return
     */
    List<int[]> search2 (int[][] mtx) {
        List<int[]> res = new ArrayList<>();
        if (mtx == null || mtx[0].length == 0) return res;
        int maxLen = 0;
        for (int i = 0; i < mtx.length; i++) {
            int l = 0, r = mtx[i].length - 1;
            while (l < r) {
                int mid = l + ( r - l ) / 2;
                if (mtx[i][mid] == 1) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            int len = mtx[i].length - l;
            if (len > maxLen) {
                maxLen = len;
                res.clear();
                res.add(new int[]{i, len});
            } else if (len == maxLen) {
                res.add(new int[]{i, len});
            }
        }
        return res;
    }

    /**
     * O(m+n)
     * @param mtx
     * @return
     */
    List<int[]> search3 (int[][] mtx) {
        List<int[]> res = new ArrayList<>();
        if (mtx == null || mtx[0].length == 0) return res;
        int maxLen = 0;
        int idx = 0;
        // get the index of the 1st 1 in the arr
        for (int i = 0; i < mtx[0].length; i++) {
            if (mtx[0][i] == 1) {
                idx = i;
                break;
            }
        }

        for (int i = 1; i < mtx.length; i++) {
            if (mtx[i][idx] == 0) {
                continue;
            } else {
                while (mtx[i][idx] != 0) {
                    idx--;
                }
                idx++;
                int len = mtx[i].length - idx;
                if (len > maxLen) {
                    res.clear();
                    res.add(new int[]{i, len});
                    maxLen = len;
                } else if (len == maxLen) {
                    res.add(new int[]{i, len});
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PDDInterview p = new PDDInterview();
        int[][] mtx = {
                {0, 0, 0, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1},
                {0, 0, 1, 1, 1, 1},
                {0, 0, 0, 1, 1, 1},
        };
        p.search1(mtx);
        p.search2(mtx);
        p.search3(mtx);
    }
}
