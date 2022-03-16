package Java.Programmers.Level_1.소수_찾기;

/**
 * 채점 결과
 * 정확성: 75.0
 * 효율성: 25.0
 * 합계: 100.0 / 100.0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(5)); // 3
        System.out.println(solution(10)); // 4
    }

    static int solution(int num) {
        int result = 0;
        for (int i = 2; i <= num; i++) {
            if (isPrime(i)) result++;
        }

        return result;
    }

    static boolean isPrime(int num) {
        if (num <= 1) return false;     // 1 이하의 수는 소수가 아니다.
        if (num == 2) return true;      // 2는 소수이다.
        if (num % 2 == 0) return false; // 2를 제외한 모든 짝수는 소수이다.

        int max = (int) Math.sqrt(num);
        for (int i = 3; i <= max; i += 2) {
            if (num % i == 0) return false;
        }

        return true;
    }
}