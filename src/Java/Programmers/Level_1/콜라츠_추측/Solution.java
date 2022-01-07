package Java.Programmers.Level_1.콜라츠_추측;

/**
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(6)); // 8
        System.out.println(solution(16)); // 4
        System.out.println(solution(626331)); // -1
    }

    // 주어진 수를 1로 만들기 위해 몇 번의 작업을 수행해야 하는지
    // 1-1. 입력된 수가 짝수라면 2로 나눈다.
    // 1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더한다.
    // 2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복한다.

    // 6
    // 6 / 2 -> 3
    // 3 * 3 + 1 -> 10
    // 10 / 2 -> 5
    // 5 * 3 + 1 -> 16
    // 16 / 2 -> 8
    // 8 / 2 -> 4
    // 4 / 2 -> 2
    // 2 / 2 -> 1

    static int solution(long num) {
        int answer = 0;

        while (num != 1) {
            if (answer == 500) return -1;
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = num * 3 + 1;
            }
            answer++;
        }

        return answer;
    }
}
