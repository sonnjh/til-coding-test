package Java.Programmers.Level_2.예상_대진표;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(2, 1, 2)); // 1
        System.out.println(solution(4, 2, 4)); // 2
        System.out.println(solution(8, 4, 7)); // 3
        System.out.println(solution(8, 4, 5)); // 3
    }

    // A, B는 서로 만날 때까지 각 라운드에서 승리한다.
    // 각 라운드의 승자는 다음 라운드에서 번호가 바뀐다.

    // [1, 2] [3, 4] [5, 6] [7, 8] [9, 10]
    // 5번이 3번으로 바뀐다면, (5 + 1) / 2 = 3
    // 6번이 3번으로 바뀐다면, (6 + 1) / 2 = 3.5 -> 3 (int)
    // (int) (x + 1) / 2
    static int solution(int n, int a, int b) {
        int answer = 1, L, R;

        // a, b가 서로 만나는 경우는 1 차이가 날 때이다.
        if (a > b) {
            L = b; R = a;
        } else {
            L = a; R = b;
        }

        while (true) {
            System.out.println("L: " + L + ", R: " + R);
            // L이 홀수(1), R - L = 1일 때 종료한다.
            if (L % 2 != 0 && R - L == 1) {
                break;
            }
            L = (L + 1) / 2;
            R = (R + 1) / 2;
            answer++;
        }

        return answer;
    }
}