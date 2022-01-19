package Java.Programmers.Level_1.문자열을_정수로_바꾸기;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("1234")); // "1234"
        System.out.println(solution("-1234")); // "-1234"
    }

    static int solution(String s) {
        return Integer.parseInt(s);
    }
}