package Java.Programmers.Level_1.두_정수_사이의_합;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(3, 5)); // 12
        System.out.println(solution(5, 3)); // 12
        System.out.println(solution(3, 3)); // 3
    }

    static long solution(int a, int b) {
        long answer = 0;
        if (a == b) return a;
        if (a > b) for (int i = b; i <= a; i++) answer += i;
        if (a < b) for (int i = a; i <= b; i++) answer += i;

        return answer;
    }
}