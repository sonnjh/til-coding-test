package Java.Programmers.Level_2.숫자의_표현;

/**
 * 채점 결과
 * 정확성: 70.0
 * 효율성: 30.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(1)); // 1
        System.out.println(solution(15)); // 4
    }

    // 15 = 15
    // 1 + 2 + 3 + 4 + 5 = 15
    // 4 + 5 + 6 = 15
    // 7 + 8 = 15
    // i = 1 -> 합계 반복
    // i = 4 -> 합계 반복
    // i = 7 -> 합계 반복

    static int solution(int n) {
        int answer = 1;
        int sum    = 0;

        for (int i = 1; i < n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum += j;
                if (sum > n) break;
                if (sum == n) {
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }

    // 1, 2, 3, 4, 5, ...
    // 1, 3, 6, 10, 15, ...
    // 1, (1 + 2), (1 + 2 + 3), (1 + 2 + 3 + 4), (1 + 2 + 3 + 4 + 5), ...

    // static int solution(int n) {
    //     // if (n == 0) return 0;
    //     int answer = 1; // n = 15일 때 15로 표현할 수 있으므로 기본 값은 1이다.
    //     int sum    = 0;
    //     for (int i = 1; i < n; i++) {
    //         sum += i;
    //         if (sum % n == 0) {
    //             answer++;
    //         }
    //     }
    //
    //     return answer;
    // }
}