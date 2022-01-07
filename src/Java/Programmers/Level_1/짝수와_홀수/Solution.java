package Java.Programmers.Level_1.짝수와_홀수;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(3)); // Odd
        System.out.println(solution(4)); // Even
    }

    static String solution(int num) {
        if (num % 2 == 0) return "Even";
        else return "Odd";
    }
}