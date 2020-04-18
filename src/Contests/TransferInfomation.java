package Contests;
import java.util.*;

public class TransferInfomation {
    int counter = 0;
    public int numWays(int n, int[][] relation, int k) {
        Map<Integer, List<Integer>> rel = new HashMap<>();
        for (int[] nums: relation) {
            if (rel.containsKey(nums[0])) {
                rel.get(nums[0]).add(nums[1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(nums[1]);
                rel.put(nums[0], list);
            }
        }
        dfs(n, rel, 0, 0, k);
        return counter;
    }

    void dfs (int n, Map<Integer, List<Integer>> map, int curuser, int step, int k) {
        if (step == k) {
            if (curuser == n - 1) counter++;
        } else {
            List<Integer> list = map.get(curuser);
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    dfs(n, map, list.get(i), step + 1, k);
                }
            }
        }
    }

    public static void main(String[] args) {
        TransferInfomation t = new TransferInfomation();
        t.numWays(5, new int[][]{{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}}, 3);
    }
}
