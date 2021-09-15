package Java.Programmers.Level_1.음양_더하기;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(
                new int[]{4, 7, 12},
                new boolean[]{true, false, true}
        )); // 9
        System.out.println(solution(
                new int[]{1, 2, 3},
                new boolean[]{false, false, true}
        )); // 0
    }

    // 4, -7, 12 -> 9
    // -1, -2, 3 -> 0
    static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for (int i = 0; i < absolutes.length; i++) {
            int absolute = absolutes[i];
            boolean sign = signs[i];

            if (sign) {
                answer += absolute;
            } else {
                answer += -(absolute);
            }
        }

        return answer;
    }
}