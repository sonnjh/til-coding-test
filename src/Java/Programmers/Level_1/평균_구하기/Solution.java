package Java.Programmers.Level_1.평균_구하기;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{5, 5})); // 5.0
        System.out.println(solution(new int[]{1, 2, 3, 4})); // 2.5
    }

    static double solution(int[] arr) {
        double answer = 0;
        for (int i : arr) {
            answer += i;
        }

        return answer / arr.length;
    }
}
