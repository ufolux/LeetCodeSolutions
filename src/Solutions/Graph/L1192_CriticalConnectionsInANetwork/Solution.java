package Solutions.Graph.L1192_CriticalConnectionsInANetwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class UnionFind {
    int[] ranks;
    int[] parents;
    public UnionFind(int n) {
        ranks = new int[n];
        parents = new int[n];
        for (int i = 0; i < n; ++i) {
            parents[i] = i;
        }
    }

    public void makeUnion(int x, int y) {
        int x_root = find(x);
        int y_root = find(y);
        if (x_root == y_root) {
            // in the same graph
            return;
        }

        if (ranks[x_root] > ranks[y_root]) {
            parents[y_root] = x_root;
        } else if (ranks[x_root] < ranks[y_root]) {
            parents[x_root] = y_root;
        } else {
            parents[x_root] = y_root;
            ranks[x_root]++;
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    private int find (int x) {
        int x_root = x;
        while (parents[x_root] != x_root) {
            x_root = parents[x_root];
        }
        return x_root;
    }
}
class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int j = 0; j < connections.size(); j++) {
            UnionFind uf = new UnionFind(n);
            for (int i = 0; i < connections.size(); i++) {
                if (i == j) continue;
                List<Integer> list = connections.get(i);
                int x = list.get(0);
                int y =list.get(1);
                uf.makeUnion(x, y);
            }

            for (int k = 0; k < connections.size(); ++k) {
                List<Integer> list = connections.get(k);
                int x = list.get(0);
                int y =list.get(1);
                if (!uf.connected(x, y)) {
                    ans.add(connections.get(j));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 4;
        List<List<Integer>> list = Arrays.asList(
                Arrays.asList(0,1),
                Arrays.asList(1,2),
                Arrays.asList(2,0),
                Arrays.asList(1,3)
        );
        s.criticalConnections(n, list);
    }
}
