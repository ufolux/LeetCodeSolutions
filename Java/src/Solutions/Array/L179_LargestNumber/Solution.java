package Solutions.Array.L179_LargestNumber;
import java.util.*;

public class Solution {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(String.valueOf(nums[i]));
        }
        Collections.sort(list, (a, b) -> {
            Long a1 = Long.valueOf(a + b);
            Long b1 = Long.valueOf(b + a);
            return (int) (b1 - a1);
        });
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.largestNumber(new int[]{3,30,34,5,9});
    }
}
