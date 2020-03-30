package BasicAlgos.sort;

import java.util.Arrays;

public class QuickSort {

    int getPivot (int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        int l = left, r = right, m = arr[mid];
        while (l != r) {
            while (l < r && arr[l] <= m) l++;
            while (l < r && arr[r] > m) r--;

            if (l < r) {
                int t = arr[r];
                arr[r] = arr[l];
                arr[l] = t;
            }
        }
        arr[mid] = arr[l];
        arr[l] = m;
        return l;
    }


    void quickSort(int[] arr, int left, int right) {
        // find the pivot
        // left recursive
        // right recursive
        // seem like merge sort
        if (left < right) {
            int pivot = getPivot(arr, left, right);
            quickSort(arr, left, pivot - 1); // pivot not include
            quickSort(arr, pivot + 1, right);
        }
    }

    void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        int[] arr = {2, 5, 1, 5, 1, 3, 7, 8, 9, 10, 21, 42, 11, 4};
        q.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
