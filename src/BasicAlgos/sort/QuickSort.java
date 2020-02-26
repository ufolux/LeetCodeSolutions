package BasicAlgos.sort;

import java.util.Arrays;

public class QuickSort {

    int getPivot (int[] arr, int left, int right) {
        int i = left, j = right;
        int mid = (left + right) / 2;
        int p = arr[mid];
        while (i < j) {
            while (i < j && arr[j] >= p) j--;
            if (i < j ) {
                arr[i] = arr[j];
                i++;
            }

            while (i < j && arr[i] < p) i++;
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = p;
        return i;
    }


    void quickSort(int[] arr, int left, int right) {
        // find the pivot
        // left recursive
        // left recursive
        // seem like merge sort
        if (left < right) {
            int pivot = getPivot(arr, left, right);
            quickSort(arr, left, pivot - 1);
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
