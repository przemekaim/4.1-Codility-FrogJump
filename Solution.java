package pl.java.frogjump;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        int X = 5;
        int[] A = {1, 3, 1, 5, 2, 3, 2, 4, 1, 5, 4}; // result = 7

        Solution solution = new Solution();
        int result = solution.solution(X, A);

        System.out.println("Result: " + result);
    }

    public int solution(int X, int[] A) {
        if (X == 1)
            return 0;

        int[] seconds = new int[X + 1];
        Arrays.fill(seconds, 100_001);
        int position;

        for (int k = 0; k < A.length; k++) {
            position = A[k];
            if (seconds[position] > k)
                seconds[position] = k;
        }

        int max = seconds[1];
        for (int i = 1; i < seconds.length; i++) {
            if (seconds[i] == 100_001)
                return -1;
            if (max < seconds[i])
                max = seconds[i];
        }

        return max;
    }
}
