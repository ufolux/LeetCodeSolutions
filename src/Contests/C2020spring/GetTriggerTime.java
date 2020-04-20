package Contests.C2020spring;

import java.util.Arrays;

public class GetTriggerTime {
    /**
     * Beyond Time Limitation
     * @param increase
     * @param requirements
     * @return
     */
    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int[] vals = {0, 0, 0};
        int[] res = new int[requirements.length];
        Arrays.fill(res, -1);
        int[] triArr1 = checkTrigger(res, vals, requirements);
        for (int j = 0; j < triArr1.length; j++) {
            if (triArr1[j] == 1 && res[j] == -1) res[j] = 0;
        }
        for (int i = 0; i < increase.length; i++) {
            int[] inc = increase[i];
            vals[0] += inc[0];
            vals[1] += inc[1];
            vals[2] += inc[2];
            int[] triArr = checkTrigger(res, vals, requirements);
            for (int j = 0; j < triArr.length; j++) {
                if (triArr[j] == 1 && res[j] == -1) res[j] = i + 1;
            }
        }
        return res;
    }

    int[] checkTrigger(int[] res, int[] val, int[][] reqs) {
        int[] ans = new int[reqs.length];
        for (int i = 0; i < reqs.length; i++) {
            if (res[i] != -1) {
                ans[i] = 1;
                continue;
            }
            int[]req = reqs[i];
            boolean isTri = true;
            for (int j = 0; j < req.length; j++) {
                if (val[j] < req[j]) {
                    isTri = false;
                    break;
                }
            }
            if (isTri) {
                ans[i] = 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        GetTriggerTime g = new GetTriggerTime();
        g.getTriggerTime(new int[][]{{2,8,4},{2,5,0},{10,9,8}},
                new int[][]{{2,11,3},{15,10,7},{9,17,12},{8,1,14}});
    }
}
