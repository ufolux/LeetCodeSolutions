package BasicAlgos.sort;

import java.util.*;

/**
 * 基数排序
 * <p>
 * 基本思路：
 * 按照每一个数位进行排序，最终就能得到有序的数组
 * 先排个位，再排十位，以此类推
 */
public class RadixSort {
    /**
     * 获取数字的最大长度
     *
     * @param nums
     * @return
     */
    int getMaxLength(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, String.valueOf(num).length());
        }
        return max;
    }

    int getDigit(int num, int digit) {
        return (num / (int) Math.pow(10, digit - 1)) % 10;
    }

    void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int maxLength = getMaxLength(nums);

        List<Integer>[] counter = new List[10];
        for (int i = 1; i <= maxLength; i++) {
            for (int num : nums) {
                int digit = getDigit(num, i);
                if (counter[digit] == null) {
                    ArrayList<Integer> arr = new ArrayList();
                    arr.add(num);
                    counter[digit] = arr;
                } else {
                    counter[digit].add(num);
                }
            }
            int j = 0;
            for (List<Integer> arr: counter) {
                if (arr != null) {
                    for (int n = 0; n < arr.size(); n++) {
                        nums[j++] = arr.get(n);
                    }
                    arr.clear();
                }
            }
        }
    }

    public static void main(String[] args) {
        RadixSort r = new RadixSort();
        int[] nums = new int[]{2, 4, 1, 3, 6, 8, 4, 23, 6, 5, 6, 90, 234, 21, 46, 74, 9, 5};
        r.sort(nums);
        System.out.print(Arrays.toString(nums));
    }
}
