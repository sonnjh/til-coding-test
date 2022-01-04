package Java.Programmers.Level_1.나누어_떨어지는_숫자_배열;

import java.util.Arrays;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{5, 9, 7, 10}, 5))); // [5, 10]
        System.out.println(Arrays.toString(solution(new int[]{2, 36, 1, 3}, 1))); // [1, 2, 3, 36]
        System.out.println(Arrays.toString(solution(new int[]{3, 2, 6}, 10)));    // [-1]
    }

    // [5, 7, 9, 10] % 5  == 0
    // [1, 2, 3, 36] % 1  == 0
    // [2, 3, 6]     % 10 == 0

    static int[] solution(int[] arr, int divisor) {
        int idx = 0;
        int[] answer = {};
        Arrays.sort(arr);

        for (int i : arr) {
            if (i % divisor == 0) {
                answer = Arrays.copyOf(answer, answer.length + 1);
                answer[idx++] = i;
            }
        }

        if (answer.length == 0) {
            answer = Arrays.copyOf(answer, answer.length + 1);
            answer[0] = -1;
        }

        return answer;
    }
}