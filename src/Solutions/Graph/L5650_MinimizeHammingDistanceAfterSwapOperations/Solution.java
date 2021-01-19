package Solutions.Graph.L5650_MinimizeHammingDistanceAfterSwapOperations;

//        You are given two integer arrays, source and target, both of length n. You are also given an array allowedSwaps where each allowedSwaps[i] = [ai, bi] indicates that you are allowed to swap the elements at index ai and index bi (0-indexed) of array source. Note that you can swap elements at a specific pair of indices multiple times and in any order.
//
//        The Hamming distance of two arrays of the same length, source and target, is the number of positions where the elements are different. Formally, it is the number of indices i for 0 <= i <= n-1 where source[i] != target[i] (0-indexed).
//
//        Return the minimum Hamming distance of source and target after performing any amount of swap operations on array source.
//
//        Example 1:
//
//        Input: source = [1,2,3,4], target = [2,1,4,5], allowedSwaps = [[0,1],[2,3]]
//        Output: 1
//        Explanation: source can be transformed the following way:
//        - Swap indices 0 and 1: source = [2,1,3,4]
//        - Swap indices 2 and 3: source = [2,1,4,3]
//        The Hamming distance of source and target is 1 as they differ in 1 position: index 3.
//        Example 2:
//
//        Input: source = [1,2,3,4], target = [1,3,2,4], allowedSwaps = []
//        Output: 2
//        Explanation: There are no allowed swaps.
//        The Hamming distance of source and target is 2 as they differ in 2 positions: index 1 and index 2.
//        Example 3:
//
//        Input: source = [5,1,2,4,3], target = [1,5,4,2,3], allowedSwaps = [[0,4],[4,2],[1,3],[1,4]]
//        Output: 0
//
//        Constraints:
//
//        n == source.length == target.length
//        1 <= n <= 105
//        1 <= source[i], target[i] <= 105
//        0 <= allowedSwaps.length <= 105
//        allowedSwaps[i].length == 2
//        0 <= ai, bi <= n - 1
//        ai != bi

import java.util.*;

class UnionFind {
    private final int[] parent;
    private final int[] rank;
    UnionFind(int len) {
        parent = new int[len];
        Arrays.fill(parent, -1);
        rank = new int[len];
        Arrays.fill(rank, 0);
    }

    public int find (int x) {
        int x_root = x;
        while (parent[x_root] != -1) {
            x_root = parent[x_root];
        }
        return x_root;
    }

    public void union(int x, int y) {
        int x_root = find(x);
        int y_root = find(y);
        if (x_root == y_root)
            return;
        if (rank[x_root] > rank[y_root]) {
            parent[y_root] = x_root;
        } else if (rank[x_root] < rank[y_root]) {
            parent[x_root] = y_root;
        } else {
            parent[x_root] = y_root;
            rank[x_root]++;
        }
    }

    public boolean connect(int x, int y) {
        int x_root = find(x);
        int y_root = find(y);

        return x_root == y_root && x_root != -1 ;
    }
}

public class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int distance = 0;
        UnionFind uf = new UnionFind(source.length);
        for (int[] swap: allowedSwaps) {
            uf.union(swap[0], swap[1]);
        }

        // construct a relationship between value and key
        Map<Integer, List<Integer>> idxMap = new HashMap<>();
        for (int i = 0; i < target.length; ++i) {
            idxMap.putIfAbsent(target[i], new ArrayList<>());
            idxMap.get(target[i]).add(i);
        }

        for (int i = 0; i < source.length; ++i) {
            if (!idxMap.containsKey(source[i])) {
                distance++;
            } else {
                boolean flag = false;
                List<Integer> list = idxMap.get(source[i]);
                for (Integer idx: list) {
                    boolean isCon = uf.connect(idx, i);
                    if (isCon) {
                        list.remove(idx);
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    distance++;
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        int[] source = {1,2,3,4};
        int[] target = {2,1,4,5};
        int[][] allowedSwaps = {{0,1},{2,3}};
        Solution s = new Solution();
        int dis = s.minimumHammingDistance(source, target, allowedSwaps);
        System.out.println(dis);
    }
}
