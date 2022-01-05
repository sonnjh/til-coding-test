package Java.Programmers.Level_2.다음_큰_숫자;

/**
 * 채점 결과
 * 정확성: 70.0
 * 효율성: 30.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(78)); // 83
        System.out.println(solution(15)); // 23
    }

    // 조건 1. n의 다음 큰 숫자는 n보다 큰 자연수이다.
    // 조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같다.
    // 조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수이다.
    // ex) 78(1001110)의 다음 큰 숫자는 83(1010011)이다.

    static int solution(int n) {
        int answer = 0;
        int count  = Integer.bitCount(n);

        for (int i = n + 1; i <= 1000000; i++) {
            if (Integer.bitCount(i) == count) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}