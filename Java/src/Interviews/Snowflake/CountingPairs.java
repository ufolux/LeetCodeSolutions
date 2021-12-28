package Interviews.Snowflake;

import java.util.Arrays;

public class CountingPairs {
    static int MAX=100000;
    int countPairsWithDiffK(int arr[], int n, int k) {
        int count = 0;
        Arrays.sort(arr); // Sort array elements

        int l = 0;
        int r = 0;
        while(r < n)
        {
            if(arr[r] - arr[l] == k)
            {
                count++;
                l++;
                r++;
            }
            else if(arr[r] - arr[l] > k)
                l++;
            else // arr[r] - arr[l] < sum
                r++;
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = { 1,2 };
        int n = arr.length;
        int k = 0;
        CountingPairs c = new CountingPairs();
        System.out.println("Count of pairs with given diff is "
                + c.countPairsWithDiffK(arr, n, k));
    }
}
