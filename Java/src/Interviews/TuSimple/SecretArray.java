package Interviews.TuSimple;

import java.util.List;

public class SecretArray {
    public static int countAnalogousArrays(List<Integer> consecutiveDifference, int lowerBound, int upperBound) {
        int count = 0;
        int min = lowerBound, max = lowerBound;
        int prev = lowerBound, curr = 0;
        for ( int i = 1; i<= consecutiveDifference.size(); i++ ){
            curr = prev - consecutiveDifference.get(i-1);
            min = Math.min(min, curr);
            max = Math.max(max, curr);
            prev = curr;
        }

        while (max <= upperBound ){
            if ( min >= lowerBound ) count++;
            min = min + 1;
            max = max + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        SecretArray sa = new SecretArray();
        sa.countAnalogousArrays(List.of(-2,-1,-2,5), 3, 10);
    }
}
