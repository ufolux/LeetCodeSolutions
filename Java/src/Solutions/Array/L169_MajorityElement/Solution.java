package Solutions.Array.L169_MajorityElement;

import java.util.HashMap;
import java.util.Map;

class Solution {
    /**
     * 摩尔投票法
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        int cnt = 1;
        int ele = nums[0];
        for (int i = 1; i < nums.length; i++ ) {
            if (nums[i] == ele)
                cnt++;
            else
                cnt--;

            if (cnt == 0) {
                ele = nums[i];
                cnt = 1;
            }
        }
        return ele;
    }

    /**
     * HashMap
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums) {
            if (!map.containsKey(n)) {
                map.put(n, 1);
            } else {
                map.put(n, map.get(n) + 1);
            }
        }

        for (Integer key: map.keySet()) {
            if (map.get(key) > nums.length / 2)
                return key;
        }
        return 0;
    }
}
