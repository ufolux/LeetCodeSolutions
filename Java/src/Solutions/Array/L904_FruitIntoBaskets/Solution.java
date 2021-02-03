package Solutions.Array.L904_FruitIntoBaskets;

class Solution {
    public int totalFruit1(int[] tree) {
        if (tree == null || tree.length == 0) return 0;
        int[] bucket = new int[tree.length];
        int start = 0, cnt = 0, maxCnt = 0;
        for (int i = 0; i < tree.length; i++) {
            if (bucket[tree[i]] == 0) cnt++;
            bucket[tree[i]]++;
            while (start <= i && cnt > 2) {
                if (bucket[tree[start]] == 1) cnt--;
                bucket[tree[start]]--;
                start++;
            }
            maxCnt = Math.max(maxCnt, i - start + 1);
        }
        return maxCnt;
    }

    public int totalFruit2(int[] tree) {
        if (tree == null || tree.length < 1) return 0;
        int len = tree.length, i = 1, start = 0, nextStart = 0;
        int a, b;
        while (i < len && tree[i] == tree[i - 1]) i++;
        int res = tree[i];
        while (i < len) {
            a = tree[i - 1];
            b = tree[i];
            start = nextStart;
            while (i < len && (tree[i] == a || tree[i] == b)) {
                if (tree[i] != tree[i - 1])
                    nextStart = i;
                i++;
            }
            res = Math.max(res, i - start);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.totalFruit1(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4});
        s.totalFruit1(new int[]{1, 2, 1});
        s.totalFruit1(new int[]{1, 2, 3, 2, 2});

        s.totalFruit2(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4});
        s.totalFruit2(new int[]{1, 2, 1});
        s.totalFruit2(new int[]{1, 2, 3, 2, 2});
    }
}
