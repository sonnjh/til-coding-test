package Java.Programmers.Level_1.예산;

import java.util.Arrays;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 2, 5, 4}, 9)); // 3
        System.out.println(solution(new int[]{2, 2, 3, 3}, 10)); // 4
    }

    static int solution(int[] departments, int budget) {
        Arrays.sort(departments);
        int answer = 0;
        int sum = 0;

        // [1, 2, 3, 4, 5]의 첫 번째 값부터 더하면서 예산보다 커질 때 종료한다.
        for (int request : departments) {
            sum += request;
            if (sum > budget) {
                break;
            }

            answer++;
        }

        return answer;
    }
}