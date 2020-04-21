package Solutions.String.L539_MinimumTimeDifference;
import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] minuteList = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            minuteList[i] = Integer.parseInt(timePoints.get(i).substring(0,2)) * 60
                    + Integer.parseInt(timePoints.get(i).substring(3,5));
        }
        Arrays.sort(minuteList);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < minuteList.length; i++) {
            minDiff = Math.min(minuteList[i] - minuteList[i - 1], minDiff);
        }
        return Math.min(minDiff, 1440 + minuteList[0] - minuteList[minuteList.length - 1]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.findMinDifference(Arrays.asList("23:59","00:00"));
    }
}
