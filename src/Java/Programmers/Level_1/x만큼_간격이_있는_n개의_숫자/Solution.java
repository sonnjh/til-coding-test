package Java.Programmers.Level_1.x만큼_간격이_있는_n개의_숫자;

import java.util.Arrays;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(2, 5))); // "[2, 4, 6, 8, 10]"
        System.out.println(Arrays.toString(solution(4, 3))); // "[4, 8, 12]"
        System.out.println(Arrays.toString(solution(-4, 2))); // "[-4, -8]"
    }

    // x = 2
    // n = 5 -> 2 * 5 -> [10]
    // n = 4 -> 2 * 4 -> [10, 8]
    static long[] solution(int x, int n) {
        long[] answer = new long[n];
        while (n > 0) {
            answer[n - 1] = (long) x * n;
            n--;
        }

        return answer;
    }
}