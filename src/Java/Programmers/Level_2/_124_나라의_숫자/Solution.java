package Java.Programmers.Level_2._124_나라의_숫자;

/**
 * 채점 결과
 * 정확성: 70.0
 * 효율성: 30.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(1)); // 1
        System.out.println(solution(2)); // 2
        System.out.println(solution(3)); // 4
        System.out.println(solution(4)); // 11
        System.out.println(solution(5)); // 12
        System.out.println(solution(6)); // 14
    }

    // 10진법 -> 124나라
    // 1 -> 1
    // 2 -> 2
    // 3 -> 4
    // 4 -> 11 (자릿수 올림)
    // 5 -> 12
    // 6 -> 14
    // 7 -> 21 (자릿수 올림)
    // 8 -> 22
    // 9 -> 24

    static String solution(int n) {
        // 3으로 나누었을 때 나머지가 0, 1, 2인 경우 저장할 값
        String[] rest = {"4", "1", "2"};
        String answer = "";

        // n = 5
        // -> answer = "2"
        // -> n = 1
        // -> answer = "1" + "2"
        do {
            answer = rest[n % 3] + answer;
            n = (n - 1) / 3;
        } while (n > 0);

        return answer;
    }
}