package Java.Programmers.Level_1.없는_숫자_더하기;

import java.util.Arrays;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 6, 7, 8, 0})); // 14
        System.out.println(solution(new int[]{5, 8, 4, 0, 6, 7, 9})); // 6
    }

    // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 -> 45
    // 0, 4, 5, 6, 7, 8, 9 -> 39
    static int solution(int[] numbers) {
        Arrays.sort(numbers);
        int answer = 0;
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            answer += i;
            if (i > numbers.length - 1) {
                continue;
            }
            sum += numbers[i];
        }

        return answer - sum;
    }
}