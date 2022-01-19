package Java.Programmers.Level_1.수박수박수박수박수박수;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(3)); // "수박수"
        System.out.println(solution(4)); // "수박수박"
    }

    static String solution(int n) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                answer.append("수");
            } else {
                answer.append("박");
            }
        }

        return answer.toString();
    }
}