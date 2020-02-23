package BasicAlgos.sort;

import java.util.*;

/**
 * 桶排序
 * 1）桶排序是稳定的；
 * 2）桶排序是常见排序算法中最快的一种，大多数情况下比快排和归并排序还要快
 * 3）桶排序非常快但是也非常消耗空间，典型的以空间换时间，基本上是最耗内存的一种排序算法。
 *
 * 基本思路：
 * 求出数组的极差是数组长度的多少倍，倍数就是桶的个数。
 * 然后再求出每个数字和最小值的差与数组长度的倍数，将这个倍数作为放入桶的下标，将该数字放入通中。
 * 将每个桶中的数字进行排序。
 * 按顺序输出每个桶中的数字即可得到有序数组。
 */
public class BucketSort {
    void sort(int[] nums) {
        // 获取桶的个数
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num: nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        // 极差是数组大小的多少倍就有多少个桶
        int bucketNum = (max - min) / nums.length + 1;

        List<List<Integer>> bucket = new ArrayList<>(bucketNum);
        // 初始化桶
        for (int i = 0; i < bucketNum; i++){
            bucket.add(new ArrayList<Integer>());
        }

        // 将元素放入桶
        for (int num: nums) {
            // 看元素和最小值的差值是数组大小的多少倍
            int n = (num - min) / nums.length;
            bucket.get(n).add(num);
        }

        // 对每个桶进行排序
        for (List<Integer> arr: bucket) {
            Collections.sort(arr);
        }

        // 合并数据到原数组
        int j = 0;
        for (List<Integer> arr: bucket) {
            for (Integer i : arr) {
                nums[j++] = i;
            }
        }
    }

    public static void main(String[] args) {
        BucketSort b = new BucketSort();
        int[] nums = new int[]{2,4,1,3,6,8,4,23,6,5,6,90,234,21,46,74,9,5};
        b.sort(nums);
        System.out.print(Arrays.toString(nums));
    }
}
