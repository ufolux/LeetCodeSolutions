package BasicAlgos.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MergeSort {

    int[] swap;

    void merge(int[] arr, int left, int mid, int right) {
        int p1 = left, p2 = mid + 1, k = left;

        while (p1 <= mid && p2 <= right) {
            if (arr[p1] <= arr[p2]) {
                swap[k++] = arr[p1++];
            } else {
                swap[k++] = arr[p2++];
            }
        }

        while (p1 <= mid) swap[k++] = arr[p1++];
        while (p2 <= right) swap[k++] = arr[p2++];

        for (int i = left; i <= right; i++) {
            arr[i] = swap[i];
        }
    }

    void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        swap = new int[arr.length];
        int start = 0, end = arr.length - 1;
        mergeSort(arr, start, end);
    }

    public static void main(String[] args) {
        MergeSort m = new MergeSort();
        int[] arr = {2, 5, 1, 5, 1, 3, 7, 8, 9, 10, 21, 42, 11, 4};
        m.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
