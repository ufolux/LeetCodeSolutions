package Solutions.L327_CountOfRangeSum;

public class Solution {
    /**
     * 借助数组积累累加结果 O(2)
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public int countRangeSum1(int[] nums, int lower, int upper) {
        long[]res=new long[nums.length];
        long sum=0;
        for (int i = 0; i <nums.length ; i++) {
            sum+=nums[i];
            res[i]=sum;
        }
        int r=0;
        for (int i = 0; i <nums.length ; i++) {
            if(res[i]>=lower&&res[i]<=upper){
                r++;
            }
            for (int j = 0; j <i ; j++) {
                long t=res[i]-res[j];
                if(t>=lower&&t<=upper){
                    r++;
                }
            }
        }
        return r;
    }

    public int countRangeSum2(int[] nums, int lower, int upper) {
        int r = 0;
        return r;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.countRangeSum1(new int[]{-2,5,-1}, -2, 2);
        s.countRangeSum2(new int[]{-2,5,-1}, -2, 2);
    }
}
