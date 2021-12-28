package Interviews.Snowflake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Global Maximum HackerRank
public class GlobalMaximum {
    boolean can_place(int A[], int n, int B, int mid) {
        int count = 1;
        int last_position = A[0];

        // If a subsequence of size B
        // with min diff = mid is possible
        // return true else false
        for(int i = 1; i < n; i++) {
            if (A[i] - last_position >= mid) {
                last_position = A[i];
                count++;
                if (count == B) {
                    return true;
                }
            }
        }
        return false;
    }


    int find_max_difference(int A[], int B) {
        // Sort the Array
        Arrays.sort(A);
        // Stores the boundaries
        // of the search space
        int n = A.length;
        int s = 0;
        int e = A[n - 1] - A[0];

        // Store the answer
        int ans = 0;
        // Binary Search
        while (s <= e) {
            int mid = (s + e) / 2;

            // If subsequence can be formed
            // with min diff mid and size B
            if (can_place(A, n, B, mid)) {
                ans = mid;
                // Right half
                s = mid + 1;
            } else {

                // Left half
                e = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        GlobalMaximum gm = new GlobalMaximum();
        gm.find_max_difference(new int[]{1,2,3,4}, 3);
    }
}
