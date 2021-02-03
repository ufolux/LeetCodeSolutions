package Solutions.String.L681_NextClosestTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    Integer[] divideTime (String time) {
        Integer[] res = new Integer[4];
        int j = 0;
        for (int i = 0; i < time.length(); i++) {
            if (time.charAt(i) == ':') continue;
            res[j++] = time.charAt(i) - '0';
        }
        return res;
    }

    void permutate (List<List<Integer>> res, Integer[] time, int[] visited, List<Integer> tmp) {
        if (tmp.size() == time.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < time.length; i++) {
            tmp.add(time[i]);
            permutate(res, time, visited, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public int getMinutes (Integer[] ns) {
        return (ns[0] * 10 + ns[1]) * 60 + ns[2] * 10 + ns[3];
    }

    public boolean isValidTime(int srcMin, int dstMin, Integer[] dst) {
        return dst[0] * 10 + dst[1] < 24 && dst[2] * 10 + dst[3] < 60 ;
    }

    /**
     * Not the best optimized solution
     * 1. permutate all time;
     * 2. check time is valid;
     * 3. compare and get min diff
     * @param time
     * @return
     */
    public String nextClosestTime(String time) {
        if (time == null || time.length() == 0) return time;
        Integer[] timeArr = divideTime(time);
        List<List<Integer>> permutation = new ArrayList<>();
        int[] visited = new int[time.length()];
        permutate(permutation, timeArr, visited, new ArrayList<>());
        for (int i = 0; i < timeArr.length; i++) {
            permutation.add(Arrays.asList(timeArr[i],timeArr[i],timeArr[i],timeArr[i]));
        }
        int minutes = getMinutes(timeArr);
        int minDiff = Integer.MAX_VALUE;
        Integer[] minArr = new Integer[4];
        for (int i = 0; i < permutation.size(); i++) {
            Integer[] arr = (Integer[]) permutation.get(i).toArray(new Integer[4]);
            int dminutes = getMinutes(arr);
            if (isValidTime(minutes, dminutes, arr)) {
                if (minDiff > dminutes - minutes && dminutes - minutes > 0) {
                    minDiff = dminutes - minutes;
                    minArr = arr;
                } else if (minDiff > 1440 + dminutes - minutes) {
                    minDiff = 1440 + dminutes - minutes;
                    minArr = arr;
                }
            }
        }
        return (new StringBuffer())
                .append(minArr[0])
                .append(minArr[1])
                .append(":")
                .append(minArr[2])
                .append(minArr[3])
                .toString();
    }



    public static void main(String[] args) {
        Solution s = new Solution();
        s.nextClosestTime("19:34");
        s.nextClosestTime("23:59");
    }
}
