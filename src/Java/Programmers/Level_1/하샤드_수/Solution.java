package Java.Programmers.Level_1.하샤드_수;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(10)); // true
        System.out.println(solution(12)); // true
        System.out.println(solution(11)); // false
        System.out.println(solution(13)); // false
    }

    static boolean solution(int x) {
        int divisor = x;

        int sum = 0;
        while (x != 0) {
            sum = sum + (x % 10);
            x = x / 10;
        }

        return divisor % sum == 0;
    }
}