package Java.Programmers.Level_1.자릿수_더하기;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solutionA(123)); // 6
        System.out.println(solutionA(987)); // 6
        System.out.println(solutionB(123)); // 24
        System.out.println(solutionB(987)); // 24
    }

    // 987 % 10 = 7
    // 987 / 10 = 98.7 = 98
    // 98 % 10 = 8
    // 98 / 10 = 9.8 = 9
    // 9 % 10 = 9
    // 9 / 10 = 0

    static int solutionA(int n) {
        int answer = 0;
        while (n != 0) {
            answer += n % 10;
            n = n / 10;
        }

        return answer;
    }

    static int solutionB(int n) {
        String num = String.valueOf(n);
        int answer = 0;

        for (char c : num.toCharArray()) {
            answer = answer + (c - '0');
        }

        return answer;
    }
}