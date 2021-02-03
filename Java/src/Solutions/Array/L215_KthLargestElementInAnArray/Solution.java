package Solutions.Array.L215_KthLargestElementInAnArray;

public class Solution {
    /**
     * 三路快排
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest1(int[] nums, int k) {
        quickSort1(nums, 0, nums.length - 1, k);
        return nums[k - 1];
    }

    public void quickSort1 (int[] nums, int l, int r, int k) {
        if (l >= r) return;
        int pivot = nums[l];
        int lt = l; // [0..lt]
        int gt = r + 1; // [gt...r];
        int i = l + 1; // [lt + 1...i -1]
        while (i < gt) {
            if (nums[i] > pivot) {
                int temp = nums[i];
                nums[i] = nums[lt + 1];
                nums[lt + 1] = temp;
                ++lt;
                ++i;
            } else if (nums[i] < pivot) {
                int temp = nums[i];
                nums[i] = nums[gt - 1];
                nums[gt - 1] = temp;
                --gt;
            } else {
                ++i;
            }
        }
        int temp = nums[lt];
        nums[lt] = nums[l];
        nums[l] = temp;

        if (lt > k - 1) {
            quickSort1(nums, l, lt - 1, k);
        } else {
            quickSort1(nums, gt, r, k);
        }
    }


    public int findKthLargest2(int[] nums, int k) {
        return search(nums, 0, nums.length - 1, k);
    }

    int search (int[] nums, int l, int r, int k) {
        int pt = partition(nums, l, r);
        if (pt == k - 1) return nums[pt];
        else if (pt > k -1) return search(nums, l, pt - 1, k);
        else return search(nums, pt + 1, r, k);
    }

    void swap (int[] nums, int a, int b) {
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[b] ^ nums[a];
        nums[a] = nums[a] ^ nums[b];
    }

    int partition (int[] nums, int l, int r) {
        int pivot = nums[l];
        while (l < r) {
            pivot = nums[l];
            while (l < r && nums[r] <= pivot) r--;
            while (l < r && nums[l] > pivot) l++;
            swap(nums, r, l);
        }
        nums[l] = pivot;
        return l;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.findKthLargest1(new int[]{3,2,3,1,2,4,5,5,6}, 4);
        s.findKthLargest2(new int[]{3,2,3,1,2,4,5,5,6}, 4);
    }
}
