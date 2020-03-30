package Solutions.Array.L347_TopKFrequentElements;

import java.util.*;

public class Solution {
    // 小顶堆
    public List<Integer> topKFrequent1(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> heap_min = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (Integer i: map.keySet()) {
            heap_min.offer(i);
            if (heap_min.size() > k) {
                heap_min.poll();
            }
        }
        while (!heap_min.isEmpty()) {
            list.add(heap_min.poll());
        }
        Collections.reverse(list);
        return list;
    }

    // 大顶堆
    public List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: nums) {
            map.put(i,map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer> heap_max = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (Integer key: map.keySet()) {
            heap_max.offer(key);
        }
        while (k-- != 0) {
            list.add(heap_max.poll());
        }
        return list;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        s.topKFrequent1(new int[]{1,1,1,2,2,3}, 2);
        s.topKFrequent2(new int[]{1,1,1,2,2,3}, 2);
    }
}
