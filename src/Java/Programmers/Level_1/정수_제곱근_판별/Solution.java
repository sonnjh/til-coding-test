package Java.Programmers.Level_1.정수_제곱근_판별;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(3)); // -1
        System.out.println(solution(121)); // 144
    }

    // n이 양의 정수 x의 제곱이라면 x + 1의 제곱을 리턴한다.
    // n이 양의 정수 x의 제곱이 아니라면 -1을 리턴한다.

    static long solution(long n) {
        long answer = -1;
        double x = Math.sqrt(n);
        if (x % 1 == 0) {
            answer = (long) Math.pow(x + 1, 2);
        }

        return answer;
    }
}