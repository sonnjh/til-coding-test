package Java.Programmers.Level_1.문자열_다루기_기본;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solutionB("a234")); // false
        System.out.println(solutionB("1234")); // true
    }

    // [0-9]{4}          -> 4글자, 0 ~ 9
    // [0-9]+            -> n글자, 0 ~ 9
    // [0-9]*            -> n글자, 0 ~ 9
    // [0-9]{4}|[0-9]{6} -> 4|6글자, 0 ~ 9

    static boolean solutionA(String s) {
        return s.matches("^[0-9]{4}|[0-9]{6}$");
    }

    static boolean solutionB(String s) {
        boolean answer = true;
        if (s.length() != 4 && s.length() != 6) return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') return false;
        }
        return answer;
    }
}