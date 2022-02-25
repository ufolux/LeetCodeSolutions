package Interviews.Snowflake;

import java.util.ArrayList;
import java.util.List;

public class PathToAGoal {
    public static void main(String[] args) {
        int [][] stdColor = {
                {0,0,0},
                {255,255,255}, // 54,21,234
                {255,0,0}, // 54,234,21
                {0,255,0},
                {0,0,255}
        };
        String px = "110010011110101000010101";
        String R = px.substring(0, 8);
        String G = px.substring(8, 16);
        String B = px.substring(16, 24);
        List<Integer> res = new ArrayList<>();
        res.add(Integer.parseInt(R, 2));
        res.add(Integer.parseInt(G, 2));
        res.add(Integer.parseInt(B, 2));
        System.out.println(res);

        for (int i = 0; i < stdColor.length; ++i) {
            int[] clr = stdColor[i];
            double d = Math.sqrt(Math.pow(res.get(0)-clr[0], 2) + Math.pow(res.get(1)-clr[1], 2) + Math.pow(res.get(2)-clr[2], 2));
            System.out.println(d);
        }
    }
}
